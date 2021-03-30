package com.airmonitor.ws.entity;

public class Air {

    private double pm;
    private double co;
    private double alcohol;
    private double co2;
    private double toluene;
    private double nh4;
    private double acetone;
    private double humidity;
    private double temperature;
    private double latitude;
    private double longitude;


    public double getPm() {
        return pm;
    }

    public void setPm(double pm) {
        this.pm = pm;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public double getCo2() {
        return co2;
    }

    public void setCo2(double co2) {
        this.co2 = co2;
    }

    public double getToluene() {
        return toluene;
    }

    public void setToluene(double toluene) {
        this.toluene = toluene;
    }

    public double getNh4() {
        return nh4;
    }

    public void setNh4(double nh4) {
        this.nh4 = nh4;
    }

    public double getAcetone() {
        return acetone;
    }

    public void setAcetone(double acetone) {
        this.acetone = acetone;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Air entry: {PM: " + pm + ",Co: " + co
                + ",Alcohol: " + alcohol + ",Co2: " + co2
                + ",Tolulene: " + toluene + ",Nh4: " + nh4
                + ",Acetone: " + acetone + ",Humidity: " + humidity
                + ",Temperature: " + temperature + "}";
    }


}

