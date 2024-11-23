package com.company.contactmanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
@Entity
@Table(name = "CONTACT")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cid;
    private String name;
    private String nick_name;
    private String email;
    private String phone;
    private String work;
    private String imgUrl;
    @Column(length = 1000)
    private String description;
    @ManyToOne
private  User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contact() {
        System.out.println("Fetching contact information");
    }

    public Contact(int cid, String name, String nick_name, String email, String phone, String work, String imgUrl, String description) {
        this.cid = cid;
        this.name = name;
        this.nick_name = nick_name;
        this.email = email;
        this.phone = phone;
        this.work = work;
        this.imgUrl = imgUrl;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", work='" + work + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
