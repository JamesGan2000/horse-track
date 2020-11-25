package com.example.horsetrack.horsetrack;

public class InventoryItem {
    private Integer dollar;
    private Integer count;

    public InventoryItem(Integer dollar, Integer count) {
        this.dollar = dollar;
        this.count = count;
    }

    public Integer value(){
        return dollar * count;
    }

    public Integer getDollar() {
        return dollar;
    }

    public void setDollar(Integer dollar) {
        this.dollar = dollar;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "$" + dollar + ", " + count;
    }
}
