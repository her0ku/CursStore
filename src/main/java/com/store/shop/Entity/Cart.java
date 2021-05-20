package com.store.shop.Entity;

import javax.persistence.*;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column
    private String mail;
    @Column
    private String itemName;
    @Column
    private Integer price;
    @Column
    private Integer count;
    @Column
    private String category;
    @Column(name = "image")
    private String image;

    public Cart() {
    }

    public Cart(String mail, String itemName, Integer price, Integer count, String category, String image) {
        this.mail = mail;
        this.itemName = itemName;
        this.price = price;
        this.count = count;
        this.category = category;
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
