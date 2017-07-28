package com.todo.memo.dao;

import com.todo.memo.model.Memo;
import com.todo.memo.tables.records.MemoRecord;
import org.jooq.Result;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.todo.memo.tables.Memo.MEMO_;

/**
 * Created by zhangzf on 17/7/28.
 */
@Component
public class MemoDao extends JooqDao<MemoRecord, Memo, Integer> {


    protected MemoDao() {
        super(MEMO_, Memo.class);
    }

    @Override
    protected Integer getId(Memo memo) {
        return memo.getId();
    }

    public void deleteMemo(Memo memo) {
        create().update(MEMO_).set(MEMO_.DEL, 1).where(MEMO_.ID.eq(memo.getId())).execute();
    }

    public List<Memo> getAll() {
        Result<MemoRecord> fetch = create().selectFrom(MEMO_).where(MEMO_.DEL.eq(0)).and(MEMO_.IS_FINISH.eq(0)).orderBy(MEMO_.DEL.desc(), MEMO_.CREATE_TIME.asc()).fetch();
        if (null != fetch) {
            return fetch.into(Memo.class);
        } else {
            return null;
        }
    }
}
