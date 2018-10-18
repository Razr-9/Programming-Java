/**
 * BackBoard
 */
public class BackgammonBoard {

    private int[] points = new int[24];
    private int blacksOnBar = 0;
    private int whitesOnBar = 0;
  
    public BackgammonBoard() {
        
    }
    // get the Count of a point
    public int getPointCount(int point){
        if (validNumber(point)) {
            return Math.abs(points[point]);
        }else{
            return 0;
        }
    }
    //get the Color on a point (true means Black)
    public boolean getPointBlack(int point){
        if (validNumber(point)) {
            return points[point] <= 0;
        } else {
            return true;
        }
    }
    //set a point
    public void setPoint(int point, int count, boolean black){
        if (validNumber(point)) {
            points[point] = count * (black ? -1 : 1);
        } 
    }
    //get the Black count on bar
    public int getBarBlackCount(){
        return blacksOnBar;
    }
    //get the White count on bar
    public int getBarWhiteCount() {
        return whitesOnBar;
    }
    //move method
    public void move(int from, int to) {
        if (validNumber(from) && validNumber(to)) {
            int distance = Math.abs(to - from);
            if (distance <= 6 && distance >= 1) {
                int fromCount = getPointCount(from);
                int toCount = getPointCount(to);
                boolean fromBlack = getPointBlack(from);
                boolean toBlack = getPointBlack(to);
                if (fromCount >= 1) {
                    if ((!fromBlack && to > from) || (fromBlack && to < from)) {
                        if (fromBlack == toBlack || toCount == 0) {
                            setPoint(to, toCount+1, fromBlack);
                            setPoint(from, fromCount-1, fromBlack);
                        } else if (toCount == 1) { 
                            setPoint(from, fromCount-1, fromBlack);
                            setPoint(to, toCount, fromBlack);
                            if (toBlack) {
                                blacksOnBar++;
                            }else{
                                whitesOnBar++;
                            }
                        }
                    }
                }
                
            }
        }
    }

    //check the point number (if between 0 to 23)
    private boolean validNumber(int point) {
        if(point >= 0 && point <= 23){
            return true;
        }else{
            return false;
        }
    }
}