package edu.project2;

import java.util.ArrayList;

public class Solver {
    private final Maze maze;

    public Solver(Maze maze) {
        this.maze = maze;
    }

    public void solve(boolean draw) {
        // слева сверху - вправо вниз
        this.solve(0, 0, maze.getDimensionY() - 1, maze.getDimensionY() - 1, draw);
    }

    public boolean solve(int startX, int startY, int endX, int endY, boolean draw) {
        prepareCells();

        ArrayList<Cell> openCells = new ArrayList<>();

        Cell endCell = maze.getCell(endX, endY);

        removeStart(startX, startY, endCell, openCells);

        while (true) {
            if (openCells.isEmpty()) {
                return false;
            }
            openCells.sort(this::compareCells);
            Cell current = openCells.remove(0);
            if (current == endCell) {
                break;
            }

            iterateAndUpdateNeighbours(current, endCell, openCells);
        }

        Cell backtracking = endCell;
        backtracking.setInPath(true);
        while (backtracking.getParent() != null) {
            backtracking = backtracking.getParent();
            backtracking.setInPath(true);
        }

        if (draw) {
            maze.draw();
        }
        return true;
    }

    public String getSolutionString() {
        return maze.getMazeOutput();
    }

    private void removeStart(int startX, int startY, Cell endCell, ArrayList<Cell> openCells) {
        Cell start = maze.getCell(startX, startY);
        if (start == null) {
            return;
        }
        start.setProjectedDist(getProjectedDistance(start, 0, endCell));
        start.setVisited(true);
        openCells.add(start);
    }

    private void iterateAndUpdateNeighbours(Cell current, Cell endCell, ArrayList<Cell> openCells) {
        for (Cell neighbor : current.getNeighbors()) {
            double projDist = getProjectedDistance(neighbor,
                current.getTravelled() + 1, endCell
            );
            if (!neighbor.isVisited()
                || projDist < neighbor.getProjectedDist()) {
                neighbor.setParent(current);
                neighbor.setVisited(true);
                neighbor.setProjectedDist(projDist);
                neighbor.setTravelled((int) (current.getTravelled() + 1));
                if (!openCells.contains(neighbor)) {
                    openCells.add(neighbor);
                }
            }
        }
    }

    private void prepareCells() {
        for (Cell[] cellrow : maze.getCells()) {
            for (Cell cell : cellrow) {
                cell.setParent(null);
                cell.setVisited(false);
                cell.setInPath(false);
                cell.setTravelled(0);
                cell.setProjectedDist(-1);
            }
        }
    }

    private int compareCells(Cell cell1, Cell cell2) {
        double diff = cell1.getProjectedDist() - cell2.getProjectedDist();
        if (diff > 0) {
            return 1;
        } else if (diff < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    private double getProjectedDistance(Cell current, double travelled, Cell end) {
        return travelled + Math.abs(current.getX() - end.getX())
            + Math.abs(current.getY() - current.getX());
    }
}
