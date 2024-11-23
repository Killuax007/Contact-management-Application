package com.company.contactmanagement.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message="Name required...")
    @Size(min = 3,max = 10,message = "Enter a valid Name between 3 to 10 characters...")
    private String name;
    @Column(unique = true)
    @NotBlank(message="Email cant be blank")
    @Email(message = "Email value required ")
    private String email;

    @Size(min = 8,max = 16,message = "Password must be 8 to 16 characters length.!!! ")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{8,16}$",message =
            """
                    password must contains numbers(0-9) , \s
                   one Uppercase & Lowercase characters , \s
                    one Special character"""
    )
    private String password;
    private String role;
    @AssertTrue(message = "Please Accept Terms and Conditions...")
//    @NotNull( message = "Please Accept Terms and Conditions...")
    private Boolean agreement=false;
    private String imgUrl;
    @NotBlank(message="Description cannot be empty...")
    private String about;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "user")
    private List<Contact> contacts=new ArrayList<Contact>();

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", agreement=" + agreement +
                ", imgUrl='" + imgUrl + '\'' +
                ", about='" + about + '\'' +
                ", contacts=" + contacts +
                '}';
    }

    public User() {
        super();
        System.out.println("User value fetching....");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getAgreement() {
        return agreement;
    }

    public void setEnabled(Boolean agreement) {
        this.agreement = agreement;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public User(int id, String name, String email, String password, String role, Boolean agreement, String imgUrl, String about) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.agreement = agreement;
        this.imgUrl = imgUrl;
        this.about = about;
    }
}
