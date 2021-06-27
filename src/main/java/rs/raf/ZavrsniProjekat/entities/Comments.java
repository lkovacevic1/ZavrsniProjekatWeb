package rs.raf.ZavrsniProjekat.entities;

import javax.validation.constraints.NotNull;
import java.sql.Date;

public class Comments {

    private Integer id;

    @NotNull(message = "Title field is required")
    private Integer idKorisnika;

    @NotNull(message = "Title field is required")
    private Integer idVesti;

    @NotNull(message = "Title field is required")
    private String tekst;

    @NotNull(message = "Title field is required")
    private Date datumKreiranja;

    public Comments(){}

    public Comments(Integer id, Integer idKorisnika, Integer idVesti, String tekst, Date datumKreiranja) {
        this.id = id;
        this.idKorisnika = idKorisnika;
        this.idVesti = idVesti;
        this.tekst = tekst;
        this.datumKreiranja = datumKreiranja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public Integer getIdVesti() {
        return idVesti;
    }

    public void setIdVesti(Integer idVesti) {
        this.idVesti = idVesti;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public Date getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(Date datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }
}
