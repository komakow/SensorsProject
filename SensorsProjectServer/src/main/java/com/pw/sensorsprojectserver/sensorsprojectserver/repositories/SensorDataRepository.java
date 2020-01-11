package com.pw.sensorsprojectserver.sensorsprojectserver.repositories;

import com.pw.sensorsprojectserver.sensorsprojectserver.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Integer> {

    // add a method to sort by last name
    public List<SensorData> findAllByOrderByIdAsc();
}
