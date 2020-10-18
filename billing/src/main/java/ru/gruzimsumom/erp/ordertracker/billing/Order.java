package ru.gruzimsumom.erp.ordertracker.billing;

import java.sql.Date;
import java.util.ArrayList;

public class Order {

    Long id;
    Date regDate;
    String addressStart;
    String addressEnd;
    Long orderInfoID;
    Integer isClosed;

    public Order(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getAddressStart() {
        return addressStart;
    }

    public void setAddressStart(String addressStart) {
        this.addressStart = addressStart;
    }

    public String getAddressEnd() {
        return addressEnd;
    }

    public void setAddressEnd(String addressEnd) {
        this.addressEnd = addressEnd;
    }

    public Long getOrderInfoID() {
        return orderInfoID;
    }

    public void setOrderInfoID(Long orderInfoID) {
        this.orderInfoID = orderInfoID;
    }

    public Integer getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
    }

    public String orderToJSON() {

        StringBuilder sb = new StringBuilder();
        sb.append("ID: " + getId() + "\n");
        sb.append("regDate: " + getRegDate() + "\n");
        sb.append("AddressStart: " + getAddressStart() + "\n");
        sb.append("AddressEnd: " + getAddressEnd() + "\n");
        sb.append("OrderInfoID: " + getOrderInfoID() + "\n");
        sb.append("IsClosed: " + getIsClosed() + "\n");
        return sb.toString();

    }
}
