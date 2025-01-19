package datastructures.lc240606;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkIns; // id, 紀錄 站名與時間
    private Map<String, TravelInfo> travelTimes; // key, 紀錄 總時間與計數

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) { // 進站時記錄:
        checkIns.put(id, new CheckInInfo(stationName, t)); // id 站名 時間
    }

    public void checkOut(int id, String stationName, int t) { // 出站時
        CheckInInfo checkInInfo = checkIns.remove(id); // 取出: id 站名 時間
        String travel = checkInInfo.stationName + "," + stationName; // "進,出" as key
        int travelTime = t - checkInInfo.checkInTime; // 總旅程耗時

        if (travelTimes.containsKey(travel)) {
            TravelInfo travelInfo = travelTimes.get(travel); // 取出 總時間與計數
            travelInfo.totalTime += travelTime;
            travelInfo.count++;
        } else {
            travelTimes.put(travel, new TravelInfo(travelTime, 1)); // 新的就 count as one
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String travel = startStation + "," + endStation;
        TravelInfo travelInfo = travelTimes.get(travel); // 取出 總時間與計數
        return (double) travelInfo.totalTime / travelInfo.count;
    }

    private class CheckInInfo {
        String stationName; // 站名
        int checkInTime; // 時間

        public CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private class TravelInfo {
        int totalTime; // 總時間
        int count; // 計數

        public TravelInfo(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}