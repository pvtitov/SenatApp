package ru.github.pvtitov.senatapp.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meeting {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("num")
    @Expose
    private String num;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("createDate")
    @Expose
    private String createDate;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("head")
    @Expose
    private Head head;
    @SerializedName("secretary")
    @Expose
    private Secretary secretary;
    @SerializedName("agenda")
    @Expose
    private List<Agenda> agenda;
    @SerializedName("participants")
    @Expose
    private List<Participant> participants;
    @SerializedName("collegialBody")
    @Expose
    private CollegialBody collegialBody;
    @SerializedName("hasProtocol")
    @Expose
    private boolean hasProtocol;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Secretary getSecretary() {
        return secretary;
    }

    public void setSecretary(Secretary secretary) {
        this.secretary = secretary;
    }

    public List<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agenda = agenda;
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Participant> participants) {
        this.participants = participants;
    }

    public CollegialBody getCollegialBody() {
        return collegialBody;
    }

    public void setCollegialBody(CollegialBody collegialBody) {
        this.collegialBody = collegialBody;
    }

    public boolean isHasProtocol() {
        return hasProtocol;
    }

    public void setHasProtocol(boolean hasProtocol) {
        this.hasProtocol = hasProtocol;
    }

}
