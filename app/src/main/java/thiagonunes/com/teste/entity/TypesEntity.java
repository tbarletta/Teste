package thiagonunes.com.teste.entity;

import com.google.gson.annotations.SerializedName;

public enum TypesEntity {
    @SerializedName("1") FIELD,
    @SerializedName("2") TEXT,
    @SerializedName("3") IMAGE,
    @SerializedName("4") CHECKBOX,
    @SerializedName("5") SEND,
    @SerializedName("6") EMAIL,
    @SerializedName(value = "7", alternate = {"telnumber"}) TEL_NUMBER
}
