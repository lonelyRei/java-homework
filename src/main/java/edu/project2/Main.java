package edu.project2;

public class Main {
    private Main() {
    }

    @SuppressWarnings("MagicNumber")
    public static void main(String[] args) {
        Maze maze = new Maze(5, 5);
        maze.draw();

        Solver solver = new Solver(maze);
        solver.solve(true);
    }
}
