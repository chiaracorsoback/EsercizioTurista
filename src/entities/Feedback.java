package entities;

import java.time.LocalDate;

public class Feedback {
    private static Integer idTot = 0;
    private Integer id;
    private Integer idAbitazione;
    private String titolo;
    private String testo;
    private Integer punteggio;
    private LocalDate data;

    public Feedback(String titolo,Integer idAbitazione, String testo, Integer punteggio,LocalDate data) {
        this.id = ++idTot;
        this.idAbitazione=idAbitazione;
        this.titolo = titolo;
        this.testo = testo;
        this.punteggio = punteggio;
        this.data=data;
    }


    public Integer getId() {
        return id;
    }

    public Integer getIdAbitazione() {
        return idAbitazione;
    }

    public void setIdAbitazione(Integer idAbitazione) {
        this.idAbitazione = idAbitazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public Integer getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(Integer punteggio) {
        this.punteggio = punteggio;
    }

    public LocalDate getData() {
        return data;
    }
}
