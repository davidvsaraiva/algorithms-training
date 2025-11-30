package simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Bomberman lives in a rectangular grid. Each cell in the grid either contains a bomb or nothing at all.
 *
 * Each bomb can be planted in any cell of the grid but once planted, it will detonate after exactly 3 seconds. Once a bomb
 * detonates, it's destroyed — along with anything in its four neighboring cells. This means that if a bomb detonates in cell , any valid cells  and  are cleared. If there is a bomb in a neighboring cell, the neighboring bomb is destroyed without detonating, so there's no chain reaction.
 *
 * Bomberman is immune to bombs, so he can move freely throughout the grid. Here's what he does:
 * 1. Initially, Bomberman arbitrarily plants bombs in some of the cells, the initial state.
 * 2. After one second, Bomberman does nothing.
 * 3. After one more second, Bomberman plants bombs in all cells without bombs, thus filling the whole grid with bombs.
 * No bombs detonate at this point.
 * 4. After one more second, any bombs planted exactly three seconds ago will detonate. Here, Bomberman stands back and observes.
 * 5. Bomberman then repeats steps 3 and 4 indefinitely.
 *
 * Note that during every second Bomberman plants bombs, the bombs are planted simultaneously (i.e., at the exact same
 * moment), and any bombs planted at the same time will detonate at the same time.
 *
 * The following solution detects when a cycle repeats and stops calculating new grids. However, this is not the most
 * optimal solution - actually there are only 3 distinct grids that ever matter:
 *
 * 1. "Initial grid" (t = 1)"
 * 2. "Grid at t = 3"
 * 3. "Grid at t = 5"
 *
 * When solving this, I haven't realized this pattern and I have built also cycle detection code.
 *
 * See <a href="https://www.hackerrank.com/challenges/bomber-man/problem">
 * HackerRank – The Bomberman Game
 */
public class Bomberman {

    private static final boolean DEBUG = true;

    public static void main(String[]args){
        List<String> grid = new ArrayList<>(
                Arrays.asList(".......",
                        "...O.O.",
                        "....O..",
                        "..O....",
                        "OO...OO",
                        "OO.O..."));
        System.out.println(bomberMan(5, grid));
    }

    public static List<String> bomberMan(int n, List<String> grid) {
        int rowsLen = grid.size();
        int columnsLen = grid.get(0).length();
        if (n == 1) {
            return grid;
        }
        if(n % 2 == 0){
            return getAllBombsGrid(rowsLen, columnsLen);
        }
        Map<String, Integer> gridsAtWithoutAllBombs = new HashMap<>();
        List<List<String>> allGrids = new ArrayList<>();
        List<String> allBombs = getAllBombsGrid(rowsLen, columnsLen);
        gridsAtWithoutAllBombs.put(toKey(grid), 1);
        allGrids.add(grid);
        allGrids.add(allBombs);

        List<String> nextGrid = new ArrayList<>();
        int stepsSinceFull = 1;
        int repeatCycle = -1;
        Integer startCycle = null;

        for(int round = 3; round <= n; round++, stepsSinceFull++) {
            if (stepsSinceFull == 2) {
                stepsSinceFull = 0;
                nextGrid = new ArrayList<>(allBombs);
                allGrids.add(nextGrid);
                debugGrid(nextGrid);
                continue;
            }
            nextGrid = calculateNewGrid(grid, allBombs, rowsLen, columnsLen);
            grid = new ArrayList<>(nextGrid);
            startCycle = gridsAtWithoutAllBombs.putIfAbsent(toKey(grid), round);
            allGrids.add(nextGrid);
            if (startCycle != null) {
                repeatCycle = round - startCycle;
                break;
            }
            debugGrid(grid);
        }
        if (repeatCycle != -1) {
            int effectiveRound = startCycle + (n - startCycle) % repeatCycle;
            nextGrid = allGrids.get(effectiveRound-1);
        }
        return nextGrid;
    }

    private static List<String> calculateNewGrid(List<String> grid, List<String> templateAllBombs, int rowsLen, int columnsLen) {
        List<String> nextGrid = new ArrayList<>(templateAllBombs);
        List<Coordinate> bombs = getBombLocations(grid, rowsLen);
        char[][] nextGridArray = toCharArray(nextGrid, rowsLen, columnsLen);
        bombs.forEach((coordinate) -> setExplosions(coordinate.i, coordinate.j, nextGridArray));
        return toStringList(nextGridArray);
    }

    private static List<Coordinate> getBombLocations(List<String> grid, int rowsLen) {
        List<Coordinate> bombs = new ArrayList<>();
        for(int i = 0; i < rowsLen; i++) {
            String row = grid.get(i);
            for (int j = 0; j < row.length(); j++) {
                if (row.charAt(j) == 'O') {
                    bombs.add(new Coordinate(i, j));
                }
            }
        }
        return bombs;
    }

    public record Coordinate(int i, int j) {}

    private static void setExplosions(int i, int j, char[][] nextGrid) {
        if(i != 0 && nextGrid[i-1][j] == 'O') {
            nextGrid[i-1][j] = '.';
        }
        if(i != (nextGrid.length - 1) && nextGrid[i+1][j] == 'O') {
            nextGrid[i+1][j] = '.';
        }
        if(j != 0 && nextGrid[i][j-1] == 'O') {
            nextGrid[i][j-1] = '.';
        }
        if(j != (nextGrid[0].length - 1) && nextGrid[i][j+1] == 'O') {
            nextGrid[i][j+1] = '.';
        }
        if (nextGrid[i][j] == 'O') {
            nextGrid[i][j] = '.';
        }
    }

    private static List<String> getAllBombsGrid(int rows, int columns) {
        String row = "O".repeat(Math.max(0, columns));
        List<String> grid =  new ArrayList<>();
        for(int i = 0; i < rows; i++){
            grid.add(row);
        }
        return grid;
    }

    /**
     * Transform List into String by joining a char that never appears in the grid, e.g. ';'
     */
    private static String toKey(List<String> grid) {
        StringBuilder sb = new StringBuilder();
        for (String row : grid) {
            sb.append(row).append(';');
        }
        return sb.toString();
    }

    private static char[][] toCharArray(List<String> grid, int rowsLen, int columnsLen) {
        char[][] array = new char[rowsLen][columnsLen];
        for(int row = 0; row < rowsLen; row++){
            array[row] = grid.get(row).toCharArray();
        }
        return array;
    }

    private static List<String> toStringList(char[][] grid) {
        List<String> res = new ArrayList<>(grid.length);
        for (char[] row : grid) {
            res.add(new String(row));
        }
        return res;
    }

    private static void debugGrid(List<String> grid) {
        if(!DEBUG) {
            return;
        }
        for(String s : grid) {
            System.out.println(s);
        }
        System.out.println();
        System.out.println();
    }
}