package com.todo.memo.ui;

import com.todo.memo.inter.MemoService;
import com.todo.memo.model.Memo;
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
@Api(value = "备忘管理", description = "备忘管理")
@RestController
@RequestMapping(value = "/memo")
public class MemoWeb {

    @Autowired
    MemoService memoService;

    @ApiOperation(value = "添加", notes = "添加")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void add(HttpServletRequest request, @RequestBody Memo memo) {
        memo.setCreateTime(new Date());
        memoService.add(memo);
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void update(@RequestBody Memo memo) {
        memoService.update(memo);
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete( @RequestBody Memo memo) {
        memoService.delete(memo);
    }

    @ApiOperation(value = "查询", notes = "查询")
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<Memo> get() {
        return memoService.get();
    }
    @ApiOperation(value = "查询一个", notes = "查询一个")
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Memo detail(@PathVariable("id")Integer id) {
        return memoService.detail(id);
    }

}
