public class Card {
    private char rank;    // The card's rank from ace to king
    private char suit;    // The card's suit (clubs, diamonds, hearts, spades)

    public Card() {
        rank = '';
        suit = '';
    }

    public Card(char cardRank, char cardSuit) {
        rank = cardRank;
        suit = cardSuit;
    }

    public char getRank() {
        return rank;
    }

    public char getSuit() {
        return suit;
    }

    private static int getIntegerAttributeValues(char cardField) {
        int value = 0;

        switch (cardField) {
            /* Suits */
            case 'C' -> value = 1;      // Clubs
            case 'D' -> value = 2;      // Diamonds
            case 'H' -> value = 3;      // Hearts
            case 'S' -> value = 4;      // Spades
            /* Ranks */
            case 'A' -> value = 1;      // 1
            case '2' -> value = 2;      // 2
            case '3' -> value = 3;      // 3
            case '4' -> value = 4;      // 4
            case '5' -> value = 5;      // 5
            case '6' -> value = 6;      // 6
            case '7' -> value = 7;      // 7
            case '8' -> value = 8;      // 8
            case '9' -> value = 9;      // 9
            case 'T' -> value = 10;     // 10
            case 'J' -> value = 11;     // Jack
            case 'Q' -> value = 12;     // Queen
            case 'K' -> value = 13;     // King
        }

        return value;
    }

    public static Card compare(Card firstCard, Card secondCard) {
        Card betterCard;                    // The card that is more "valuable"
        int[] rankValues = new int[2];      // The values used to determine the "correct" order of the ranks (as determined by me)
        int[] suitValues = new int[2];      // The values used to determine the "correct" order of the suits (as determined by me)

        /* There are 13 ranks (Ace, 2, 3, ..., 10, Jack, Queen, and King) */
        rankValues[0] = getIntegerAttributeValues(firstCard.rank);
        rankValues[1] = getIntegerAttributeValues(secondCard.rank);

        /* There are 4 suits (Clubs, Hearts, Spades, and Diamonds) */
        suitValues[0] = getIntegerAttributeValues(firstCard.suit, 'S');
        suitValues[1] = getIntegerAttributeValues(secondCard.suit, 'S');      

        boolean firstCardIsValid = rankValues[0] != 0 && suitValues[0] != 0;
        boolean secondCardIsValid = suitValues[0] != 0 && suitValues[1] != 0;

        /* Validates the two cards in the first level of scope. Compares the value of the suits in the second scope. And if the suits are equal, 
        compares the value of the ranks in the final scope. */
        if (!secondCardIsValid) {

            betterCard = firstCard;

        } else if (!firstCardIsValid) {
            
            betterCard = secondCard;

        } else {

            if (suitValues[0] > suitValues[1]) {

                betterCard = firstCard;

            } else if (suitValues[0] < suitValues[1]) {

                betterCard = secondCard;

            } else {

                if (rankValues[0] >= rankValues[1]) {

                    betterCard = firstCard;

                } else {

                    betterCard = secondCard;

                }

            }

            return betterCard;
        }

    }

    public String toString() {
        char[] cardCharacters = {rank, suit};
        String cardString = new String(cardCharacters);
        return cardString;
    }




}