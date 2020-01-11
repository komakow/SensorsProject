package com.pw.sensorsprojectserver.sensorsprojectserver.controller;

import com.pw.sensorsprojectserver.sensorsprojectserver.service.SensorDataService;
import com.pw.sensorsprojectserver.sensorsprojectserver.model.SensorData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/sensorData")
public class SensorDataController {

    private SensorDataService sensorDataService;

    // load sensorData data
    public SensorDataController(SensorDataService theSensorDataService) {
        sensorDataService = theSensorDataService;
    }

    // add mapping for "/list"

    @RequestMapping("/list")
    public String listSensorData(Model theModel){

        List<SensorData> theSensorData = sensorDataService.findAll();
        theModel.addAttribute("sensorData", theSensorData);

        return "myAccount";
    }

    @GetMapping("/showMyLoginPage")
    public String showMyLoginPage() {

        return "sensorData/plain-login";
    }

    @GetMapping("/graphSensorData")
    public String graphSensorData(Model theModel){

        List<SensorData> theSensorData = sensorDataService.findAll();
        Map<Date, Integer> sensorDataMaps = new TreeMap<>();

        for(SensorData sensorDataMap : theSensorData)
        {
            sensorDataMaps.put(sensorDataMap.getTimestamp(), sensorDataMap.getMeasurement());
        }
        theModel.addAttribute("sensorDataMaps", sensorDataMaps);
        return "sensorData/graph-sensorData";
    }

    @GetMapping("/{deviceID}/{measurement}")
    public String  addMeasurement(@PathVariable int deviceID, @PathVariable int measurement) {

        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        SensorData sensorData = new SensorData();
        sensorData.setDeviceID(deviceID);
        sensorData.setMeasurement(measurement);
        sensorData.setTimestamp(date);
        sensorDataService.save(sensorData);

        return "myAccount";
    }

}
