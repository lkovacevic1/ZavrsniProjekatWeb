package rs.raf.ZavrsniProjekat.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class User {

    private Integer id;

    @NotNull(message = "Title field is required")
    private Integer idTipKorisnika;

    @NotNull(message = "Title field is required")
    private String ime;

    @NotNull(message = "Title field is required")
    private String prezime;

    @NotNull(message = "Title field is required")
    private String email;

    @NotNull(message = "Title field is required")
    private String lozinka;

    @NotNull(message = "Title field is required")
    private boolean status;

    public User(){
    }

    public User(Integer idTipKorisnika, String ime, String prezime, String email, String lozinka, boolean status) {
        this();
        this.idTipKorisnika = idTipKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.status = status;
    }

    public User(Integer id, Integer idTipKorisnika, String ime, String prezime, String email, String lozinka, boolean status) {
        this(idTipKorisnika, ime, prezime, email, lozinka, status);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTipKorisnika() {
        return idTipKorisnika;
    }

    public void setIdTipKorisnika(Integer idTipKorisnika) {
        this.idTipKorisnika = idTipKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
