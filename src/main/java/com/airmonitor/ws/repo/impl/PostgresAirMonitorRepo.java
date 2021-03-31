package com.airmonitor.ws.repo.impl;

import com.airmonitor.ws.entity.Air;
import com.airmonitor.ws.repo.IAirRepo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class PostgresAirMonitorRepo implements IAirRepo {

    private final Connection connection;
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PostgresAirMonitorRepo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void sendAirEntry(Air airEntry) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp formattedTimestamp = Timestamp.valueOf(timeFormat.format(timestamp));
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO air(date, pm, co, alcohol, co2, toluene, nh4, acetone, humidity, temperature, latitude, longitude) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setTimestamp(1, formattedTimestamp);
            preparedStatement.setDouble(2, airEntry.getPm());
            preparedStatement.setDouble(3, airEntry.getCo());
            preparedStatement.setDouble(4, airEntry.getAlcohol());
            preparedStatement.setDouble(5, airEntry.getCo2());
            preparedStatement.setDouble(6, airEntry.getToluene());
            preparedStatement.setDouble(7, airEntry.getNh4());
            preparedStatement.setDouble(8, airEntry.getAcetone());
            preparedStatement.setDouble(9, airEntry.getHumidity());
            preparedStatement.setDouble(10, airEntry.getTemperature());
            preparedStatement.setDouble(11, airEntry.getLatitude());
            preparedStatement.setDouble(12, airEntry.getLongitude());
            int resultSet = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Air getLatestMeasurement() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM air WHERE entryid=(SELECT max(entryid) FROM air)");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return null;
            Air airEntry = new Air();

            airEntry.setPm(resultSet.getDouble(3));
            airEntry.setCo(resultSet.getDouble(4));
            airEntry.setAlcohol(resultSet.getDouble(5));
            airEntry.setCo2(resultSet.getDouble(6));
            airEntry.setToluene(resultSet.getDouble(7));
            airEntry.setNh4(resultSet.getDouble(8));
            airEntry.setAcetone(resultSet.getDouble(9));
            airEntry.setHumidity(resultSet.getDouble(10));
            airEntry.setTemperature(resultSet.getDouble(11));
            airEntry.setLatitude(resultSet.getDouble(12));
            airEntry.setLongitude(resultSet.getDouble(13));

            return airEntry;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Air> getAllEntries() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM air ORDER BY entryid DESC LIMIT 100;");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Air> airList = new LinkedList<>();
            if (!resultSet.next())
                return null;
            while (resultSet.next()) {
                Air airEntry = new Air();
                airEntry.setPm(resultSet.getDouble(3));
                airEntry.setCo(resultSet.getDouble(4));
                airEntry.setAlcohol(resultSet.getDouble(5));
                airEntry.setCo2(resultSet.getDouble(6));
                airEntry.setToluene(resultSet.getDouble(7));
                airEntry.setNh4(resultSet.getDouble(8));
                airEntry.setAcetone(resultSet.getDouble(9));
                airEntry.setHumidity(resultSet.getDouble(10));
                airEntry.setTemperature(resultSet.getDouble(11));
                airEntry.setLatitude(resultSet.getDouble(12));
                airEntry.setLongitude(resultSet.getDouble(13));
                airList.add(airEntry);
            }
            return airList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

