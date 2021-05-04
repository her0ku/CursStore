package com.store.shop.Entity;

public class Payment {

    private Integer amount;
    private String name;
    private String Type;
    private String address;

    public Payment(Integer amount, String name, String type, String address) {
        this.amount = amount;
        this.name = name;
        this.Type = type;
        this.address = address;
    }
    public Payment() {

    }

    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                ", name='" + name + '\'' +
                ", Type='" + Type + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
