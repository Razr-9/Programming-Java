/**
 * BackgammonTest
 */
public class BackgammonTest0 {
    
    public static void main(String[] args) {
        
        
        BackgammonBoard c = new BackgammonBoard();
        c.setPoint(0,2,false);
        c.setPoint(5,5,true);
        c.setPoint(7,3,true);
        c.setPoint(11,5,false);
        c.setPoint(12,5,true);
        c.setPoint(16,3,false);
        c.setPoint(18,5,false);        
        c.setPoint(23,2,true);

        
        c.move(23,22);//
        c.move(18,22);//
        
        c.move(0,1);//
        c.move(5,1);//

        c.move(11,19);//

        c.move(18,24);//

        c.move(4,3);//

        c.move(11,10);//

        c.move(11,12);//
       
        if (c.getPointCount(12)==5 && c.getPointCount(10)==0 && c.getPointCount(4)==0 && c.getPointCount(3)==0 && c.getPointCount(18)==4 && c.getPointCount(11)==5 && c.getPointCount(19)==0 && c.getPointCount(18)==4 && c.getPointCount(22)==1 && c.getPointCount(23)==1 && c.getPointBlack(22)==false && c.getPointBlack(23)==true && c.getBarBlackCount()==1 && c.getBarWhiteCount()==1) {
            System.out.println("CORRECT");
            
        }else{
            System.out.println("BUG");
         
        }


    }
}