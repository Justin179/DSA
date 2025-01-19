package datastructures.lc240606;

import java.util.Arrays;

public class Lc881 {
    public static void main(String[] args) {
        int[] people = {3,2,2,1};
        numRescueBoats(people,3);
    }
    public static int numRescueBoats(int[] people, int limit) {
        int i = 0;
        int j = people.length - 1;
        Arrays.sort(people);
        int numOfBoat = 0;
        while(i<j){
            if(people[i]+people[j] <= limit){
                i++;
                j--;
            } else {
                j--;
            }
            numOfBoat++;
        }
        return i==j? numOfBoat+1:numOfBoat;
    }
}
