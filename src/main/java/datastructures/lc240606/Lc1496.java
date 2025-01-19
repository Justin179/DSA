package datastructures.lc240606;

import java.util.HashSet;
import java.util.Set;

public class Lc1496 {
    public boolean isPathCrossing(String path) { // "NES"
        // Initialize current position (0,0) and a set to track visited positions
        int x = 0;
        int y = 0;
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        // Traverse each character in the path
        for (char direction : path.toCharArray()) {
            // Update current position based on the direction
            switch (direction) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            // Construct a string representing the current position
            String currentPos = x + "," + y;

            // Check if the current position has been visited before
            // The add() method returns true if this set did not already contain the specified element.
            if (!visited.add(currentPos)) {
                return true; // If already visited, return true
            }
        }

        return false; // If no crossing is found, return false
    }
}
