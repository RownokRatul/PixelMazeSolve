import java.util.*;

public class MazeSolverOfZerosOnes {
    private ArrayList<ArrayList<Integer>> grid;
    private int x,y;
    private int taken[][];
    private ArrayDeque<makePair> track;

    public MazeSolverOfZerosOnes(int arr[][],int x,int y) {
        track = new ArrayDeque<>();
        this.x = x;
        this.y = y;
        grid = new ArrayList<ArrayList<Integer>>();
        taken = new int[x][y];
        for(int i=0;i<x;i++) {
            ArrayList<Integer> tempArray = new ArrayList<>();
            for(int j=0;j<y;j++) {
                tempArray.add(arr[i][j]);
                taken[i][j] = 0;
            }
            grid.add(tempArray);
        }
        
    }

    public void solve() {
        for(int i=0;i<y;i++) {
            if(grid.get(0).get(i) == 1) {
                track.push(new makePair(0,i));
                recurrentsSolve(0,i);
            }
        }
        for(int i=1;i<x;i++) {
            if(grid.get(i).get(0) == 1) {
                track.push(new makePair(i,0));
                recurrentsSolve(i,0);
            }
        }
    }

    private boolean recurrentsSolve(int posX,int posY) {
        taken[posX][posY] = 1;

        //System.out.println("debug");

        if(posX == x-1 || posY == y-1){
            print();
            return true;
        }

        if((posX > 0) && (grid.get(posX-1).get(posY) == 1) && (taken[posX-1][posY] == 0)) {
            track.push(new makePair(posX-1,posY));
            boolean result = recurrentsSolve(posX-1,posY);
            if(!result) {
                track.pop();
            }
            else {
                return true;
            }
        }
        if((posY > 0 ) && (grid.get(posX).get(posY-1) == 1) && (taken[posX][posY-1] == 0)) {
            track.push(new makePair(posX,posY-1));
            boolean result = recurrentsSolve(posX,posY-1);
            if(!result) {
                track.pop();
            }
            else {
                return true;
            }
        }
        if((posX < x-1) && (grid.get(posX+1).get(posY) == 1) && (taken[posX+1][posY] == 0)) {
            track.push(new makePair(posX+1,posY));
            boolean result = recurrentsSolve(posX+1,posY);
            if(!result) {
                track.pop();
            }
            else {
                return true;
            }
        }
        if((posY <y-1) && (grid.get(posX).get(posY+1) == 1) && (taken[posX][posY+1] == 0)) {
            track.push(new makePair(posX,posY+1));
            boolean result = recurrentsSolve(posX,posY+1);
            if(!result) {
                track.pop();
            }
            else {
                return true;
            }
        }
        return false;
    }

    private void print() {
        char ara[][] = new char[x][y];
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                ara[i][j] =(char) (grid.get(i).get(j) + '0');
            }
        }
        while(!track.isEmpty()) {
            makePair temp = track.pop();
            ara[temp.first()][temp.second()] = 'X';
        }
        for(int i=0;i<x;i++) {
            for(int j=0;j<y;j++) {
                System.out.print(ara[i][j] + " ");
            }
            System.out.println();
        }
    }
}
