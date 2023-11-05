package edu.project2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.Random;

public class Maze {
    private final static Logger LOGGER = LogManager.getLogger("Maze");
    // символы для рисования
    private final char pathChar = '*';
    private final char emptyChar = ' ';
    private final char wallChar = 'X';
    private final char cellChar = ' ';
    // рандомный генератор, чтобы не создавать каждый раз новый
    private final Random random = new Random();
    // Размерность по x
    private int dimensionX;
    // размерность по y
    private int dimensionY;
    // размерность итогового грида по x (для рисования)
    private int gridDimensionX;
    // размерность итогового грида по y (для рисования)
    private int gridDimensionY;
    // сетка лабиринта (для рисования)
    private char[][] grid;
    // ячейки грида
    private Cell[][] cells;

    @SuppressWarnings("MagicNumber")
    public Maze(int xDimension, int yDimension) throws IllegalArgumentException {
        validateArguments(xDimension, yDimension);

        initializeStartData(xDimension, yDimension);
        init();
        generateMaze(getCell(0, 0));
    }

    public Maze(int xDimension, int yDimension, Cell[][] cells) throws IllegalArgumentException {
        validateArguments(xDimension, yDimension);

        initializeStartData(xDimension, yDimension);
        this.cells = cells;
        generateMaze(getCell(0, 0));
    }

    @SuppressWarnings("MagicNumber")
    private void initializeStartData(int xDimension, int yDimension) {
        dimensionX = xDimension;
        dimensionY = yDimension;
        gridDimensionX = xDimension * 4 + 1;
        gridDimensionY = yDimension * 2 + 1;
        grid = new char[gridDimensionX][gridDimensionY];
    }

    private void validateArguments(int xDimension, int yDimension) {
        if (xDimension < 1 || yDimension < 1) {
            throw new IllegalArgumentException("Wrong arguments");
        }
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getDimensionX() {
        return dimensionX;
    }

    public int getDimensionY() {
        return dimensionY;
    }

    private void init() {
        cells = new Cell[dimensionX][dimensionY];
        for (int x = 0; x < dimensionX; x++) {
            for (int y = 0; y < dimensionY; y++) {
                // еще ни одна ячейка не является стеной (пустое полотно)
                cells[x][y] = new Cell(x, y, false);
            }
        }
    }

    @SuppressWarnings("MagicNumber")
    private void generateMaze(Cell startAt) {
        // текущую ячейку больше нельзя использовать при генерации
        startAt.setOpen(false);

        // посещенные ячейки
        ArrayList<Cell> visitedCells = new ArrayList<>();
        visitedCells.add(startAt);

        // пока есть ячейки
        while (!visitedCells.isEmpty()) {
            Cell cell;

            // выбираем рандомную ячейку
            if (random.nextInt(10) == 0) {
                cell = visitedCells.remove(random.nextInt(visitedCells.size()));
            } else {
                cell = visitedCells.remove(visitedCells.size() - 1);
            }

            // получаем потенциальных соседей
            Cell[] potentialNeighbors = getPotentialNeighbours(cell);

            // фильтруем потенциальных соседей
            ArrayList<Cell> neighbors = filterNeighbours(potentialNeighbors);

            // если ничего не добавли, то пропускам итерацию
            if (neighbors.isEmpty()) {
                continue;
            }

            // выбираем рандомного соседа для ячейки
            Cell selected = neighbors.get(random.nextInt(neighbors.size()));

            // выбранная ячейка закрыта для посещения
            selected.setOpen(false);

            // добавляем выбранную ячейку в соседи к текущей
            cell.addNeighbor(selected);

            // добавляем текущую ячейку во все ячейки
            visitedCells.add(cell);

            // добавляем выбранную ячейку во все ячейки
            visitedCells.add(selected);
        }
    }

    // фильтрует потенциальных соседей
    private ArrayList<Cell> filterNeighbours(Cell[] potentialNeighbors) {
        // соседи ячейки
        ArrayList<Cell> neighbors = new ArrayList<>();

        // добавляем соседей для ячейки
        for (Cell potentialNeighbour : potentialNeighbors) {
            // если такая ячейка есть и она открыта для посещения, и не стена
            if (potentialNeighbour != null && potentialNeighbour.isOpen() && !potentialNeighbour.isWall()) {
                neighbors.add(potentialNeighbour);
            }
        }

        return neighbors;
    }

    // возвращает потенциальных соседей ячейки
    private Cell[] getPotentialNeighbours(Cell cell) {
        return new Cell[] {
            getCell(cell.getX() + 1, cell.getY()),
            getCell(cell.getX(), cell.getY() + 1),
            getCell(cell.getX() - 1, cell.getY()),
            getCell(cell.getX(), cell.getY() - 1)
        };
    }

    // возвращает текущую ячейку
    public Cell getCell(int x, int y) {
        // оборачиваем в try catch, чтобы не городить много if else при получении ячейки
        try {
            return cells[x][y];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    // обновление grid сетки, добавление символов для рисования
    @SuppressWarnings("MagicNumber")
    public void updateGrid() {
        // заполняем все клетки пустотой
        for (int x = 0; x < gridDimensionX; x++) {
            for (int y = 0; y < gridDimensionY; y++) {
                grid[x][y] = emptyChar;
            }
        }

        // строим стены через каждые 4 клетки по x и 2 по y
        for (int x = 0; x < gridDimensionX; x++) {
            for (int y = 0; y < gridDimensionY; y++) {
                if (x % 4 == 0 || y % 2 == 0) {
                    grid[x][y] = wallChar;
                }
            }
        }

        for (int x = 0; x < dimensionX; x++) {
            for (int y = 0; y < dimensionY; y++) {
                Cell current = getCell(x, y);
                int gridX = x * 4 + 2;
                int gridY = y * 2 + 1;

                // если текущая клетка на пути
                if (current.isInPath()) {
                    updateCurrentCellInPath(current, gridX, gridY, x, y);
                } else {
                    updateCurrentCellNotInPath(current, gridX, gridY);
                }
            }
        }
    }

    // обновляет клетки на пути
    @SuppressWarnings("MagicNumber")
    private void updateCurrentCellInPath(Cell current, int gridX, int gridY, int x, int y) {
        grid[gridX][gridY] = pathChar;
        if (current.isCellBelowNeighbor()) {
            if (getCell(x, y + 1).isInPath()) {
                grid[gridX][gridY + 1] = pathChar;
            } else {
                grid[gridX][gridY + 1] = cellChar;
            }
            grid[gridX + 1][gridY + 1] = emptyChar;
            grid[gridX - 1][gridY + 1] = emptyChar;
        }
        if (current.isCellRightNeighbor()) {
            if (getCell(x + 1, y).isInPath()) {
                grid[gridX + 2][gridY] = pathChar;
                grid[gridX + 1][gridY] = pathChar;
                grid[gridX + 3][gridY] = pathChar;
            } else {
                grid[gridX + 2][gridY] = cellChar;
                grid[gridX + 1][gridY] = cellChar;
                grid[gridX + 3][gridY] = cellChar;
            }
        }
    }

    // Обновляет клетки не на пути
    @SuppressWarnings("MagicNumber")
    private void updateCurrentCellNotInPath(Cell current, int gridX, int gridY) {
        grid[gridX][gridY] = cellChar;
        if (current.isCellBelowNeighbor()) {
            grid[gridX][gridY + 1] = cellChar;
            grid[gridX + 1][gridY + 1] = emptyChar;
            grid[gridX - 1][gridY + 1] = emptyChar;
        }
        if (current.isCellRightNeighbor()) {
            grid[gridX + 2][gridY] = cellChar;
            grid[gridX + 1][gridY] = cellChar;
            grid[gridX + 3][gridY] = cellChar;
        }
    }

    // подготавливает лабиринт к ортисовке
    public String getMazeOutput() {
        updateGrid();
        StringBuilder output = new StringBuilder();
        for (int y = 0; y < gridDimensionY; y++) {
            for (int x = 0; x < gridDimensionX; x++) {
                output.append(grid[x][y]);
            }
            output.append("\n");
        }
        return output.toString();
    }

    // рисует сетку
    public void draw() {
        LOGGER.info("\n" + getMazeOutput());
    }
}
