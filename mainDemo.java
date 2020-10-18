import java.util.*;

public class mainDemo {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int x,y;
        int arr[][];
        x = in.nextInt();
        y = in.nextInt();
        arr = new int[x][y];
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                arr[i][j] = in.nextInt();
            }
        }
        MazeSolverOfZerosOnes maze = new MazeSolverOfZerosOnes(arr,x,y);
        maze.solve();
    }
}
