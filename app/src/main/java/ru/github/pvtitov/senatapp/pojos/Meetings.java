package ru.github.pvtitov.senatapp.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meetings {

    @SerializedName("pageNum")
    @Expose
    private int pageNum;
    @SerializedName("pageSize")
    @Expose
    private int pageSize;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    @SerializedName("itemsTotal")
    @Expose
    private int itemsTotal;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getItemsTotal() {
        return itemsTotal;
    }

    public void setItemsTotal(int itemsTotal) {
        this.itemsTotal = itemsTotal;
    }
}