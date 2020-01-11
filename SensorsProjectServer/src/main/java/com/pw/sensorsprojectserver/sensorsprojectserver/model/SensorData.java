package com.pw.sensorsprojectserver.sensorsprojectserver.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sensorsdata")
public class SensorData {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="deviceID")
    public int deviceID;

    @Column(name="measurement")
    private int measurement;

    @Column(name="timestamp")
    private Date timestamp;

    public SensorData(){
    }

    public SensorData(int id, int deviceID, int measurement, Date timestamp) {
        this.id = id;
        this.deviceID = deviceID;
        this.measurement = measurement;
        this.timestamp = (Date)timestamp.clone();
    }

    public SensorData(int deviceID, int measurement, Date timestamp) {
        this.deviceID = deviceID;
        this.measurement = measurement;
        this.timestamp = (Date)timestamp.clone();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public int getMeasurement() {
        return measurement;
    }

    public void setMeasurement(int measurement) {
        this.measurement = measurement;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "id=" + id +
                ", deviceID=" + deviceID +
                ", measurement=" + measurement +
                ", timestamp=" + timestamp.toString() +
                '}';
    }

}
