package com.example.assiment8.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id//P key
    private Integer id ;
    @NotEmpty(message= " name can not empty")
    @Size(min = 4, message="Length more than 4")

    private String name;
    @NotEmpty(message= " can not empty")
    @Length(min = 4, message=" user Length more than 4")
    @Column(columnDefinition = "varchar(20)   unique")
    private String username;
    @NotNull(message= "  password can not null")

    private Integer password;
    @Email
    @NotEmpty(message= "  email can not empty")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"  , message = " wrong email ")
    @Column(unique = true)
    private String email;
    @NotEmpty(message= "  role  can not empty")
    @Pattern(regexp = "user|admin", message = "role must be 'user' Or 'admin'")
private String role;
    @NotNull(message= "age can not null")


    private Integer age;

}
