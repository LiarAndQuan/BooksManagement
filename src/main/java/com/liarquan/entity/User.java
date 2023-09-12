package com.liarquan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    Long id;

    String name;

    String password;

    Byte isAdmin;

    Byte gender;

    String phoneNumber;

    String username;
}
