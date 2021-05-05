package com.store.shop.Entity;


import javax.persistence.*;


@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String category;
    private Integer price;
    private String Location;
    private Integer amout;
    private String annotation;
    @Column(name = "image")
    private String image;
    private Integer deleted;


    public Product() {
    }
    public Product(Integer id,String name, String category, Integer price, String location, Integer amout, String annotation, String image) {
        super();
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.Location = location;
        this.deleted=0;
        this.amout = amout;
        this.annotation = annotation;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public Integer getDeleted() {
        return deleted;
    }
    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getLocation() {
        return Location;
    }
    public void setLocation(String location) {
        Location = location;
    }
    public Integer getAmout() {
        return amout;
    }
    public void setAmout(Integer amout) {
        this.amout = amout;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public int sum(int x, int y) {
        return x+y;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", Location='" + Location + '\'' +
                ", amout=" + amout +
                ", annotation='" + annotation + '\'' +
                ", image=" + image +
                ", deleted=" + deleted +
                '}';
    }
}