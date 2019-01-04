package com.yuan.ticket.bean.vo;

import com.yuan.ticket.bean.qo.TicketApiData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainVo {
    private String no;

    private String fromStation;

    private String toStation;

    private String train;

    private String startingTime;

    private String arrivalTime;

    private String consuming;

    private String seat;

    private String price;

    private String s;

    private String e;

    private String fs;

    private String ts;

    private TicketApiData ticketApiData;

}
