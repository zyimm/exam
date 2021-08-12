package com.example.exam.entity;


import lombok.Data;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
public abstract class Base {
    
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    private String createdUid;


}
