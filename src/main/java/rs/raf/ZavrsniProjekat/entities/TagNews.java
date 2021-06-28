package rs.raf.ZavrsniProjekat.entities;

import java.sql.Date;

public class TagNews {

    private Integer id;

    private String naslov;

    private String tekst;

    private String ime;

    private Date vremeKreiranja;

    public TagNews(String naslov, String tekst, String ime, Date vremeKreiranja) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.ime = ime;
        this.vremeKreiranja = vremeKreiranja;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Date getVremeKreiranja() {
        return vremeKreiranja;
    }

    public void setVremeKreiranja(Date vremeKreiranja) {
        this.vremeKreiranja = vremeKreiranja;
    }
}
