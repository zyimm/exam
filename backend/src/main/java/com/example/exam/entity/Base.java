package com.example.exam.entity;

import java.util.Date;

import lombok.Data;
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
public abstract class Base {
    
    private Date createdAt;

    private String createdUid;


}
