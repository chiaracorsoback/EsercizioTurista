package entities;

import java.time.LocalDate;

public class Prenotazione {
    private static Integer idTot = 0;
    private Integer id;
    private LocalDate start;
    private LocalDate end;
    private Abitazione abitazione;
    private Utente utente;

    public Prenotazione(LocalDate start, LocalDate end, Abitazione abitazione, Utente utente) {
        this.id = ++idTot;
        this.start = start;
        this.end = end;
        this.abitazione = abitazione;
        this.utente = utente;
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Abitazione getAbitazione() {
        return abitazione;
    }

    public void setAbitazione(Abitazione abitazione) {
        this.abitazione = abitazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
