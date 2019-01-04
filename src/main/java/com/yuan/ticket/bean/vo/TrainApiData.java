package com.yuan.ticket.bean.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class TrainApiData {

    private String flg;

    private List<String> result;


}
