package com.gridnine.testing;

import java.util.HashMap;
import java.util.List;

import static com.gridnine.testing.FlightBuilder.createFlights;

public class Start {

    public HashMap<ListNameFilter, FlightFilter> mapStartFilter = new HashMap<>() {{
        put(ListNameFilter.FILTER1, new Filter_1());
        put(ListNameFilter.FILTER2, new Filter_2());
        put(ListNameFilter.FILTER3, new Filter_3());
    }};

    public List<Flight> startFilter(ListNameFilter filterEnum, List<Flight> listFlights) {
        FlightFilter flightFilter = mapStartFilter.get(filterEnum);

        return flightFilter.filter(listFlights);
    }

    public static void main(String[] args) {
        Start s = new Start();
        List<Flight> resultListEditFilter_1 = s.startFilter(ListNameFilter.FILTER1, createFlights());
       // resultListEditFilter_1.forEach(el -> System.out.println(el));
        System.out.println();
        List<Flight> resultListEditFilter_2 = s.startFilter(ListNameFilter.FILTER2, createFlights());
        //resultListEditFilter_2.forEach(el -> System.out.println(el));
        System.out.println();
        List<Flight> resultListEditFilter_3 = s.startFilter(ListNameFilter.FILTER3, createFlights());
        resultListEditFilter_3.forEach(el -> System.out.println(el));
    }
}
