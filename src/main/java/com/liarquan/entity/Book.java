package com.liarquan.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    Long id;

    String name;

    String author;

    Date publishTime;

    Integer inventory;
}
