import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
       /*  runEjerciciosPD();*/
        runMaze();
    }

    /*private static void runEjerciciosPD() {
        EjerciciosPD ejerciciosPD = new EjerciciosPD();

        System.out.println("Fibonacci Recursivo");
        long start = System.nanoTime();
        int resultado = ejerciciosPD.getFibonacci(50);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " nanosegundos");

        System.out.println("Fibonacci Recursivo con Caching");
        start = System.nanoTime();
        resultado = ejerciciosPD.getFibonacciPD(50);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " nanosegundos");
    }*/

  private static void runMaze() {
    boolean[][] predefinedMaze = {
        {true, true, true, true},
        {false, true, true, true},
        {true, true, false, false},
        {true, true, true, true},
    };

    Maze maze = new Maze(predefinedMaze);
    Cell start = new Cell(0, 0);
    Cell end = new Cell(3, 3);

    MazeSolver solver = new MazeSolverRecursive();
    List<Cell> path = solver.getPath(maze.getGrid(), start, end);

    System.out.println("Ruta encontrada:");
    for (Cell cell : path) {
        System.out.print("(" + cell.getRow() + "," + cell.getCol() + ") ");
    }
    System.out.println();

    System.out.println("Laberinto con ruta:");
    maze.printMaze(path);
}

}
/* */