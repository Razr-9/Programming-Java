/**
 * SelectHand
 * The purpose of this class is to make the best choice to get
 * the greatest score from 4-6 input cards.
 * 
 * This is the main file in this project. This program is designed 
 * to choose 4 cards to keep from 4-6 cards in the game of Cribbage. 
 * In the game, every player will get 4-6 cards depending on the 
 * number of players. Then the player needs to keep 4 cards and 
 * discards the rest. The dealer will pick an extra card as start 
 * card and each player needs to combine their cards in hand with 
 * the start card to get points. There are five ways to get points 
 * in total. This program is going to help the player to choose 
 * cards for the greatest points.
 */

import java.util.Arrays;

public class SelectHand {
    /**
     * The main method of this program to calculate and compare
     * the max score for every situation with 4 cards getting with 
     * the combination method in class Combinations. Set 4 cards
     * as selected cards and compare its score with other situations.
     * And then print out the best cards in commmand line arguments.
     * 
     * @param args an array of input cards
     */
    public static void main(String[] args) {
        double maxScore = 0; //holds the max score
        String[] bestCards = new String[4]; //an array stores the best choice
        String[][] combos = Combinations.combinations(args);
        //all combinations of the given cards
        for (String[] cards : combos) {
            if (cards.length == 4) {
                if (score(cards) > maxScore) {
                    bestCards = cards;
                    maxScore = score(cards);
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(bestCards[i] + " ");
        }
        System.out.println(bestCards[3]);
    }

    /**
     * a method to calculate the score in total for the giving cards
     * 
     * @param cards an array of the selected cards
     * @return a double as the total score
     */
    public static double score(String[] cards) {
        return fifteens(cards) + runs(cards) + pairs(cards) + flushes(cards) + oneForHisNob(cards);
    }

    /**
     * The method to compute the points which the cards can get in
     * the 15s part by traversing all elements in combinations which
     * have more than one element. Once the values of the cards can 
     * combine 15 the player can get 2 points.
     * 
     * @param cards an array of the selected cards
     * @return an int as the score in this part
     */
    public static int fifteens(String[] cards) {
        int count = 0; //count how many 15s in total
        int sum = 0; //sum of the values of the cards
        String[][] combs = Combinations.combinations(cards);
        // all the combinations of the given cards
        for (String[] comb : combs) {
            if (comb.length > 1) {
                sum = 0;
                for (int i = 0; i < comb.length; i++) {
                    sum = sum + cardPoint(comb[i]);
                }
                if (sum == 15) {
                    count++;
                }
            }
        }
        return count*2;
    }

    /**
     * This method computes the score in the runs part. 1 point is 
     * scored for each card in a run of 3 or more consecutive cards.
     * Sort method is used here to sort the array. Then consider 
     * every situation which can combine a run.
     * 
     * @param cards an array of the selected card
     * @return an int as the score in this part
     */
    public static int runs(String[] cards) {
        int count = 0; //the number of the runs of 3 elements
        int[] card = {
            faceValue(cards[0].charAt(0)),
            faceValue(cards[1].charAt(0)),
            faceValue(cards[2].charAt(0)),
            faceValue(cards[3].charAt(0))
        }; // an array of the face value of the cards (like Jack is 11)
        Arrays.sort(card);
        // the situation that 4 cards are in order
        if (card[0] + 1 == card[1] 
        && card[1] + 1 == card[2] 
        && card[2] + 1 == card[3]) {
            return 4;
        } else {
            // the situation that 3 cards are in order
            for (int i = 1; i < 4; i++) {
                if (card[i] == card[0] + 1) {
                    for (int j = i + 1; j < 4; j++) {
                        if(card[j] == card[i] + 1) {
                            count++;
                        }
                    }
                }
            }
            if (card[1] + 1 == card[2] && card[2] + 1 == card[3]) {
                count++;
            }
            return count*3;
        }
    }

    /**
     * This method compute the score in pairs part. 2 points are
     * for each pair and 3 same cards get 6 points while 4 same 
     * cards get 12 points. Calculate this by recording the number 
     * of equal elements while traversing the array.
     * 
     * @param cards an array of the selected card
     * @return an int as the score in this part
     */
    public static int pairs(String[] cards) {
        int[] count = {0,0,0}; //an array holds the number of equal elements
        char temp = 'X'; //a char for temporary use
        for (int i = 0; i < 3; i++) {
            if (temp != cards[i].charAt(0)) {
                temp = cards[i].charAt(0);
                for (int j = i + 1; j < 4; j++) {
                    if (cards[j].charAt(0) == temp) {
                        count[i]++;
                    }
                }
            }
            
        }
        // 2 same cards get 2 points, 3 gets 6 points, 4 gets 12 points
        return count[0] * (count[0]+1) + count[1] * (count[1]+1) + count[2] * (count[2]+1);
    }

    /**
     * This method calculates the score in one for his nob part.
     * If the hand contains the jack of the same suit as the start 
     * card, 1 point is scored. When a Jack is in the hand, there 
     * are one quarter of the situation that it has the same suit 
     * with the start card. So here this situation gets 0.25 points 
     * on average.
     * 
     * @param cards an array of the selected cards
     * @return a double as the score in this part
     */
    public static double oneForHisNob(String[] cards) {
        for (String card : cards) {
            if (card.charAt(0) == 'J') {
                return 0.25;
            }
        }
        return 0;
    }

    /**
     * This method computes the score in flushes part. The player 
     * will get 4 points if the cards in the hand are all in same
     * suit. If the start card is also with the same suit, 1 extra 
     * point will be scored. This will happen in one quarter of the 
     * situation, so here 4.25 points are scored on average.
     * 
     * @param cards an array of the selected cards
     * @return a double as the score in this part
     */
    public static double flushes(String[] cards) {
        if(cards[0].charAt(1) == cards[1].charAt(1) 
        && cards[1].charAt(1) == cards[2].charAt(1) 
        && cards[2].charAt(1) == cards[3].charAt(1)) {
            return 4.25;
        }else{
            return 0;
        }
    }

    /**
     * This method returns the value of a card in the game. Ace means 
     * 1. Jack, King, Queen and Ten mean 10. Values of other cards 
     * are same with their face value.
     * 
     * @param card one String of the card
     * @return an int of the value of the card in the game
     */
    public static int cardPoint(String card) {
        switch (card.charAt(0)) {
            case 'A' :
                return 1;
            case 'J' :
                return 10;
            case 'K' :
                return 10;
            case 'Q' :
                return 10;
            case 'T' :
                return 10;
            default :
                return Character.getNumericValue(card.charAt(0));
        }
    }

    /**
     * This method returns the real value of the card where Jack 
     * means 11, Queen means 12 and so on.
     * 
     * @param card a char of the first character of a card
     * @return an int of the real value of a card
     */
    public static int faceValue(char card) {
        switch (card) {
            case 'A' :
                return 1;
            case 'J' :
                return 11;
            case 'K' :
                return 13;
            case 'Q' :
                return 12;
            case 'T' :
                return 10;
            default :
                return Character.getNumericValue(card);
        }
    }
}