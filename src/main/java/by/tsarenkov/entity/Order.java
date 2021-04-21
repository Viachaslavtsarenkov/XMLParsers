package by.tsarenkov.entity;

import java.io.Serializable;

public class Order implements Serializable {
    private int id;
    private int customerId;
    private int goodId;
    private StatusPayment status;

    public void Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public StatusPayment getStatus() {
        return status;
    }

    public void setStatus(StatusPayment status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != Order.class) {
            return false;
        }

        if (obj == this) {
            return true;
        }
        Order order = (Order) obj;
        return (id == order.getId());
    }

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public String toString() {
        return getClass().getName()
                +"[id=" + id
                + ",customerId=" + customerId
                + ",goodId=" + goodId
                + ",status=" + status
                + "]";
    }
}
