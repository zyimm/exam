package com.example.exam.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zyimm
 */
@Data
@TableName("member")
@EqualsAndHashCode(callSuper = true)
@JsonNaming(SnakeCaseStrategy.class)
public class Member extends Base{
    
     /**
     * 指定主键名
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private String memberName;

    private String memberNickname;

    private String memberAvatar;

    private String memberPassword;

    private String memberStatus;

    private Integer memberSex;

    private String memberMobile;

    private String memberEmail;

    private String lastLoginIp;

    private LocalDateTime lastLoginTime;

    private String updatedUid;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    @TableLogic
    private LocalDateTime deletedAt;

}
