import java.util.Arrays;

/**
 * find
 */
public class find {

    public int[][] c = { {2,1,2,-1},
        {3,3,4,5},
        {1  ,6, -1 ,-1},
        {2 , 7 , 8 ,-1},
        {0 ,-1 ,-1 ,-1},
        {0 ,-1 ,-1 ,-1},
        {2 , 9 ,10 ,-1},
        {0 ,-1 ,-1 ,-1},
        {0 ,-1 ,-1 ,-1},
        {0 ,-1 ,-1 ,-1},
        {1 ,11 ,-1 ,-1},
        {0 ,-1 ,-1 ,-1}};
    public static void main(String[] args) {
        find O = new find();
        System.out.println(O.findDays(0));
        // O.fdays();
    }

    public int findDays(int i) {
        int numberOfEmployees = c[i][0];
        if (numberOfEmployees == 0) {
            return 0;
        }
        int[] days = new int[numberOfEmployees+1];
        for (int k = 1 ; k <= numberOfEmployees; k++) {
            days[k] = findDays(c[i][k]);
        }
        Arrays.sort(days);
        int reqDays = 0;
        int temp = 1;

        for (int j = numberOfEmployees; j>=1; j--) {
            if (days[j]+temp > reqDays) {
                reqDays = days[j] + temp;
            }
            temp = temp + 1;
            // if (days[j]==0) {
            //     reqDays++;
            // }
        }
        return reqDays;
    }

    // public void fdays() {
    //     int[] days = new int[c.length];
    //     days[0] = 0;
    //     for (int i = 0; i < c.length; i++) {
    //         if (c[i][0]!=0) {
    //             int[] temp = new int[c[i][0]];
    //         }
    //         for (int k = 0; i < c[i][0]; i++) {
    //             temp[k] = c[c[i][k+1]][0];
    //         }

    //         for(int j = 1;j<=c[i][0];j++){
                
                    
                    
    //                 System.out.println("days"+c[i][j]+"="+days[c[i][j]]);
                
                
    //         }
    //     }
    //     // for (int a : days) {
    //     //     System.out.println(a);
    //     // }
    // }
}