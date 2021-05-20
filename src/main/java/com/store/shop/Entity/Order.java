package com.store.shop.Entity;

import javax.persistence.*;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String userName;
    @Column
    private String mail;
    @Column
    private String itemName;
    @Column
    private Integer price;
    @Column
    private Integer count;
    @Column
    private String tgName;
    @Column
    private String statusOrder;

    public Order() {
    }

    public Order(String userName, String itemName, Integer price, Integer count, String tgName, String statusOrder, String mail) {
        this.userName = userName;
        this.itemName = itemName;
        this.price = price;
        this.count = count;
        this.tgName = tgName;
        this.statusOrder = statusOrder;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTgName() {
        return tgName;
    }

    public void setTgName(String tgName) {
        this.tgName = tgName;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mail='" + mail + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", tgName='" + tgName + '\'' +
                ", statusOrder='" + statusOrder + '\'' +
                '}';
    }
}
