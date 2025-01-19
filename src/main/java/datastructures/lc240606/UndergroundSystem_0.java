package datastructures.lc240606;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem_0 {
    private Map<Integer, CheckInInfo> checkIns; // id, 紀錄 站名與時間
    private Map<String, TravelInfo> travelTimes; // key, 紀錄 總時間與計數

    public UndergroundSystem_0() {
        checkIns = new HashMap<>();
        travelTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) { // 進站時記錄:
    }

    public void checkOut(int id, String stationName, int t) { // 出站時
    }

    public double getAverageTime(String startStation, String endStation) {
        return 0;
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