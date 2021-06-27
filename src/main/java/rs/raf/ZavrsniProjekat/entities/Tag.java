package rs.raf.ZavrsniProjekat.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Tag {

    private Integer id;

    @NotNull(message = "Title field is required")
    private String reci;

    public Tag(){}

    public Tag(Integer id, String reci) {
        this.id = id;
        this.reci = reci;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReci() {
        return reci;
    }

    public void setReci(String reci) {
        this.reci = reci;
    }
}
