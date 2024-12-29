package database;

import entities.Abitazione;
import entities.Prenotazione;
import entities.Utente;
import java.util.Comparator;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class Database {
    private static HashMap<Integer, Utente> utenti = new HashMap<>();
    private static HashMap<Integer, Abitazione> abitazioni = new HashMap<>();
    private static HashMap<Integer, Prenotazione> prenotazioni = new HashMap<>();

    public static void addUtente(Utente utente) {
        utenti.put(utente.getId(), utente);
    }
    public static void removeUtente(Utente utente) {
        utenti.remove(utente.getId());
    }
    public static void addAbitazione(Abitazione abitazione) {
        abitazioni.put(abitazione.getId(), abitazione);
    }
    public static void removeAbitazione(Abitazione abitazione) {
        abitazioni.remove(abitazione.getId());
    }
    public static void addPrenotazione(Prenotazione prenotazione) {
        prenotazioni.put(prenotazione.getId(), prenotazione);
    }
    public static void removePrenotazione(Prenotazione prenotazione) {
        prenotazioni.remove(prenotazione.getId());
    }
    public static Set<Abitazione> getAbitazioniByCodiceHost (String codice) {
        return abitazioni   .values()
                            .stream()
                            .filter(abitazione -> codice.equals(abitazione.getCodiceHost()))
                            .collect(Collectors.toSet());
    }

    public static Prenotazione getLastPrenotazioneByIdUtente (Integer id) {
        return prenotazioni .values()
                            .stream()
                            .filter(prenotazione -> id.equals(prenotazione.getUtente().getId()))
                            .min(Comparator.comparing(prenotazione -> ChronoUnit.DAYS.between(prenotazione.getStart(), LocalDate.now())))
                            .orElse(null);
    }
}
