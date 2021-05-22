package com.store.shop.App;

public class appOrder {

    private String firstName;
    private String email;
    private String Mobile;
    private String statusOrder;

    public appOrder() {
    }

    public appOrder(String firstName, String email, String mobile, String statusOrder) {
        this.firstName = firstName;
        this.email = email;
        Mobile = mobile;
        this.statusOrder = statusOrder;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public String toString() {
        return "appOrder{" +
                "firstName='" + firstName + '\'' +
                ", email='" + email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", statusOrder='" + statusOrder + '\'' +
                '}';
    }
}
