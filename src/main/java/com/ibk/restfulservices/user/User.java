package com.ibk.restfulservices.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;

    @Size(min = 2, message = "Name should have atleast two characters")
    private String name;

    @Past(message = "Birth Date should be in the past" )
    private LocalDate birthDate;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", birthDate=" + birthDate + '}';
    }
}
