package com.zyimm.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
@TableName("user")
@EqualsAndHashCode(callSuper = true)
public class UserEntity  extends BaseEntity{
     /**
     * 指定主键名
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String userName;

    private String userNickname;

    private String userAvatar;

    private String userPassword;

    private String userStatus;

    private Integer userSex;

    private String userMobile;

    private String userEmail;

    private String lastLoginIp;

    private LocalDateTime lastLoginTime;

    private String updatedUid;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    @TableLogic
    private LocalDateTime deletedAt;
}
