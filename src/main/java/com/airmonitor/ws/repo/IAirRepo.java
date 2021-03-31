package com.airmonitor.ws.repo;

import com.airmonitor.ws.entity.Air;

import java.util.List;

public interface IAirRepo {
    void sendAirEntry(Air airEntry);

    Air getLatestMeasurement();

    List<Air> getAllEntries();
}
