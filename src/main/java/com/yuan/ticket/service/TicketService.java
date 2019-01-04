package com.yuan.ticket.service;

import com.yuan.ticket.bean.entity.Station;
import com.yuan.ticket.bean.qo.TrainQo;
import com.yuan.ticket.bean.vo.StationVo;
import com.yuan.ticket.bean.vo.TrainAPIVo;
import com.yuan.ticket.bean.vo.TrainVo;
import com.yuan.ticket.http.TrainHttp;
import com.yuan.ticket.util.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {

    private static final List<Station> stationList = new ArrayList<>();
    private static final List<StationVo> stationVoList = new ArrayList<>();
    static {
       String temp = PropertiesUtil.getProperty("stations");
       String[] arr =  temp.split("@");
       for (int i=1; i<arr.length; i++){
           String[] arrTemp = arr[i].split("\\|");
           stationList.add(new Station(arrTemp[1],arrTemp[2]));
           stationVoList.add(new StationVo(arrTemp[1]));
       }
   }

   @Autowired
   private TrainHttp trainHttp;

    public List<StationVo> listStation(){
       return stationVoList;
    }

    public List<TrainVo> listTrain(TrainQo trainQo){
        String fromStation = trainQo.getFromStation();
        String toStation = trainQo.getToStation();
        List<TrainVo> result = new ArrayList<>();
        trainQo.setFromStation(getStationNo(trainQo.getFromStation()));
        trainQo.setToStation(getStationNo(trainQo.getToStation()));
        try{
            TrainAPIVo trainAPIVo = trainHttp.listTrain(trainQo);
            List<String> trainList = trainAPIVo.getTrainApiData().getResult();
            for (String item : trainList) {
                String[] temp = item.split("\\|");
                result.add(new TrainVo().builder().no(temp[2])
                        .train(temp[3])
                        .s(getStationName(temp[4]))
                        .e(getStationName(temp[5]))
                        .startingTime(temp[8])
                        .arrivalTime(temp[9])
                        .consuming(temp[10])
                        .seat(getSeat(temp))
                        .fromStation(fromStation)
                        .toStation(toStation)
                        .fs(getStationName(temp[6]))
                        .ts(getStationName(temp[7]))
                        .ticketApiData(trainHttp.getPrice(temp[2],temp[16],temp[17],temp[35],trainQo.getDate()).getTicketApiData())
                        .build());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private String getSeat(String[] strings){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<11;i++){
            stringBuilder.append(strings[32-i]+"|");
        }
        return stringBuilder.toString();
    }

    private String getStationNo(String stationName){
        for (Station item: stationList) {
            if (item.getName().equals(stationName)){
                return item.getNo();
            }
        }
        return null;
    }

    private String getStationName(String stationNo){
        for (Station item: stationList) {
            if (item.getNo().equals(stationNo)){
                return item.getName();
            }
        }
        return null;
    }
}
