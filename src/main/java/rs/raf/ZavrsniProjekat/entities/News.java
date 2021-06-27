package rs.raf.ZavrsniProjekat.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Date;

public class News {

    private Integer id;

    @NotNull(message = "Title field is required")
    private Integer idKategorije;

    @NotNull(message = "Title field is required")
    private Integer idKorisnika;

    @NotNull(message = "Title field is required")
    private String naslov;

    @NotNull(message = "Title field is required")
    private String tekst;

    private Date vremeKreiranja;

    @NotNull(message = "Title field is required")
    private Integer brojPoseta;

    public News(){}

    public News(Integer id, Integer idKategorije, Integer idKorisnika, String naslov, String tekst, Date vremeKreiranja, Integer brojPoseta) {
        this.id = id;
        this.idKategorije = idKategorije;
        this.idKorisnika = idKorisnika;
        this.naslov = naslov;
        this.tekst = tekst;
        this.vremeKreiranja = vremeKreiranja;
        this.brojPoseta = brojPoseta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdKategorije() {
        return idKategorije;
    }

    public void setIdKategorije(Integer idKategorije) {
        this.idKategorije = idKategorije;
    }

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getVremeKreiranja() {
        return vremeKreiranja;
    }

    public void setVremeKreiranja(Date vremeKreiranja) {
        this.vremeKreiranja = vremeKreiranja;
    }

    public Integer getBrojPoseta() {
        return brojPoseta;
    }

    public void setBrojPoseta(Integer brojPoseta) {
        this.brojPoseta = brojPoseta;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", idKategorije=" + idKategorije +
                ", idKorisnika=" + idKorisnika +
                ", naslov='" + naslov + '\'' +
                ", tekst='" + tekst + '\'' +
                ", vremeKreiranja=" + vremeKreiranja +
                ", brojPoseta=" + brojPoseta +
                '}';
    }
}
