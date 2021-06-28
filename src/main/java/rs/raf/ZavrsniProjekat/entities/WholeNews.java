package rs.raf.ZavrsniProjekat.entities;

import java.sql.Date;

public class WholeNews {

    private Integer id;

    private String naslov;

    private String text;

    private Date vremeKreiranja;

    private String ime;

    private String reci;

    private String tekst;

    private Date datumKreiranja;

    private Integer idKorisnika;

    public WholeNews(String naslov, String text, Date vremeKreiranja, String ime, String reci, String tekst, Date datumKreiranja, Integer idKorisnika) {
        this.naslov = naslov;
        this.text = text;
        this.vremeKreiranja = vremeKreiranja;
        this.ime = ime;
        this.reci = reci;
        this.tekst = tekst;
        this.datumKreiranja = datumKreiranja;
        this.idKorisnika = idKorisnika;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getVremeKreiranja() {
        return vremeKreiranja;
    }

    public void setVremeKreiranja(Date vremeKreiranja) {
        this.vremeKreiranja = vremeKreiranja;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getReci() {
        return reci;
    }

    public void setReci(String reci) {
        this.reci = reci;
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

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }
}
