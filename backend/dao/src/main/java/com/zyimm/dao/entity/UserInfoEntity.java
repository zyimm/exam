package com.zyimm.dao.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
@TableName("user_info")
@EqualsAndHashCode(callSuper = true)
public class UserInfoEntity extends  BaseEntity{

    /**
     * 指定主键名
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long userId;

    private String desc;

    private String realName;

    private String birthday;

    private String address;
    
    private String updatedUid;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

}   
    