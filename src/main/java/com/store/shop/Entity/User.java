package com.store.shop.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String Type;
    private String usrename;
    private String Email;
    private String Mobile;
    private String password;


    public Integer getId() {
        return id;
    }

    public User() {

    }

    public User(Integer id, String Type, String usrename, String password,String Email,String Mobile)
    {
        super();
        this.id = id;
        this.Type = Type;
        this.usrename = usrename;
        this.password = password;
        this.Email=Email;
        this.Mobile=Mobile;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getType() {
        return Type;
    }


    public void setType(String type) {
        Type = type;
    }


    public String getUsrename() {
        return usrename;
    }


    public void setUsrename(String usrename) {
        this.usrename = usrename;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return Email;
    }


    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Type='" + Type + '\'' +
                ", usrename='" + usrename + '\'' +
                ", Email='" + Email + '\'' +
                ", Mobile='" + Mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
