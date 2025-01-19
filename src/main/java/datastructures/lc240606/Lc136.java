package datastructures.lc240606;

public class Lc136 {
    public static void main(String[] args) {
        int[] ints = {4, 1, 2, 1, 2};
        singleNumber(ints);
    }
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums){
            result = result ^ i;
            System.out.println(result);
        }
        return result;
    }
}
