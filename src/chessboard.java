import java.util.Random;


public class chessboard {
    private Random rand=new Random();
    int [][]chess=new int[9][9];
    void chessNew(){
        int x=rand.nextInt(9);
        int y=rand.nextInt(9);
        if(chess[x][y]==9)
            chessNew();
        else {
            chess[x][y] = 9;
            if (x == 0 && y != 0 && y != 8 && chess[x][y] == 9) {
                if (chess[x][y - 1] != 9)
                    chess[x][y - 1]++;
                if (chess[x][y + 1] != 9)
                    chess[x][y + 1]++;
                if (chess[x + 1][y - 1] != 9)
                    chess[x + 1][y - 1]++;
                if (chess[x + 1][y] != 9)
                    chess[x + 1][y]++;
                if (chess[x + 1][y + 1] != 9)
                    chess[x + 1][y + 1]++;
            }
            if (x == 8 && y != 0 && y != 8 && chess[x][y] == 9) {
                if (chess[x][y - 1] != 9)
                    chess[x][y - 1]++;
                if (chess[x][y + 1] != 9)
                    chess[x][y + 1]++;
                if (chess[x - 1][y - 1] != 9)
                    chess[x - 1][y - 1]++;
                if (chess[x - 1][y] != 9)
                    chess[x - 1][y]++;
                if (chess[x - 1][y + 1] != 9)
                    chess[x - 1][y + 1]++;
            }
            if (y == 0 && x != 0 && x != 8 && chess[x][y] == 9) {
                if (chess[x - 1][y] != 9)
                    chess[x - 1][y]++;
                if (chess[x - 1][y + 1] != 9)
                    chess[x - 1][y + 1]++;
                if (chess[x][y + 1] != 9)
                    chess[x][y + 1]++;
                if (chess[x + 1][y + 1] != 9)
                    chess[x + 1][y + 1]++;
                if (chess[x + 1][y] != 9)
                    chess[x + 1][y]++;
            }
            if (y == 8 && x != 0 && x != 8 && chess[x][y] == 9) {
                if (chess[x - 1][y] != 9)
                    chess[x - 1][y]++;
                if (chess[x - 1][y - 1] != 9)
                    chess[x - 1][y - 1]++;
                if (chess[x][y - 1] != 9)
                    chess[x][y - 1]++;
                if (chess[x + 1][y - 1] != 9)
                    chess[x + 1][y - 1]++;
                if (chess[x + 1][y ] != 9)
                    chess[x + 1][y]++;
            }
            else if (x > 0 && x < 8 && y > 0 && y < 8 && chess[x][y] == 9) {
                if (chess[x - 1][y - 1] != 9)
                    chess[x - 1][y - 1]++;
                if (chess[x - 1][y] != 9)
                    chess[x - 1][y]++;
                if (chess[x - 1][y + 1] != 9)
                    chess[x - 1][y + 1]++;
                if (chess[x][y - 1] != 9)
                    chess[x][y - 1]++;
                if (chess[x][y + 1] != 9)
                    chess[x][y + 1]++;
                if (chess[x + 1][y - 1] != 9)
                    chess[x + 1][y - 1]++;
                if (chess[x + 1][y] != 9)
                    chess[x + 1][y]++;
                if (chess[x + 1][y + 1] != 9)
                    chess[x + 1][y + 1]++;
            }
        }
    }
    void chessAround() {
        if (chess[0][0] == 9) {
            if (chess[0][1] != 9)
                chess[0][1]++;
            if (chess[1][0] != 9)
                chess[1][0]++;
            if (chess[1][1] != 9)
                chess[1][1]++;
        }
        if (chess[0][8] == 9) {
            if (chess[0][7] != 9)
                chess[0][7]++;
            if (chess[1][7] != 9)
                chess[1][7]++;
            if (chess[1][8] != 9)
                chess[1][8]++;
        }
        if (chess[8][0] == 9) {
            if (chess[7][0] != 9)
                chess[7][0]++;
            if (chess[7][1] != 9)
                chess[7][1]++;
            if (chess[8][1] != 9)
                chess[8][1]++;
        }
        if (chess[8][8] == 9) {
            if (chess[7][7] != 9)
                chess[7][7]++;
            if (chess[7][8] != 9)
                chess[7][8]++;
            if (chess[8][7] != 9)
                chess[8][7]++;
        }

    }
    chessboard(){
        int count=0;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                chess[i][j]=0;
            }
        }
        for(int i=0;i<9;i++){
            chessNew();
        }
        chessAround();

    }
    public static void main(String args[]){
        chessboard chess1=new chessboard();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(chess1.chess[i][j]==9)
                    System.out.print("x ");
                else
                    System.out.print(chess1.chess[i][j]+" ");
            }
            System.out.println();
        }
    }
}