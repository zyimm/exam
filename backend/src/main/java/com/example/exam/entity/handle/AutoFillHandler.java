package com.example.exam.entity.handle;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import cn.hutool.log.Log;

/**
 * @author zyimm
 */
@Component
public class AutoFillHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Log.get().info("start insert fill ....");
        // 起始版本 3.3.0(推荐使用)
        this.strictInsertFill(metaObject, "created_at", LocalDateTime.class, LocalDateTime.now()); 
       
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Log.get().info("start update fill ....");
        // 起始版本 3.3.0(推荐)
        this.strictUpdateFill(metaObject, "updated_at", LocalDateTime.class, LocalDateTime.now()); 

    }
    
}
