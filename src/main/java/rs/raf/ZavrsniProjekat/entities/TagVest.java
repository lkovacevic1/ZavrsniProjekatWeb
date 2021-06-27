package rs.raf.ZavrsniProjekat.entities;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class TagVest {

    private Integer id;

    @NotNull(message = "Title field is required")
    private Integer idTag;

    @NotNull(message = "Title field is required")
    private Integer idVest;

    public TagVest(){}

    public TagVest(Integer id, Integer idTag, Integer idVest) {
        this.id = id;
        this.idTag = idTag;
        this.idVest = idVest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTag() {
        return idTag;
    }

    public void setIdTag(Integer idTag) {
        this.idTag = idTag;
    }

    public Integer getIdVest() {
        return idVest;
    }

    public void setIdVest(Integer idVest) {
        this.idVest = idVest;
    }
}
