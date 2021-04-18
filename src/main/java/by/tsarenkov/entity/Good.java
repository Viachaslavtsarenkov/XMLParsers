package by.tsarenkov.entity;

import java.io.Serializable;

public class Good implements Serializable {
    private int id;
    private String name;
    private String category;
    private String description;
    private double price;
    private int count;

    public Good() {

    }

    public Good(String name, String category) {
        this.name = name;
        this.category = category;
        this.count = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
