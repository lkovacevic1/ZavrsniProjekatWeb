package rs.raf.ZavrsniProjekat.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserTipe {

    private Integer id;

    @NotNull(message = "Title field is required")
    private String naziv;

    public UserTipe() {
    }

    public UserTipe(Integer id, String naziv){
        this();
        this.id = id;
        this.naziv = naziv;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
}
