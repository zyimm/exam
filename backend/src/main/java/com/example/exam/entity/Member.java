package com.example.exam.entity;

import java.math.BigInteger;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zyimm
 */
@Data
@TableName("member")
@EqualsAndHashCode(callSuper = true)
public class Member extends Base{
    
     /**
     * 指定主键名
     */
    @TableId(value = "id", type = IdType.INPUT)
    private BigInteger id;

    private String memberName;

    private String memberNickname;

    private String memberAvatar;

    private String memberPassword;

    private String memberStatus;

    private Integer memberSex;

    private String memberMobile;

    private String memberEmail;

    private String lastLoginIp;

    private Date lastLoginTime;

    private String updatedUid;

    private Date updatedAt;

    @TableLogic
    private Date deletedAt;

}
