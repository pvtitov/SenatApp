package ru.github.pvtitov.senatapp.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Voting {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("for")
    @Expose
    private int _for;
    @SerializedName("against")
    @Expose
    private int against;
    @SerializedName("abstain")
    @Expose
    private int abstain;
    @SerializedName("veto")
    @Expose
    private int veto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFor() {
        return _for;
    }

    public void setFor(int _for) {
        this._for = _for;
    }

    public int getAgainst() {
        return against;
    }

    public void setAgainst(int against) {
        this.against = against;
    }

    public int getAbstain() {
        return abstain;
    }

    public void setAbstain(int abstain) {
        this.abstain = abstain;
    }

    public int getVeto() {
        return veto;
    }

    public void setVeto(int veto) {
        this.veto = veto;
    }

}
