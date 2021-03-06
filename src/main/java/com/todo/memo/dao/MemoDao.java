package com.todo.memo.dao;

import com.todo.memo.model.Memo;

import com.todo.memo.tables.records.MemoRecord;
import org.jooq.Result;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.todo.memo.Tables.MEMO_;


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

    public void deleteMemo(Integer id) {
        create().update(MEMO_).set(MEMO_.DEL, 1).where(MEMO_.ID.eq(id)).execute();
    }

    public List<Memo> getAll(String username) {
        Result<MemoRecord> fetch = create().selectFrom(MEMO_).where(MEMO_.DEL.eq(0)).and(MEMO_.IS_FINISH.eq(0)).and(MEMO_.USER_NAME.eq(username)).orderBy(MEMO_.DEL.desc(), MEMO_.CREATE_TIME.asc()).fetch();
        if (null != fetch) {
            return fetch.into(Memo.class);
        } else {
            return null;
        }
    }

    public List<Memo> getFinish(String username) {
        Result<MemoRecord> fetch = create().selectFrom(MEMO_).where(MEMO_.DEL.eq(0)).and(MEMO_.IS_FINISH.eq(1)).and(MEMO_.USER_NAME.eq(username)).orderBy(MEMO_.DEL.desc(), MEMO_.CREATE_TIME.asc()).fetch();
        if (null != fetch) {
            return fetch.into(Memo.class);
        } else {
            return null;
        }
    }
}
