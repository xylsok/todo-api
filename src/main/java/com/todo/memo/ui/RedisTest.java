package com.todo.memo.ui;

import com.todo.memo.dao.NoteDao;
import com.todo.memo.dao.UserDao;
import com.todo.memo.model.Note;
import com.todo.memo.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jooq.api.annotation.Transition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by zhangzf on 2018/5/7.
 */
@Api(value = "redis管理", description = "redis管理")
@RestController
@RequestMapping(value = "/redis")
public class RedisTest {

    @ApiOperation(value = "redis", notes = "redis")
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public void test() {
        Jedis jedis = new Jedis("localhost", 6379);
        jedis.set("num","1");
        for (int i = 0; i <20 ; i++) {
            jedis.incr("num");
        }
        System.out.println(jedis.get("num"));
        jedis.close();
    }

    @ApiOperation(value = "redis链接池", notes = "redis链接池")
    @RequestMapping(value = "/redisdatasource", method = RequestMethod.GET)
    public void redisDatasource() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(30);
        config.setMaxIdle(10);

        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("name", "张三");
            System.out.println(jedis.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            if(jedisPool!=null){
                jedisPool.close();
            }
        }
    }

    @Autowired
    UserDao userDao;

    @Autowired
    NoteDao noteDao;

    @ApiOperation(value = "事务", notes = "事务")
    @RequestMapping(value = "/ts", method = RequestMethod.GET)
    @Transactional
    public void test2() {
        String str = "wewewewewewewewewewew" +
                "ewewewewewewewewewewewewewewe" +
                "wewewewewewewewewewewewewewewew" +
                "ewewewewewewewewewewewewewewewewewe" +
                "wewewewewewewewewewewewewewewewewewewe" +
                "wewewewewewewewewewewewewewewewewewewewewewewewe" +
                "wewewewewewewewewewewewewewewewewewewewewewewewewewewe";
        for (int i = 0; i <5 ; i++) {
            System.out.println(i);
        }
    }

}
