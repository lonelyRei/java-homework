package edu.project2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeTests {
    @Test
    public void testTheSimplestMaze() {
        Maze maze = new Maze(1, 1);
        String actual = maze.getMazeOutput();

        String expected = """
            XXXXX
            X   X
            XXXXX""" + "\n";

        assertEquals(expected, actual);
    }

    @Test
    public void testTheSimplestMazeSolving() {
        Maze maze = new Maze(1, 1);
        Solver solver = new Solver(maze);
        solver.solve(false);
        String actual = solver.getSolutionString();

        String expected = """
            XXXXX
            X * X
            XXXXX""" + "\n";

        assertEquals(expected, actual);
    }

    @Test
    public void testMazeSolutionThrowsNullPointerException() {
        Maze maze = new Maze(5, 5);

        Solver solver = new Solver(maze);
        assertThrows(NullPointerException.class, () -> solver.solve(0, 0, 5, 5, false));
    }

    @Test
    public void testMazeThrowsIllegalArguments() {
        assertThrows(IllegalArgumentException.class, () -> new Maze(-5, 5));
    }

    @Test
    public void testMazeSolutionSuccessWithSimpleMaze() {
        Maze maze = new Maze(1, 1);

        Solver solver = new Solver(maze);
        assertTrue(solver.solve(0, 0, 0, 0, false));
    }

    @Test
    public void testMazeSolutionSuccess() {
        Cell[][] cells = new Cell[3][3];

        cells[0] = new Cell[] {new Cell(0, 0, false), new Cell(0, 1, false), new Cell(0, 2, false)};
        cells[1] = new Cell[] {new Cell(1, 0, true), new Cell(1, 1, true), new Cell(1, 2, true)};
        cells[2] = new Cell[] {new Cell(2, 0, true), new Cell(2, 1, true), new Cell(2, 2, true)};

        Maze maze = new Maze(3, 3, cells);

        Solver solver = new Solver(maze);

        assertTrue(solver.solve(0, 0, 0, 2, false));
    }

    @Test
    public void testMazeSolutionFailure() {
        Cell[][] cells = new Cell[3][3];

        cells[0] = new Cell[] {new Cell(0, 0, false), new Cell(0, 1, false), new Cell(0, 2, false)};
        cells[1] = new Cell[] {new Cell(1, 0, true), new Cell(1, 1, true), new Cell(1, 2, true)};
        cells[2] = new Cell[] {new Cell(2, 0, true), new Cell(2, 1, true), new Cell(2, 2, true)};

        Maze maze = new Maze(3, 3, cells);

        Solver solver = new Solver(maze);

        assertFalse(solver.solve(0, 0, 1, 2, false));
    }

    @Test
    public void testMazeSolutionSuccessWithDifficultWay() {
        Cell[][] cells = new Cell[3][3];

        cells[0] = new Cell[] {new Cell(0, 0, false), new Cell(0, 1, false), new Cell(0, 2, false)};
        cells[1] = new Cell[] {new Cell(1, 0, false), new Cell(1, 1, true), new Cell(1, 2, true)};
        cells[2] = new Cell[] {new Cell(2, 0, false), new Cell(2, 1, false), new Cell(2, 2, false)};

        Maze maze = new Maze(3, 3, cells);

        Solver solver = new Solver(maze);

        assertTrue(solver.solve(0, 0, 2, 2, false));
    }

    @Test
    public void testMazeSolutionSuccessWithStartAndFinishNotInCommonCells() {
        Cell[][] cells = new Cell[3][3];

        cells[0] = new Cell[] {new Cell(0, 0, false), new Cell(0, 1, false), new Cell(0, 2, false)};
        cells[1] = new Cell[] {new Cell(1, 0, false), new Cell(1, 1, true), new Cell(1, 2, true)};
        cells[2] = new Cell[] {new Cell(2, 0, false), new Cell(2, 1, false), new Cell(2, 2, false)};

        Maze maze = new Maze(3, 3, cells);

        Solver solver = new Solver(maze);

        assertTrue(solver.solve(1, 0, 2, 1, false));
    }
}
