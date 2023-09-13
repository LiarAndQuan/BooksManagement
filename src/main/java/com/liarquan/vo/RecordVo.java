package com.liarquan.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RecordVo {

    String bookName;

    String username;

    Date borrowTime;

    Date returnTime;
}
