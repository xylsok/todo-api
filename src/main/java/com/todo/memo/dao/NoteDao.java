package com.todo.memo.dao;

import com.todo.memo.model.Note;
import com.todo.memo.tables.records.NoteRecord;
import org.jooq.Result;
import org.jooq.Table;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.todo.memo.Tables.NOTE;

/**
 * Created by zhangzf on 17/7/29.
 */
@Component
public class NoteDao extends JooqDao<NoteRecord, Note, Integer> {
    protected NoteDao() {
        super(NOTE, Note.class);
    }

    @Override
    protected Integer getId(Note note) {
        return note.getId();
    }

    public List<Note> findByUserName(String username) {
        Result<NoteRecord> fetch = create().selectFrom(NOTE).where(NOTE.USER_NAME.eq(username)).orderBy(NOTE.CREATE_TIME.desc()).fetch();
        return null != fetch ? fetch.into(Note.class) : new ArrayList<>();
    }

    public List<Note> findByUserName() {
       return this.findAll();
    }
}
