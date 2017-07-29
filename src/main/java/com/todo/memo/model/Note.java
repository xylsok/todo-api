package com.todo.memo.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhangzf on 17/7/29.
 */
@Data
public class Note {
    private Integer id;
    private String content;
    private String userName;
    private Date createTime;
}
