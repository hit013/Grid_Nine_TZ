package com.gridnine.Tests;

import com.sun.jdi.connect.Connector;

import java.text.Format;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.gridnine.Tests.FlightBuilder.createFlights;
import static java.time.Period.between;
import static java.util.Locale.filter;
import static java.util.stream.Collectors.*;

public class Main {


//    @Override
//    public String toString() {
//        return listEditFlight_1.stream().map(Object::toString)
//                .collect(Collectors.joining(" xyz "));
//    }

    public static void main(String[] args) {

        //System.out.println(FlightBuilder.createFlights());

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime date1 = LocalDateTime.now().plusDays(2).truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime date2 = LocalDateTime.now().minusHours(2).truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime date3 = LocalDateTime.now().minusMinutes(10).truncatedTo(ChronoUnit.SECONDS);
        LocalDateTime date4 = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);

        List<LocalDateTime> listDate = new ArrayList<>();
        listDate.add(date1);
        listDate.add(date2);
        listDate.add(date3);
        listDate.add(date4);
       // System.out.println(listDate);

        Stream<LocalDateTime> stream2 = listDate.stream().flatMap((el1)-> listDate.stream()
                .filter(el2-> (Duration.between(el1,el2).toHours())<=2));


       // stream2.forEach(el->System.out.println(el));

        //вывод всех сегментов Полетов
         FlightBuilder.createFlights().forEach(ListSegment->System.out.println(ListSegment));


        System.out.println();



        // 1. через фореч луп(а не флетМеп перебор вложенной коллекции), не получается сохранить в коллекцию , только вывод через луп в конце
        //createFlights().forEach(ListSegment->ListSegment.getSegments().stream().filter(segmentDate->!segmentDate.getDepartureDate().isBefore(currentTime))
        //         .forEach(date->System.out.println(date)));



        //вывод 2. фильтрации
        List<Segment> listEditFlight_2 =  createFlights().stream()
                .flatMap(listSegment->listSegment.getSegments().stream()
                        .filter(segmentDate->!segmentDate.getArrivalDate().isBefore(segmentDate.getDepartureDate()))).toList();

        //listEditFlight_2.forEach(el->System.out.println(el));


    }
}
