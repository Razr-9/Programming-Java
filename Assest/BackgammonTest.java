/**
 * BackgammonTest
 */
public class BackgammonTest {

    public static void main(String[] args) {
        BackgammonBoard testA = new BackgammonBoard();
        BackgammonBoard testB = new BackgammonBoard();
        BackgammonBoard testC = new BackgammonBoard();
        BackgammonBoard testD = new BackgammonBoard();
        BackgammonBoard testE = new BackgammonBoard();
        BackgammonBoard testF = new BackgammonBoard();
        BackgammonBoard testG = new BackgammonBoard();
        BackgammonBoard testH = new BackgammonBoard();

        testA.setPoint(11,5,false);
        testA.move(11,19);

        testB.move(4,3);

        testC.setPoint(18,5,false);
        testC.move(18,24);

        testD.setPoint(0,2,false);
        testD.move(0,1);

        testE.setPoint(5,5,true);
        testE.setPoint(1,1,false);
        testE.move(5,1);

        testF.setPoint(18,5,false);
        testF.setPoint(22,1,true);
        testF.move(18,22);

        testG.setPoint(11,5,false);
        testG.move(11,10);

        testH.setPoint(11,5,false);
        testH.setPoint(12,5,true);
        testH.move(11,12);
        
        if (testA.getPointCount(11)==5 && testA.getPointCount(19)==0
        && testB.getPointCount(4)==0 && testB.getPointCount(3)==0
        && testC.getPointCount(18)==5
        && testD.getPointCount(0)==1 && testD.getPointCount(1)==1 && testD.getPointBlack(1)==false
        && testE.getPointCount(5)==4 && testE.getPointCount(1)==1 && testE.getPointBlack(1)==true && testE.getBarWhiteCount()==1
        && testF.getBarBlackCount()==1
        && testG.getPointCount(11)==5 && testG.getPointCount(10)==0
        && testH.getPointCount(11)==5 && testH.getPointCount(12)==5) {
            System.out.println("CORRECT");
        } else {
            System.out.println("BUG");
            
        }

    }
}