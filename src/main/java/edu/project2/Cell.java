package edu.project2;

import java.util.ArrayList;

public class Cell {
    // позиция по x
    private final int x;

    // позиция по y
    private final int y;

    // ячейки - соседи
    private final ArrayList<Cell> neighbors = new ArrayList<>();

    // была ли посещена текущая ячейка при обходе
    private boolean visited = false;

    // предыдущая ячейка в пути
    private Cell parent = null;

    // в пути текущая ячейка или нет
    private boolean inPath = false;

    // пройденное расстояние
    private double travelled;

    // прогнозируемое расстояние до конца
    private double projectedDist;

    // стена или нет
    private boolean wall = true;

    // использовалась или нет при генерации
    private boolean open = true;

    public Cell(int x, int y, boolean isWall) {
        this.x = x;
        this.y = y;
        this.wall = isWall;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ArrayList<Cell> getNeighbors() {
        return neighbors;
    }

    public boolean isWall() {
        return wall;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void addNeighbor(Cell other) {
        // на всякий случай проверяем дубликаты
        if (!this.neighbors.contains(other)) {
            // добавляем текущей ячейке - соседа
            this.neighbors.add(other);
        }

        if (!other.neighbors.contains(this)) {
            // добавляем соседу - текущую ячейку
            other.neighbors.add(this);
        }
    }

    public boolean isInPath() {
        return inPath;
    }

    public void setInPath(boolean inPath) {
        this.inPath = inPath;
    }

    public Cell getParent() {
        return parent;
    }

    public void setParent(Cell parent) {
        this.parent = parent;
    }

    public double getProjectedDist() {
        return projectedDist;
    }

    public void setProjectedDist(double projectedDist) {
        this.projectedDist = projectedDist;
    }

    public double getTravelled() {
        return travelled;
    }

    public void setTravelled(int travelled) {
        this.travelled = travelled;
    }

    public boolean isCellBelowNeighbor() {
        return this.neighbors.contains(new Cell(this.x, this.y + 1, true));
    }

    public boolean isCellRightNeighbor() {
        return this.neighbors.contains(new Cell(this.x + 1, this.y, true));
    }

    @Override
    public String toString() {
        return String.format("Cell(%s, %s)", x, y);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Cell)) {
            return false;
        }
        Cell otherCell = (Cell) other;
        return (this.x == otherCell.x && this.y == otherCell.y);
    }

    @Override
    public int hashCode() {
        return this.x + this.y * 256;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
