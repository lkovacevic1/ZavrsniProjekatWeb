package rs.raf.ZavrsniProjekat.entities;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;

public class Category {

    private Integer id;

    @NotNull(message = "Title field is required")
    private String ime;

    @NotNull(message = "Title field is required")
    private String opis;

    public Category(){}

    public Category(Integer id, String ime, String opis) {
        this.id = id;
        this.ime = ime;
        this.opis = opis;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}
