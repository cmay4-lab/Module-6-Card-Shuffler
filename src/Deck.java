import java.util.Random;

public class Deck {
    private static final int STANDARD_DECK_SIZE = 52;       // Hardcoded to be a mutiple of 13
    private Card[] cards;                                   // Array of cards

    /**
     * Creates empty deck.
     * 
     */
    public Deck() {
        cards = new Card[STANDARD_DECK_SIZE];
        for (int i = 0; i < STANDARD_DECK_SIZE; i++) {
            cards[i] = new Card();
        }
    }

    /**
     * Fills the deck, turning it into a standard 52-card deck.
     * 
     */
    public void fill() {

        char[] orderedRanks = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};

        for (int i = 0; i < STANDARD_DECK_SIZE; i += 13) {

            char suit;

            switch (i) {
                case 0  -> suit = 'C';
                case 13 -> suit = 'D';
                case 26 -> suit = 'H';
                case 39 -> suit = 'S';
                default -> suit = '0';
            }

            for (int j = i; j < i + 13; j++) {

                char rank = orderedRanks[j - i];
                cards[j] = new Card(rank, suit);

            }

        }
        

    }

    /**
     * Shuffles the given deck.
     * 
     */
    public void shuffle() {

        Card[] tempCards = new Card[STANDARD_DECK_SIZE];

        for (int i = 0; i < STANDARD_DECK_SIZE; i++) {
            tempCards[i] = cards[i];
        }

        Random randomNumGen = new Random();
        int startingIndex = randomNumGen.nextInt(STANDARD_DECK_SIZE);   // Between 0 and 51 (Indexes)
        int[] completedIndexes = new int[52];
        int randomIndex;

        for (int i = startingIndex; i < STANDARD_DECK_SIZE; i++) {

            randomIndex = randomNumGen.nextInt(STANDARD_DECK_SIZE);

            if (completedIndexes[randomIndex] == randomIndex) {

                int tempRandomIndex;
                int tempCount = 1;
                boolean tempRamdomIndexIsValid = true;

                do { 
                    tempRandomIndex = randomNumGen.nextInt(STANDARD_DECK_SIZE);
                    
                    for (int j = 0; j < STANDARD_DECK_SIZE; j++) {
                        if (completedIndexes[j] == tempRandomIndex) {
                            tempRamdomIndexIsValid = false;
                        }
                    }


                    if (randomIndex < 51) {
                        randomIndex++;
                    } else {
                        randomIndex = 0;
                    }

                    tempCount++;

                } while ((completedIndexes[randomIndex] == randomIndex && tempCount < 52) || !tempRamdomIndexIsValid);

                if (tempCount >= 52) {
                    randomIndex = -1;
                } else {
                    randomIndex = tempRandomIndex;
                }

            }

            if (randomIndex > -1) {

                completedIndexes[randomIndex] = randomIndex;
                cards[randomIndex]  = tempCards[i];

            }

        }

        if (startingIndex != 0) {

            for (int i = 0; i < startingIndex; i++) {

                randomIndex = randomNumGen.nextInt(STANDARD_DECK_SIZE);

                if (completedIndexes[randomIndex] == randomIndex) {

                    int tempRandomIndex;
                    int tempCount = 1;

                    do { 
                        tempRandomIndex = randomNumGen.nextInt(STANDARD_DECK_SIZE);

                        if (randomIndex < 51) {
                            randomIndex++;
                        } else {
                            randomIndex = 0;
                        }

                        tempCount++;

                    } while (completedIndexes[randomIndex] == randomIndex && tempCount < 52);

                    if (tempCount >= 52) {
                        randomIndex = -1;
                    } else {
                        randomIndex = tempRandomIndex;
                    }

                }

                if (randomIndex > -1) {

                    completedIndexes[randomIndex] = randomIndex;
                    cards[randomIndex]  = tempCards[i];

                }

            }

        }
    
    }

    /**
     * Takes the rank and suit of all the cards in the deck, stringify their initals, concating them, 
     * additionally concating square brackets around the string and commas the sides of the elements. 
     * 
     * @return String
     */
    public String toStringDeck() {

        String deckString = "[";
        Card card;

        for (int i = 0; i < (STANDARD_DECK_SIZE - 1); i++) {
            card = cards[i];
            deckString += (card.toStringCard() + ", ");
        }

        card = cards[STANDARD_DECK_SIZE - 1];
        deckString += (card.toStringCard() + "]");

        return deckString;

    }
}
