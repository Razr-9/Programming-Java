/**
 * SelectHand
 * The purpose of this class is to make the best choice to get
 * the greatest score from 4-6 input cards.
 * @author Runze Nie <runzen@student.unimelb.edu.au>
 * @login ID runzen
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
        Cards[] bestCards = new Cards[4]; //an array stores the best choice
        Cards[] selectedCards = new Cards[4]; //an array of selected cards
        String[][] combos = Combinations.combinations(args);
        //all combinations of the given cards
        for (String[] cards : combos) {
            if (cards.length == 4) {
                for (int i = 0 ; i < 4 ; i++) {
                    selectedCards[i] = new Cards(args[i]);
                }
                if (score(selectedCards) > maxScore) {
                    bestCards = selectedCards;
                    maxScore = score(selectedCards);
                    System.out.println(maxScore);
                    System.out.println(fifteens(selectedCards));
                    System.out.println(runs(selectedCards));
                    System.out.println(pairs(selectedCards));
                    System.out.println(flushes(selectedCards));
                    System.out.println(oneForHisNob(selectedCards));
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
    public static double score(Cards[] cards) {
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
    public static int fifteens(Cards[] cards) {
        int count = 0; //count how many 15s in total
        int sum = 0; //sum of the values of the cards
        Cards[][] combs = Combinations.combinations(cards);
        // all the combinations of the given cards
        for (Cards[] comb : combs) {
            if (comb.length > 1) {
                sum = 0;
                for (int i = 0; i < comb.length; i++) {
                    sum = sum + comb[i].getCardPoint();
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
    public static int runs(Cards[] cards) {
        int count = 0; //the number of the runs of 3 elements
        int[] card = {
            cards[0].getFaceValue(),
            cards[1].getFaceValue(),
            cards[2].getFaceValue(),
            cards[3].getFaceValue()
        }; // an array of the face value of the cards (like Jack is 11)
        for (int a : card) {
            System.out.println(a);
        }
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
    public static int pairs(Cards[] cards) {
        int[] count = {0,0,0}; //an array holds the number of equal elements
        char temp = 'X'; //a char for temporary use
        for (int i = 0; i < 3; i++) {
            if (temp != cards[i].getRank()) {
                temp = cards[i].getRank();
                for (int j = i + 1; j < 4; j++) {
                    if (cards[j].getRank() == temp) {
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
    public static double oneForHisNob(Cards[] cards) {
        for (Cards card : cards) {
            if (card.getRank() == 'J') {
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
    public static double flushes(Cards[] cards) {
        char sameSuit = cards[0].getSuit();
        for (Cards card : cards) {
            if (card.getSuit() != sameSuit) {
                return 0;
            }
        }
        return 4.25;
    }

}