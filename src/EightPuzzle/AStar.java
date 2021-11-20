package EightPuzzle;

import java.util.PriorityQueue;

public class AStar {
    int[][] current, solved = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    int cost, steps;
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    AStar(int[][] array) {
        current = array;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                System.out.print(current[i][j]);
        System.out.println();
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                System.out.print(solved[i][j]);
        System.out.println();
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++)
                if (current[i][j] != solved[i][j]) cost++;
        System.out.println("Cost: " + cost);
        System.out.println("Steps: " + steps);
    }
    public void BuildPQ() {
    }
}