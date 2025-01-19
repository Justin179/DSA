package datastructures.lc240606;

import java.util.LinkedList;
import java.util.Queue;

public class Lc838 {
    public static void main(String[] args) {
        String dominoes = ".L.R...LR..L..";
        pushDominoes(dominoes);
    }
    public static String pushDominoes(String dominoes) { // .L.R...LR..L..
        int len = dominoes.length();
        Queue<Integer> q = new LinkedList<>();
        char[] dom = dominoes.toCharArray(); // .L.R...LR..L..
        for (int i = 0; i < len; i++)
            if (dominoes.charAt(i) != '.')
                q.offer(i); //

        while (!q.isEmpty()) {
            int i = q.poll(); // 1 3 7 8 11
            char ch = dom[i]; // L R L R L
            if (dom[i] == 'R') {
                if (i + 1 < len && dom[i + 1] == '.') {
                    if (i + 2 < len && dom[i + 2] == 'L') {
                        q.poll();
                    } else {
                        dom[i + 1] = 'R';
                        q.offer(i + 1);
                    }
                }
            } else if (i > 0 && dom[i - 1] == '.') { // 前一個是.
                dom[i - 1] = 'L';
                q.offer(i - 1);
            }
        }

        return String.valueOf(dom);
    }
}