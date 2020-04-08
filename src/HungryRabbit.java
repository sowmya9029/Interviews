import java.util.*;

public class HungryRabbit {

    // driver code
    public static void main(String[] args) {
        int [][] garden = {
                {5, 3, 8, 6, 3},
                {0, 0, 7, 0, 4},
                {4, 6, 3, 4, 9},
                {3, 1, 0, 5, 8} };
        System.out.println(new HungryRabbit().getCarrots(garden));
    }


    // main function exposed to clients to get carrots eaten by rabbit.
    public int getCarrots(int[][] garden) {
        int row= findStartPosition(garden).getX_coord();
        int col= findStartPosition(garden).getY_coord();

        return carrotsEatten(garden,row,col,0);
    }

    // recursive fuction that travels atmost O(N*M) times to get max carrots
    private int carrotsEatten(int[][] garden, int row, int col, int carrotsCount)
    {

        List<Position> positionsToCheck = new ArrayList<>();

        if(isValidPosition(garden,row-1,col))// top
            positionsToCheck.add(new Position(row-1,col,garden[row-1][col]));

        if(isValidPosition(garden,row,col-1))// left
            positionsToCheck.add(new Position(row,col-1,garden[row][col-1]));

        if(isValidPosition(garden,row+1,col))// bottom
            positionsToCheck.add(new Position(row+1,col,garden[row+1][col]));

        if(isValidPosition(garden,row,col+1))// right
            positionsToCheck.add(new Position(row,col+1,garden[row][col+1]));

        Position max = getNextPossiblePosition(positionsToCheck);


        carrotsCount = garden[row][col];
        garden[row][col] = 0;

        if(max != null) {
            carrotsCount += carrotsEatten(garden, max.getX_coord(), max.getY_coord(), carrotsCount);
        }

        return carrotsCount;

    }

    // helper to get next position for the rabbit to go to
    private Position getNextPossiblePosition(List<Position> positionsToCheck) {
        if(positionsToCheck.size() == 0)
            return null;

        return positionsToCheck.stream().max(Comparator.comparingInt(Position::getValue)).get();
    }


    // helper to check if position is valid.
    private boolean isValidPosition(int [][]garden, int row, int col) {
        return ((row >=0 && row < garden.length && col >= 0 && col < garden[0].length)
                && (garden[row][col] != 0));
    }



    // helper to find the starting position.
    private Position findStartPosition(int [][] garden) {
        int row_len = garden.length;
        int col_len =  garden[0].length;

        int midRow = row_len/2;
        int midCol = col_len/2;
        Position position = new Position(row_len/2,col_len/2, garden[row_len/2][col_len/2]);


        if(row_len%2 != 0 && col_len%2 != 0) {
            return position;
        }

        // only for even row and col check the 4 positions to get the max
        if(row_len%2==0 && col_len%2==0)
        {
            List<Position> positions = new ArrayList<>();
            positions.add(new Position(midRow-1,midCol,garden[midRow-1][midCol]));
            positions.add(new Position(midRow,midCol,garden[midRow][midCol]));
            positions.add(new Position(midRow,midCol-1,garden[midRow][midCol-1]));
            positions.add(new Position(midRow-1,midCol-1,garden[midRow-1][midCol-1]));

            return getNextPossiblePosition(positions);
        }

        else if(col_len%2==0)
        {
            if (garden[midRow][midCol]<garden[midRow][midCol-1]) {
                position.y_coord = position.y_coord - 1;
                position.value = garden[midRow][midCol-1];
            }
        }
        else if(row_len%2==0)
        {
            if (garden[midRow][midCol]<garden[midRow-1][midCol]) {
                position.x_coord = position.x_coord - 1;
                position.value = garden[midRow-1][midCol];
            }
        }
        return position;
    }


    // data class to compare value from row and col
    class Position {
        private int x_coord;
        private int y_coord;
        private int value;

        public Position(int x_coord, int y_coord, int value) {
            this.x_coord = x_coord;
            this.y_coord = y_coord;
            this.value = value;
        }

        public int getX_coord() {
            return x_coord;
        }


        public int getY_coord() {
            return y_coord;
        }

        public int getValue() {
            return value;
        }
    }

}
