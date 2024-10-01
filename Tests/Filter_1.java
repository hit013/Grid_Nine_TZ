package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Filter_1 implements FlightFilter {
    //вылет до наст врем
    LocalDateTime currentTime = LocalDateTime.now();
    List<Flight> listEditFlight_1 = new ArrayList<>();


    @Override
    public List<Flight> filter(List<Flight> list) {
        listEditFlight_1 = list.stream()
                .filter(listSegment -> listSegment.getSegments().stream()
                        .noneMatch(segmentDate -> segmentDate.getDepartureDate().isBefore(currentTime)))
                .toList();

        return listEditFlight_1;
    }


}
