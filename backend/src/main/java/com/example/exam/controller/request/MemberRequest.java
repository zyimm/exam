package com.example.exam.controller.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zyimm
 */
@Data
@JsonNaming(SnakeCaseStrategy.class)
@EqualsAndHashCode(callSuper = true)
public class MemberRequest extends BaseRequest {

   private MemberMainRequest main;

   private MemberInfoRequest info; 
}
