package com.gridnine.testing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Filter_3 implements FlightFilter{
    // 2 часа
    long maxTimeOnEarthMs = 7200000;
    List<Flight> listEditFlight_3 = new ArrayList<>();
    @Override
    public List<Flight> filter(List<Flight> list) {

            for (Flight flight : list) {
                long currSegmentsTotalTimeOnEarth = 0;
                List<Segment> segments = flight.getSegments();
                int segmentsSize = segments.size();

                if (segmentsSize == 1) {
                    listEditFlight_3.add(flight);
                    continue;
                }

                for (int i = 0; i < segmentsSize - 1; i++) {
                    Segment currSegment = segments.get(i);
                    Segment nextSegment = segments.get(i + 1);
                    currSegmentsTotalTimeOnEarth = currSegmentsTotalTimeOnEarth + Duration.between(currSegment.getArrivalDate(), nextSegment.getDepartureDate()).toMillis();
                    if (currSegmentsTotalTimeOnEarth > maxTimeOnEarthMs) {
                        break;
                    }
                }

                if (currSegmentsTotalTimeOnEarth <= maxTimeOnEarthMs) {
                    listEditFlight_3.add(flight);
                }
            }

        return listEditFlight_3;
    }

}
