package by.tsarenkov.entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private int id;
    private String FIO;
    private String address;
    private String phone;
    private String email;
    private String password;

    public Customer() {

    }

    public Customer(String FIO, String address, String phone, String email, String password) {
        this.FIO = FIO;
        this.address = address;
        this.phone = phone;
        this. email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode(){
        return 0;
    }
}
