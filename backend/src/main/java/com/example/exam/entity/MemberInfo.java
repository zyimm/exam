package com.example.exam.entity;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zyimm
 */
@Data
@TableName("member_info")
@EqualsAndHashCode(callSuper = true)
@JsonNaming(SnakeCaseStrategy.class)
public class MemberInfo extends Base{

    /**
     * 指定主键名
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long memberId;

    private String desc;

    private String realName;

    private String birthday;

    private String address;
    
    private String updatedUid;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    
    
}
