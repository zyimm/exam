package com.example.exam.entity;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.log.Log;

/**
 * @author zyimm
 */
@Component
public class IdGenerator implements IdentifierGenerator {

    @Autowired
    private Snowflake snowflake;

    @Override
    public Long nextId(Object entity) {
      	//可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
      	String bizKey = entity.getClass().getName();
        //根据bizKey调用分布式ID生成
        Log.get().info(bizKey);
      	//返回生成的id值即可.
        return snowflake.nextId();
    }
}
