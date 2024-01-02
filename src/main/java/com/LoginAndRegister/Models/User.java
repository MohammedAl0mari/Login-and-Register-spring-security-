package com.LoginAndRegister.Models;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Locale;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userName")
    @NotEmpty(message = "Name is mandatory")
    @Size(min=2,message = "Name can't be less than two characters ")
    private String userName;

    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\W]).{8,64})" ,
            message = "Password not strong enough!!\n" +
                    "Must contain 1 Symbols , 1 Upper case letters , 1 Lower case letters ,Numbers")
    @Size(min=8,message = "Password can't be less than 8 characters ")
    @Column(name = "password")
    private String password;

    @Size(min=8,message = "Password can't be less than 8 characters ")
    @Transient
    private String rePassword;

    @Column(name = "email" ,unique = true)
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" ,
            message = "Invalid Email")
    private String email;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name ="User_Roles",
            joinColumns = {@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<Role> roles;

    @Column(name = "active")
    private int active;

    public User(String userName, String password, String email, int active) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.active = active;
    }
}
