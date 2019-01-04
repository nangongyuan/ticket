package com.yuan.ticket.controller;

import com.yuan.ticket.bean.qo.TrainQo;
import com.yuan.ticket.bean.vo.StationVo;
import com.yuan.ticket.bean.vo.TrainVo;
import com.yuan.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping("/stations")
    public List<StationVo> listStation(){
        return ticketService.listStation();
    }

    @RequestMapping("/trains")
    public List<TrainVo> listTrain(TrainQo trainQo){
        return ticketService.listTrain(trainQo);
    }
}
