package thiagonunes.com.teste.entity;

public class CellsEntity {
    private Integer id;
    private TypesEntity type;
    private String message;
    private TypesEntity typefield;
    private Boolean hidden;
    private Integer topSpacing;
    private Integer show;
    private Boolean required;

    public Integer getId() {
        return id;
    }

    public TypesEntity getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public TypesEntity getTypefield() {
        return typefield;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public Integer getTopSpacing() {
        return topSpacing;
    }

    public Integer getShow() {
        return show;
    }

    public Boolean getRequired() {
        return required;
    }
    
}
