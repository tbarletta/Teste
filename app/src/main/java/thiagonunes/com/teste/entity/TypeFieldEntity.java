package thiagonunes.com.teste.entity;

import com.google.gson.annotations.SerializedName;

public enum TypeFieldEntity {
    @SerializedName("1") TEXT,
    @SerializedName(value = "2", alternate = {"telnumber"}) TEL_NUMBER,
    @SerializedName("3") EMAIL
}
