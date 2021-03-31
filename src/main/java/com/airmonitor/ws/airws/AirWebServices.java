package com.airmonitor.ws.airws;

import com.airmonitor.ws.entity.Air;
import com.airmonitor.ws.repo.IAirRepo;
import com.airmonitor.ws.repo.impl.ConnectionPool;
import com.airmonitor.ws.repo.impl.PostgresAirMonitorRepo;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.List;

@RestController
public class AirWebServices {
    private IAirRepo airRepo;

    @CrossOrigin
    @PostMapping("/air/entry/")
    public Air sendAirEntry(
            @RequestParam(value = "Pm") double pm,
            @RequestParam(value = "Co") double co,
            @RequestParam(value = "Alcohol") double alcohol,
            @RequestParam(value = "Co2") double co2,
            @RequestParam(value = "Toluene") double toluene,
            @RequestParam(value = "Nh4") double nh4,
            @RequestParam(value = "Acetone") double acetone,
            @RequestParam(value = "Humidity") double humidity,
            @RequestParam(value = "Temperature") double temperature,
            @RequestParam(value = "Latitude") double latitude,
            @RequestParam(value = "Longitude") double longitude) {

        initRepos();
        Air airEntry = new Air();

        airEntry.setPm(pm);
        airEntry.setCo(co);
        airEntry.setAlcohol(alcohol);
        airEntry.setCo2(co2);
        airEntry.setToluene(toluene);
        airEntry.setNh4(nh4);
        airEntry.setAcetone(acetone);
        airEntry.setHumidity(humidity);
        airEntry.setTemperature(temperature);
        airEntry.setLatitude(latitude);
        airEntry.setLongitude(longitude);

        airRepo.sendAirEntry(airEntry);
        return airEntry;
    }

    @CrossOrigin
    @GetMapping("/air/")
    public Air getLatestMeasurement() {
        initRepos();
        return airRepo.getLatestMeasurement();
    }

    @CrossOrigin
    @GetMapping("/air/getall")
    public List<Air> getAllEntries() {
        initRepos();
        return airRepo.getAllEntries();
    }

    private void initRepos() {
        if (airRepo == null) {
            Connection connection = ConnectionPool.getConnection();
            if (connection == null)
                throw new IllegalStateException();
            airRepo = new PostgresAirMonitorRepo(connection);
        }
    }
}
