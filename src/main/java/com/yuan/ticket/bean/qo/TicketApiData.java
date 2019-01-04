package com.yuan.ticket.bean.qo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketApiData {

    @JsonProperty(value = "A4")
    private String A4;

    @JsonProperty(value = "A1")
    private String A1;

    @JsonProperty(value = "WZ")
    private String WZ;

    @JsonProperty(value = "O")
    private String O;

    @JsonProperty(value = "M")
    private String M;

    @JsonProperty(value = "A3")
    private String A3;

}
