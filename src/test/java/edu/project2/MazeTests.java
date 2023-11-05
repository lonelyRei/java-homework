package edu.project2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    // todo: Дописать тесты
}
