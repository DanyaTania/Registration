package by.gourianova.binocularvision.entity;

import java.math.BigInteger;
import java.text.DateFormat;

public class User {
    private BigInteger  id;
   // private String username;//TODO:default=login
    private String email;//TODO:in description =login
    private String password;
    private DateFormat u_create_time;//date of registration
    private BigInteger max_Result;

    public User(){
        super();
    }
public User(String email,String password){
        this.email=email;
        this.password=password;

}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateFormat getU_create_time() {
        return u_create_time;
    }

    public void setU_create_time(DateFormat u_create_time) {
        this.u_create_time = u_create_time;
    }

    public Long getRecord() {
        return record;
    }

    public void setRecord(Long record) {
        this.record = record;
    }

    private Long record;

  //  public String getUsername() {
   //     return username;
    //}

    //public void setUsername(String username) {
     //   this.username = username;
    //}

    public BigInteger  getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getLogin() {
        return email;
    }

    public void setLogin(String login) {
        this.email = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public DateFormat getCreate_time() {
        return u_create_time;
    }

    public void setCreate_time(DateFormat create_time) {
        this.u_create_time = create_time;
    }

}
