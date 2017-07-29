package com.todo.memo.ui;

import com.todo.memo.dao.NoteDao;
import com.todo.memo.dao.UserDao;
import com.todo.memo.inter.MemoService;
import com.todo.memo.model.Note;
import com.todo.memo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangzf on 17/3/22.
 */
@Api(value = "便签管理", description = "便签管理")
@RestController
@RequestMapping(value = "/note")
public class NoteWeb {


    @Autowired
    NoteDao noteDao;

    @ApiOperation(value = "添加", notes = "添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(HttpServletRequest request, @RequestBody Note note) {
        note.setCreateTime(new Date());
        noteDao.save(note);
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/del", method = RequestMethod.DELETE)
    public void add( @RequestParam Integer id) {
        noteDao.deleteById(id);
    }



    @ApiOperation(value = "查询", notes = "查询")
    @RequestMapping(value = "/get/{username}", method = RequestMethod.GET)
    public List<Note> get(@PathVariable("username") String username) {
        return noteDao.findByUserName(username);
    }



}
