package com.gridnine.Tests;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.gridnine.Tests.FlightBuilder.createFlights;

public class Filter_1 implements FlightFilter {

    LocalDateTime currentTime = LocalDateTime.now();
     List<Flight> listEditFlight_1 = new ArrayList<>();

    @Override
    public List<Flight> filter(List<Flight> list) {
        listEditFlight_1 = list.stream()
                .filter(listSegment->listSegment.getSegments().stream()
                        .noneMatch(segmentDate-> segmentDate.getDepartureDate().isBefore(currentTime)))
                .toList();

        return listEditFlight_1;
    }

                         // 1.Фильтр возвр коллекцию отредкт
    public void departureDate_BeFore_CurrentTime_EditList(List<Flight> list) {
        //listEditFlight_1.forEach(el->System.out.println(el));
    }


    public static void main(String[] args) {
        Filter_1 f1 = new Filter_1();
        //f1.departureDate_BeFore_CurrentTime_EditList(createFlights());
    }
}
