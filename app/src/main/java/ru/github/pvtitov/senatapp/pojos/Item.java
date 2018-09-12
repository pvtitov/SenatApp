package ru.github.pvtitov.senatapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Item {

    @SerializedName("_type")
    @Expose
    private String type;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("holding")
    @Expose
    private Holding holding;
    @SerializedName("collegialBody")
    @Expose
    private CollegialBody collegialBody;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("voting")
    @Expose
    private Voting voting;
    @SerializedName("hasProtocol")
    @Expose
    private boolean hasProtocol;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("endDate")
    @Expose
    private String endDate;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Holding getHolding() {
        return holding;
    }

    public void setHolding(Holding holding) {
        this.holding = holding;
    }

    public CollegialBody getCollegialBody() {
        return collegialBody;
    }

    public void setCollegialBody(CollegialBody collegialBody) {
        this.collegialBody = collegialBody;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Voting getVoting() {
        return voting;
    }

    public void setVoting(Voting voting) {
        this.voting = voting;
    }

    public boolean isHasProtocol() {
        return hasProtocol;
    }

    public void setHasProtocol(boolean hasProtocol) {
        this.hasProtocol = hasProtocol;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

}
