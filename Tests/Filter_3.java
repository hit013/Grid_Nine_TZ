package com.gridnine.Tests;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.gridnine.Tests.FlightBuilder.createFlights;

public class Filter_3 implements FlightFilter{

    List<Flight> listEditFlight_3 = new ArrayList<>();
    @Override
    public List<Flight> filter(List<Flight> list) {

        return listEditFlight_3;
    }
    public void arrivalDate_BeFore_DepartureDate_EditList(List<Flight> list) {

        //вывод 3. фильтрации (четвертая строка (5-ый сегмент)
        List<Segment> listEditFlight_3 = createFlights().stream()
                .flatMap(listSegment->listSegment.getSegments().stream()
                        .flatMap(segmentDate1->createFlights().stream()
                                .flatMap(segmentDate2->segmentDate2.getSegments().stream()
                                        .filter(segmentDate3-> (Duration.between(segmentDate1.getArrivalDate(),segmentDate3.getDepartureDate())).toHours()<=2)))).toList();

        //listEditFlight_3.forEach(el->System.out.println(el));

    }


    public static void main(String[] args) {
        Filter_3 f3 = new Filter_3();
        f3.arrivalDate_BeFore_DepartureDate_EditList(createFlights());
    }


}
