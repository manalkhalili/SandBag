package com.example.SandBag.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import javax.management.relation.Role;
import java.time.LocalDateTime;


@Entity
@Table(name = "User")
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    @Column(unique = true, nullable = false)
    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Phone number must be exactly 10 digits")
    @Column(nullable = false)
    private String phoneNumber;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    @NotNull(message = "Password cannot be null")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{7,}$",
            message = "Password must be at least 7 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character"
    )
    private String password;


    public enum Role {
        Parent,
        Childreen
    }


    @Column(nullable = false)
    private boolean verified = false;

    @Column(nullable = false)
    private boolean resetCodeVerified = false;
    @Column
    private String verificationCode;  // لتخزين كود التحقق

    @Column
    private LocalDateTime verificationCodeExpiration;  // لتخزين تاريخ انتهاء صلاحية الكود

    @Column
    private String resetCode;

    @Column
    private LocalDateTime resetCodeExpiration;

    public UserEntity(){}

    public UserEntity(String name, String email, String phoneNumber, Role role) {

        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
        this.verified=false;
        this.resetCodeVerified = false;
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
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    public boolean isResetCodeVerified() {
        return resetCodeVerified;
    }

    public void setResetCodeVerified(boolean resetCodeVerified) {
        this.resetCodeVerified = resetCodeVerified;
    }
    public String getVerificationCode() {
        return verificationCode;
    }
    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;

    }
    public LocalDateTime getVerificationCodeExpiration() {
        return verificationCodeExpiration;
    }

}
