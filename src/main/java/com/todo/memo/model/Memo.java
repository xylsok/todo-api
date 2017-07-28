package com.todo.memo.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by zhangzf on 17/7/28.
 */
@Data
public class Memo {
    private Integer id;
    private String pName;
    private String content;
    private String title;
    private String isFinish;
    private String solution;
    private Date createTime;
    private Date closeTime;
    private Integer level;
    private Integer del;
    private String userName;
}
