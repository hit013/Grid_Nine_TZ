package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

import static com.gridnine.testing.FlightBuilder.createFlights;

public class Filter_2 implements FlightFilter {
    // Вылет после прилета
    List<Flight> listEditFlight_2 = new ArrayList<>();

    @Override
    public List<Flight> filter(List<Flight> list) {
        listEditFlight_2 = createFlights().stream()
                .filter(listSegment -> listSegment.getSegments().stream()
                        .allMatch(segmentDate -> segmentDate.getDepartureDate().isBefore(segmentDate.getArrivalDate())))
                .toList();

        return listEditFlight_2;
    }
}
