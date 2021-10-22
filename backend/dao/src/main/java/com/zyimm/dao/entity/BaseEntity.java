package com.zyimm.dao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected LocalDateTime createdAt;

    protected String createdUid;

    @TableLogic("null")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected  LocalDateTime deletedAt;
}
