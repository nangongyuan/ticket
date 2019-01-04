package com.yuan.ticket.bean.qo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yuan.ticket.bean.vo.TrainApiData;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TicketAPIQo {

    @JsonProperty(value = "data")
    private TicketApiData ticketApiData;

    private String httpstatus;


    private String status;
}
