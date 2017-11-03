package com.ac.mylib.domain;

/**
 * 要使用以下的import
 * import javax.persistence.Entity;
 * import javax.persistence.GeneratedValue;
 * import javax.persistence.Id;
 * 必须加入下面的dependency
 * <dependency>
 *     <groupId>org.springframework.boot</groupId>
 *     <artifactId>spring-boot-starter-data-jpa</artifactId>
 * </dependency>
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * 
 */
@Entity
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "这个字段必传")
    private String userName;
    
    private String password;
    
    private String nickname;

    @Min(value = 18, message = "未成年禁止入内")
    // @NotNull
    // @Max()
    // @Length()
    private Integer age;

    private String phoneNumber;
    
    private String emailAddress;

    public User() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", nickname=" + nickname
                + ", age=" + age + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + "]";
    }

}
