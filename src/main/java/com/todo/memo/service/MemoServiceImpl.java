package com.todo.memo.service;

import com.todo.memo.dao.MemoDao;
import com.todo.memo.inter.MemoService;
import com.todo.memo.model.Memo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangzf on 17/7/28.
 */
@Service("memoService")
public class MemoServiceImpl implements MemoService {

    @Autowired
    MemoDao memoDao;

    @Override
    public void add(Memo memo) {
        memoDao.save(memo);
    }

    @Override
    public void update(Memo memo) {
        memoDao.update(memo);
    }

    @Override
    public void delete(Memo memo) {
        memoDao.deleteMemo(memo);
    }

    @Override
    public List<Memo> get() {
        return memoDao.getAll();
    }

    @Override
    public Memo detail(Integer id) {
        return memoDao.findById(id);
    }
}
