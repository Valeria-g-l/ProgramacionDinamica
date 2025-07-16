import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeSolverRecursive implements MazeSolver {
    @Override
    public List<Cell> getPath(boolean[][] grid, Cell start, Cell end) {
        List<Cell> path = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        if (grid == null || grid.length == 0)
            return path;
        if (findPath(grid, start, end, path, visited))
            return path;
        return new ArrayList<>();
    }

    private boolean findPath(boolean[][] grid, Cell current, Cell end, List<Cell> path, Set<String> visited) {
        int row = current.getRow();
        int col = current.getCol();

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || !grid[row][col]) {
            return false;
        }

        String key = row + "," + col;
        if (visited.contains(key)) {
            return false;
        }
        visited.add(key);

        path.add(current);

        if (row == end.getRow() && col == end.getCol()) {
            return true;
        }

       
        if (findPath(grid, new Cell(row - 1, col), end, path, visited)) return true;
       
        if (findPath(grid, new Cell(row + 1, col), end, path, visited)) return true;
        
        if (findPath(grid, new Cell(row, col - 1), end, path, visited)) return true;
        
        if (findPath(grid, new Cell(row, col + 1), end, path, visited)) return true;

        path.remove(path.size() - 1);
        return false;
    }
}