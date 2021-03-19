package com.revature.models;

import com.revature.util.RegexUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Entity @Table(name="app_users")
@Data @NoArgsConstructor @AllArgsConstructor
public class AppUser {

    @Id @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @NotNull @NotBlank @Length(min=5)
    @Column(nullable=false, unique=true)
    private String username;

    @Pattern(regexp=RegexUtil.PASSWORD_REGEX)
    @Column(nullable=false)
    private String password;

    @Pattern(regexp=RegexUtil.EMAIL_REGEX)
    @Column(nullable=false, unique=true)
    private String email;

    @Column(name="register_datetime", updatable=false, columnDefinition="timestamp default CURRENT_TIMESTAMP")
    private LocalDateTime registerDateTime;

    @Enumerated(EnumType.STRING)
    private UserRole role;

}
