package com.todo.memo.dao;

import com.todo.memo.model.User;
import com.todo.memo.tables.records.UserRecord;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Component;

import static com.todo.memo.Tables.USER;

/**
 * Created by zhangzf on 17/7/28.
 */
@Component
public class UserDao extends JooqDao<UserRecord,User,Integer>{
    protected UserDao() {
        super(USER, User.class);
    }

    @Override
    protected Integer getId(User user) {
        return user.getId();
    }

    public User getUserByUsername(String userName,String password) {
        UserRecord userRecord = create().selectFrom(USER).where(USER.USER_NAME.eq(userName)).and(USER.PASSWORD.eq(password)).fetchOne();
        return null!=userRecord?userRecord.into(User.class):null;
    }

    public Integer getUserByUsername2(String userName) {
        return create().select(DSL.count()).from(USER).where(USER.USER_NAME.eq(userName)).fetchOne().value1();
    }
}
