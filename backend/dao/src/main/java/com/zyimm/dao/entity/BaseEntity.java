package com.zyimm.dao.entity;

import lombok.Data;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
public abstract class BaseEntity {

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    private String createdUid;

    @TableLogic
    private LocalDateTime deletedAt;
}
