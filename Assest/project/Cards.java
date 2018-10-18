/**
 * Cards
 * This class is to represent cards.
 * @author Runze Nie <runzen@student.unimelb.edu.au>
 * @login ID runzen
 * 
 * This is a class to represent cards using the input string to 
 * construct. Use private variables to hold the rank, suit, value 
 * and point. Use public method to get these variables.
 */
public class Cards {

    private char rank; 
    private char suit;
    private int faceValue; //the real value of a card
    private int cardPoint; //the value in the game

    /**
     * The construct method of the class. Set these 4 variables with 
     * the input string.
     * @param card input string
     */
    public Cards(String card) {
        this.rank = card.charAt(0);
        this.suit = card.charAt(1);
        switch (card.charAt(0))
            case 'A':
                this.faceValue = 1;
                this.cardPoint = 1;
            case 'J':
                this.cardPoint = 10;
                this.faceValue = 11;
            case 'Q':
                this.cardPoint = 10;
                this.faceValue = 12;
            case 'K':
                this.cardPoint = 10;
                this.faceValue = 13;
            case 'T':
                this.cardPoint = 10;
                this.faceValue = 10;
            default:
                this.cardPoint = Character.getNumericValue(this.rank);
                this.faceValue = Character.getNumericValue(this.rank);
        }
    }

    /**
     * get method of rank
     * @return the rank of the card
     */
    public char getRank() {
        return rank;
    }

    /**
     * get method of suit
     * @return the suit of the card
     */
    public char getSuit() {
        return suit;
    }

    /**
     * toString method of the class, return a String as the requirement
     * of the game.
     */
    public String toString() {
        return String.valueOf(rank) + String.valueOf(suit);
    }

    /**
     * get method of faceValue
     * @return the real value of a card
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * get method of cardPoint
     * @return the point of a card in the game
     */
    public int getCardPoint() {
        return cardPoint;
    }

}