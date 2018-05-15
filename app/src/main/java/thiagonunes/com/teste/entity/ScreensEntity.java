package thiagonunes.com.teste.entity;

import java.util.List;

public class ScreensEntity {
    private String title;
    private String fundName;
    private String whatIs;
    private String definition;
    private String riskTitle;
    private Integer risk;
    private String infoTitle;
    private MoreInfo moreInfo;
    private List<InfEntity> info;
    private List<InfEntity> downInfo;

    public String getTitle() {
        return title;
    }

    public String getFundName() {
        return fundName;
    }

    public String getWhatIs() {
        return whatIs;
    }

    public String getDefinition() {
        return definition;
    }

    public String getRiskTitle() {
        return riskTitle;
    }

    public Integer getRisk() {
        return risk;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public MoreInfo getMoreInfo() {
        return moreInfo;
    }

    public List<InfEntity> getInfo() {
        return info;
    }

    public List<InfEntity> getDownInfo() {
        return downInfo;
    }

    public Float getFundMes() {
        return this.moreInfo.getMonth().getFund();
    }

    public Float getFundAno() {
        return this.moreInfo.getYear().getFund();
    }

    public Float getFundDozeMeses() {
        return this.moreInfo.getMonths().getFund();
    }

    public Float getCdiMes() {
        return this.moreInfo.getMonth().getCdi();
    }

    public Float getCdiAno() {
        return this.moreInfo.getYear().getCdi();
    }

    public Float getCdiDozeMeses() {
        return this.moreInfo.getMonths().getCdi();
    }
}
