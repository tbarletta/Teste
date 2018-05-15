package thiagonunes.com.teste.entity;

import com.google.gson.annotations.SerializedName;

public class InfData {
    private Float fund;

    @SerializedName("CDI")
    private Float cdi;

    public Float getFund() {
        return fund;
    }

    public Float getCdi() {
        return cdi;
    }

}
