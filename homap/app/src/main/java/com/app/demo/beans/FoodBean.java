package com.app.demo.beans;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * @anthor : 大海
 * 每天进步一点点
 * <p>
 * 美食表
 */


public class FoodBean extends DataSupport implements Serializable {

    private int id;

    private String f_id;
    private String name;
    private String pic;
    private String star;
    private int price;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_id() {
        return f_id;
    }

    public void setF_id(String f_id) {
        this.f_id = f_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
