package com.liarquan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    Long id;

    Long readerId;

    Long bookId;

    Date returnTime;

    Date borrowTime;
}
