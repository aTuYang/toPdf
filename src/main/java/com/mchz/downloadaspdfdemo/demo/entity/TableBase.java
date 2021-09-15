package com.mchz.downloadaspdfdemo.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 对应word文档占位符的实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TableBase {
    private Integer column1;

    private String column2;

    private String column3;

    private String column4;

    private String column5;
}
