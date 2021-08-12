package com.example.exam.controller.request;

import lombok.Data;

@Data
abstract class BaseRequest {
    
    public Long page;

    public Long  limit;

}
