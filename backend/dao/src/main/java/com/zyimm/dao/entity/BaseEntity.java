package com.zyimm.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
public abstract class BaseEntity {

    @TableField(fill = FieldFill.INSERT)
    protected LocalDateTime createdAt;

    protected String createdUid;

    @TableLogic("null")
    protected  LocalDateTime deletedAt;
}
