package com.example.tra.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "train")
public class Tra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long TrainId;
    String name;
    String fromLocation;
    String toLocation;
    public long getTrainId() {
        return TrainId;
    }
    public void setTrainId(long trainId) {
        TrainId = trainId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFromLocation() {
        return fromLocation;
    }
    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }
    public String getToLocation() {
        return toLocation;
    }
    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }
    
}
