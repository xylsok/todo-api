package com.todo.memo.inter;

import com.todo.memo.model.Memo;

import java.util.List;

/**
 * Created by zhangzf on 17/7/28.
 */
public interface MemoService {
    void add(Memo memo);
    void update(Memo memo);

    void delete(Memo memo);

    List<Memo> get(String username);

    Memo detail(Integer id);

    List<Memo> getFinish(String username);
}
