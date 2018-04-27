package com.todo.memo.ui;

import com.todo.memo.dao.UserDao;
import com.todo.memo.inter.MemoService;
import com.todo.memo.model.Memo;
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
@Api(value = "用户管理", description = "用户管理")
@RestController
@RequestMapping(value = "/user")
public class UserWeb {

    @Autowired
    MemoService memoService;

    @Autowired
    UserDao userDao;

    @ApiOperation(value = "添加", notes = "添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Integer add(HttpServletRequest request, @RequestBody User user) {
        Integer i = userDao.getUserByUsername2(user.getUserName());
        if(i>0){
            return 1;
        }else {
            userDao.save(user);
            return 0;
        }
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody User user) {
        userDao.update(user);
    }


    @ApiOperation(value = "查询", notes = "查询")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Integer id) {
        return userDao.findById(id);
    }

    @ApiOperation(value = "Login", notes = "Login")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(HttpServletRequest request, @RequestBody User user) {
        if (null != user) {
            User u = userDao.getUserByUsername(user.getUserName(), user.getPassword());
            if (null != u) {
                u.setPassword("");
                request.getSession().setAttribute(u.getUserName(), u);
                return u;
            }
        }
        return null;
    }

}
