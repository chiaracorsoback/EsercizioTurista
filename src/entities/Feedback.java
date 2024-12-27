package entities;

public class Feedback {
    private static Integer idTot = 0;
    private Integer id;
    private String titolo;
    private String testo;
    private Integer punteggio;

    public Feedback(String titolo, String testo, Integer punteggio) {
        this.id = ++idTot;
        this.titolo = titolo;
        this.testo = testo;
        this.punteggio = punteggio;
    }

    public Integer getId() {
        return id;
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
}
