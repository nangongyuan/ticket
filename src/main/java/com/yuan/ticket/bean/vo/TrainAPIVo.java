package com.yuan.ticket.bean.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrainAPIVo {
    @JsonProperty(value = "data")
    private TrainApiData trainApiData;

    private String httpstatus;

    private String messages;

    private String status;
}
