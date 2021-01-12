package question1396_design_underground_system;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    private Map<String, Integer> string2Index = new HashMap<>();

    private int index;

    private static class Record {

        int time;

        int count;

        public Record(int time) {
            this.time = time;
            this.count = 1;
        }

    }

    private Map<Integer, Map<Integer, Record>> begin2End2Record = new HashMap<>();

    private Map<Integer, Map<Integer, Integer>> id2StationIndex2Time = new HashMap<>();

    public UndergroundSystem() {

    }
    
    public void checkIn(int id, String stationName, int t) {
        Integer stationIndex = string2Index.get(stationName);
        if (null == stationIndex) {
            string2Index.put(stationName, index);
            stationIndex = index++;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(stationIndex, t);
        id2StationIndex2Time.put(id, map);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int begin = id2StationIndex2Time.get(id).keySet().iterator().next();
        Integer end = string2Index.get(stationName);
        if (null == end) {
            string2Index.put(stationName, index);
            end = index++;
        }
        int time = t - id2StationIndex2Time.get(id).get(begin);
        Map<Integer, Record> end2Record = begin2End2Record.get(begin);
        if (null == end2Record) {
            Map<Integer, Record> map = new HashMap<>();
            map.put(end, new Record(time));
            begin2End2Record.put(begin, map);
        } else {
            Record record = end2Record.get(end);
            if (null == record) {
                end2Record.put(end, new Record(time));
            } else {
                record.time += time;
                record.count++;
            }
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int begin = string2Index.get(startStation), end = string2Index.get(endStation);
        Record record = begin2End2Record.get(begin).get(end);
        return record.time * 1.0 / record.count;
    }

}