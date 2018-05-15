package thiagonunes.com.teste.entity;

import com.google.gson.annotations.SerializedName;

public class MoreInfo {
    private InfData month;
    private InfData year;

    @SerializedName("12months")
    private InfData months;

    public InfData getMonth() {
        return month;
    }

    public InfData getYear() {
        return year;
    }

    public InfData getMonths() {
        return months;
    }
}
