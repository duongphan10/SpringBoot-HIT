package com.example.buoi8.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    @NotBlank(message = "Name is not blank")
    private String name;
    @Length(max = 1000,min = 1)
    @NotNull(message = "Address is not null")
    private String address;

    private MultipartFile multipartFile;

//    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$" ,
//            message = "Email is not format")
//    String email;
//
//    @Min(value = 1)
//    @Max(value = 100)
//    @Size(min = 2, max = 100)
//    private int age;
}
