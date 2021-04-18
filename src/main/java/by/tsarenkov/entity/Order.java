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
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != Order.class) {
            return false;
        }
        Order order = (Order) obj;

        return true;
    }

    @Override
    public int hashCode(){
        return 0;
    }
}
