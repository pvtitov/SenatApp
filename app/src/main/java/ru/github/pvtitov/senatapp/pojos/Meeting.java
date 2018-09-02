package ru.github.pvtitov.senatapp.pojos;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Meeting {

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

    public class CollegialBody {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("id")
        @Expose
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

    public class Holding {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("id")
        @Expose
        private String id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

    }

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
        private Object voting;
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

        public Object getVoting() {
            return voting;
        }

        public void setVoting(Object voting) {
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
}