package entities;

public class Utente {
    private static Integer idTot = 0;
    private Integer id;
    private String nome;
    private String cognome;
    private String mail;
    private String password;
    private String indirizzo;
    private Boolean isHost;
    private String codiceHost;

    public Utente(String nome, String cognome, String mail, String password, String indirizzo) {
        this.id = ++idTot;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.password = password;
        this.indirizzo = indirizzo;
        this.isHost = false;
        this.codiceHost = null;
    }

    public Utente(String nome, String cognome, String mail, String password, String indirizzo, Boolean isHost, String codiceHost) {
        this.id = ++idTot;
        this.nome = nome;
        this.cognome = cognome;
        this.mail = mail;
        this.password = password;
        this.indirizzo = indirizzo;
        this.isHost = isHost;
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public Boolean getHost() {
        return isHost;
    }

    public void setHost(Boolean host) {
        isHost = host;
    }

    public String getCodiceHost() {
        return codiceHost;
    }

    public void setCodiceHost(String codiceHost) {
        this.codiceHost = codiceHost;
    }
}
