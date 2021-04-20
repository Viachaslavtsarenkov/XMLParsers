package by.tsarenkov.entity;

import java.awt.*;
import java.io.Serializable;

public class Admin implements Serializable {
    private int id;
    private String FIO;
    private String email;
    private String password;

    public Admin() {

    }

    public Admin(String FIO, String email, String password) {
        this.FIO = FIO;
        this.email = email;
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
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Admin admin = (Admin) obj;
        return (FIO == admin.getFIO() &
                email == admin.getEmail() &
                password == admin.getPassword());
    }

}
