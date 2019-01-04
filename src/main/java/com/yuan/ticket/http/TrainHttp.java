package com.yuan.ticket.http;

import com.yuan.ticket.bean.qo.TicketAPIQo;
import com.yuan.ticket.bean.qo.TrainQo;
import com.yuan.ticket.bean.vo.TrainAPIVo;
import com.yuan.ticket.util.date.DateKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class TrainHttp {

    @Autowired
    private RestTemplate restTemplate;

    private static final String QUERY_TRAIN = "https://kyfw.12306.cn/otn/leftTicket/queryZ";


    public TrainAPIVo listTrain(TrainQo trainQo){
        String url = QUERY_TRAIN + "?leftTicketDTO.train_date="+trainQo.getDate()+"&leftTicketDTO.from_station=" +
                trainQo.getFromStation()+"&leftTicketDTO.to_station="+trainQo.getToStation()+"&purpose_codes=ADULT";
        System.out.println(url);
        return restTemplate.getForObject(url,TrainAPIVo.class);
    }

    public TicketAPIQo getPrice(String no,String sn,String tn,String type, String date){
        String url = "https://kyfw.12306.cn/otn/leftTicket/queryTicketPrice?train_no="+no+"&from_station_no="+sn+"&to_station_no="+tn+
                "&seat_types="+type+"&train_date="+date;
        System.out.println(url);
//        ResponseEntity<String> responseEntity =  restTemplate.getForEntity(url,String.class);
//        System.out.println(responseEntity.getBody());
        TicketAPIQo result = new TicketAPIQo();
        try{
            result = restTemplate.getForObject(url,TicketAPIQo.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
