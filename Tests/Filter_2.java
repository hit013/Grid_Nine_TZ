package com.gridnine.Tests;

import java.util.ArrayList;
import java.util.List;

import static com.gridnine.Tests.FlightBuilder.createFlights;

public class Filter_2 implements FlightFilter{
    List<Flight> listEditFlight_2 = new ArrayList<>();

    @Override
    public List<Flight> filter(List<Flight> list) {

        return listEditFlight_2;
    }

    // 1.Фильтр возвр коллекцию отредкт
    public void arrivalDate_BeFore_DepartureDate_EditList(List<Flight> list) {

        listEditFlight_2 = createFlights().stream()
                .filter(listSegment->listSegment.getSegments().stream()
                        .allMatch(segmentDate-> segmentDate.getDepartureDate().isBefore(segmentDate.getArrivalDate())))
                            .toList();

        listEditFlight_2.forEach(el->System.out.println(el));

    }


    public static void main(String[] args) {
        Filter_2 f2 = new Filter_2();
        f2.arrivalDate_BeFore_DepartureDate_EditList(createFlights());
    }
}
