package entities;

public class Abitazione {
    private static Integer idTot = 0;
    private Integer id;
    private String nome;
    private String indirizzo;
    private Integer numStanze;
    private Integer numLetti;
    private Integer piano;
    private Integer prezzo;
    private String codiceHost;

    public Abitazione(String nome, String indirizzo, Integer numStanze, Integer numLetti, Integer piano, Integer prezzo, String codiceHost) {
        this.id = ++idTot;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numStanze = numStanze;
        this.numLetti = numLetti;
        this.piano = piano;
        this.prezzo = prezzo;
        this.codiceHost = codiceHost;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Integer getNumStanze() {
        return numStanze;
    }

    public void setNumStanze(Integer numStanze) {
        this.numStanze = numStanze;
    }

    public Integer getNumLetti() {
        return numLetti;
    }

    public void setNumLetti(Integer numLetti) {
        this.numLetti = numLetti;
    }

    public Integer getPiano() {
        return piano;
    }

    public void setPiano(Integer piano) {
        this.piano = piano;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    public String getCodiceHost() {
        return codiceHost;
    }

    public void setCodiceHost(String codiceHost) {
        this.codiceHost = codiceHost;
    }
}

