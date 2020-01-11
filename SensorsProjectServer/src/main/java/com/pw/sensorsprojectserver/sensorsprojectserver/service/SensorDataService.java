package com.pw.sensorsprojectserver.sensorsprojectserver.service;


import com.pw.sensorsprojectserver.sensorsprojectserver.model.SensorData;

import java.util.List;

public interface SensorDataService {

    public List<SensorData> findAll();

    public SensorData findById(int theId);

    public void save(SensorData theSensorData);

    public void deleteById(int theId);
}
