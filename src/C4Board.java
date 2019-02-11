import java.util.ArrayList;

public class C4Board extends Board {

    public static final int ROWS = 6;
    public static final int COLS = 7;

    public C4Board(){
        super(ROWS, COLS);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                set(r, c, "-");
            }
        }
    }

    @Override
    public void placePiece(String loc, String player) {
        for (int x=ROWS-1; x >= 0; x--){
            Comparable check = theBoard[x][Integer.parseInt(loc)-1];
            if (check.equals("-")){
                theBoard[x][Integer.parseInt(loc)-1] = player;
                break;
            }
        }
    }

    @Override
    public void retractPiece(String loc) {
        for (int x=0; x<ROWS; x++){
            Comparable check = theBoard[x][Integer.parseInt(loc)-1];
            if (!check.equals("-")){
                theBoard[x][Integer.parseInt(loc)-1] = "-";
                break;
            }
        }
    }

    public ArrayList<String> getEmptyLocs() {
        ArrayList<String> empty = new ArrayList<>();
        for(int r = 0; r < theBoard.length; r++) {
            for(int c = 0; c < theBoard[0].length; c++) {
                if(!theBoard[r][c].equals("X") && !theBoard[r][c].equals("O"))
                    empty.add((String) theBoard[r][c]);
            }
        }
        return empty;
    }

    @Override
    public boolean isWinner(String player) {
        for(int i=0; i< getRows(); i++){
          if(streakInRow(i, player, 6) || streakInCol(i,player,7))
              return true;
        }
        for(int colNum = 0; colNum <= 3; colNum++){
            for(int rowNum = 0; rowNum <= 2; rowNum++){
                if(streakInNorthEastDiag(rowNum,colNum,player,4)){
                    return true;
                }
            }
        }
        for(int colNum = 0; colNum <= 3; colNum++){
            for(int rowNum = 5; rowNum >= 3; rowNum--){
                if(streakInSouthEastDiag(6,0,player,4)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public String toString() {
        return "1234567\n" + super.toString();
    }
}
