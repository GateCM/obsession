/**
 * 
 */
package com.gatecm.obsession;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gatecm.obsession.entity.Member;

import junit.framework.Assert;

/**
* @Description: TODO()
* @author chenxiaohui
* @date 2017年11月7日 下午3:19:52
*
*/
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisAutoTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
   
    @Test
    public void save(){

//        stringRedisTemplate.opsForValue().set("zzp","big z");
//        Assert.assertEquals("big z",stringRedisTemplate.opsForValue().get("zzp"));
    }
    
    @Test
    public void testobj() throws InterruptedException {
        Member user = new Member();
        user.setCreateTime(new Date());
        ValueOperations<String,String> operations = redisTemplate.opsForValue();
        operations.set("User:zzp","sef");
        Thread.sleep(1000);
        operations.set("User:zzq",user.toString());
        Thread.sleep(1000);
    }
}
