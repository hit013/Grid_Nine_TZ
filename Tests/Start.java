package com.gridnine.Tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.gridnine.Tests.FlightBuilder.createFlights;
import static com.gridnine.Tests.ListNameFilter.*;

public class Start {

   public HashMap<Enum, List<Flight>> mapStartFilter = new HashMap<>();

   public void startFilter(List<Flight> listFlights , ListNameFilter filterEnum){

       System.out.println(mapStartFilter.get(filterEnum));
   }

    public static void main(String[] args) {
        Start s = new Start();
        s.mapStartFilter.put(FILTER1,new Filter_1().filter(new ArrayList<>()));
        s.mapStartFilter.put(FILTER2,new Filter_2().filter(new ArrayList<>()));
        s.mapStartFilter.put(FILTER3,new Filter_3().filter(new ArrayList<>()));

        s.startFilter(createFlights(),FILTER1);

    }
}
