package com.newbankserver.entity;

import com.newbankserver.validator.EmailValidator;
import com.newbankserver.validator.LoginValidator;
import com.newbankserver.validator.PasswordValidator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String login;
    private String password;

    private String firstName;
    private String secondName;
    private String fatherName;

    private int genderId;
    private Date dateOfBirthday;

    private String telephoneNumber;
    private String email;

    public User() {
        this.login = "";
        this.password = "";

        this.firstName = "";
        this.secondName = "";
        this.fatherName = "";

        this.genderId = 0;
        this.dateOfBirthday = new Date();

        this.telephoneNumber = "";
        this.email = "";
    }

    public User(String login, String password, String firstName, String secondName, String fatherName, int genderId, Date dateOfBirthday,
                String telephoneNumber, String email) {
        this.login = login;
        this.password = password;

        this.firstName = firstName;
        this.secondName = secondName;
        this.fatherName = fatherName;

        this.genderId = genderId;
        this.dateOfBirthday = dateOfBirthday;

        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        LoginValidator validator = new LoginValidator();
        if(validator.validate(login)) {
            this.login =  login;
        }
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        PasswordValidator validator = new PasswordValidator();
        if (validator.validate(password)) {
            this.password = password;
        }
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFatherName() {
        return fatherName;
    }
    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getFIO() {
        return this.getSecondName() + " " + this.getFirstName() + " " + this.getFatherName();
    }

    public int getGenderId() {
        return  genderId;
    }
    public void setGenderId(int genderId) {
        this.genderId = genderId;
    }

    public Date getDateOfBirthday() {
        return  dateOfBirthday;
    }
    public void setDateOfBirthday(Date dateOfBirthday) {
        int result = dateOfBirthday.compareTo(new Date());
        if (result <= 0) {
            if (dateOfBirthday.compareTo(new Date(1,1,1990)) >= 0) {
                this.dateOfBirthday = dateOfBirthday;
            }
            else {
                this.dateOfBirthday = new Date();
            }
        }
        else if (result > 0) {
            this.dateOfBirthday = new Date();
        }
    }

    public String getTelephoneNumber() {
        return  telephoneNumber;
    }
    public void setTelephoneNumber(String telephoneNumber) {
        if (telephoneNumber.length() == 10)
            this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        EmailValidator emailValidator = new EmailValidator();
        if (emailValidator.validate(email)) {
            this.email = email;
        }
    }

    public String ToString() {
        return "User(id=" + this.getUserId() + ", login=" + this.getLogin() + ", password=" + this.getPassword() +
                ", fio='" + this.getFIO() + "', genderId=" + this.getGenderId() + ", dataOfBirthday='" + this.getDateOfBirthday() +
                "', telephoneNumber=+" + this.getTelephoneNumber() + ", email=" + this.getEmail() + ")";
    }
}
