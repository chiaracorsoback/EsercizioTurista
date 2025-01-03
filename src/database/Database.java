package database;

import entities.Abitazione;
import entities.Feedback;
import entities.Prenotazione;
import entities.Utente;

import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import static java.util.Map.*;

public class Database {
    private static HashMap<Integer, Utente> utenti = new HashMap<>();
    private static HashMap<Integer, Abitazione> abitazioni = new HashMap<>();
    private static HashMap<Integer, Prenotazione> prenotazioni = new HashMap<>();
    private static HashMap<Integer, Feedback> feedbacks = new HashMap<>();


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
    public static void addFeedback(Feedback feedback) {
        feedbacks.put(feedback.getId(), feedback);
    }
    public static void removeFeedback(Feedback feedback) {
        feedbacks.remove(feedback.getId());
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

    public static Abitazione getAbitazionePiuGettonata(){
        LocalDate meseOggi= LocalDate
                .of(LocalDate.now().getYear(),LocalDate.now().getMonth(),1);

        Integer idAbitazione =
                feedbacks   .values()
                            .stream()
                            .filter(feedback -> feedback.getData().isAfter(meseOggi))
                            .collect(Collectors.groupingBy(
                                    Feedback::getIdAbitazione, // Chiave: idAbitazione
                                    Collectors.averagingInt(Feedback::getPunteggio) // Media dei punteggi
                            )).entrySet()
                            .stream()
                            .max(Entry.comparingByValue())
                            .map(Entry::getKey) // Estrai solo la chiave
                            .orElse(null);

        return abitazioni.get(idAbitazione);
    }

    public static Set<Utente> getUtentiMaxPrenotazioni(){
        LocalDate meseOggi= LocalDate
                .of(LocalDate.now().getYear(),LocalDate.now().getMonth(),1);

        Map<Utente, Long> prenotazioniPerUtenteEntroMese = prenotazioni.values()
                .stream()
                .filter(prenotazione -> prenotazione.getEnd().isAfter(meseOggi))
                .collect(Collectors.groupingBy(
                        Prenotazione::getUtente,
                        Collectors.counting()
                ));
        Long max = prenotazioniPerUtenteEntroMese       .values()
                                                        .stream()
                                                        .max(Long::compare)
                                                        .orElse(null);
        return prenotazioniPerUtenteEntroMese   .entrySet()
                                                .stream()
                                                .filter( entryUtenteLong -> entryUtenteLong.getValue().equals(max))
                                                .collect(Collectors.toMap(Entry::getKey, Entry::getValue))
                                                .keySet();
    }

    public static Set<Utente> getSuperHosts(){

        Map<Utente, Long> prenotazioniPerUtente = prenotazioni  .values()
                                                                .stream()
                                                                .collect(Collectors.groupingBy(
                                                                        Prenotazione::getUtente,
                                                                        Collectors.counting()
                                                                ));
        return prenotazioniPerUtente.entrySet()
                                    .stream()
                                    .filter(entryUtenteLong -> entryUtenteLong.getValue()>=100)
                                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue))
                                    .keySet();


    }

    public static Set<Utente> getUtentiPiuGiorniPrenotati(){
        LocalDate meseOggi= LocalDate
                .of(LocalDate.now().getYear(),LocalDate.now().getMonth(),1);

        Map<Utente, Long> giorniPerUtente = prenotazioni.values().stream()
                .filter(prenotazione -> prenotazione.getEnd().isAfter(meseOggi)) // Filtra prenotazioni dell'ultimo mese
                .collect(Collectors.groupingBy(
                        Prenotazione::getUtente, // Raggruppa per utente
                        Collectors.summingLong(Prenotazione::getGiorniPermanenza) // Somma i giorni di permanenza
                ));

        // Crea una lista di soli utenti, ordinata per giorni di permanenza (decrescente)
        Set<Utente> utentiTop5 = giorniPerUtente.entrySet()
                                                .stream()
                                                .sorted((entry1, entry2) -> Long.compare(entry2.getValue(), entry1.getValue())) // Ordinamento decrescente in base ai giorni
                                                .limit(5) // Selezioniamo solo i primi 5
                                                .map(Map.Entry::getKey) // Estraiamo solo gli utenti
                                                .collect(Collectors.toSet()); // Collezioniamo la lista di utenti

        return utentiTop5;
    }


}
