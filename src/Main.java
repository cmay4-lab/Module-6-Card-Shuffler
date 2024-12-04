public class Main {

    private static void printDeck(Deck cardDeck) {
        System.out.println();
        System.out.println("Printing deck...");
        System.out.println(cardDeck.toStringDeck());
        System.out.println();
    }

    private static void printNewEmptyDeck() {
        System.out.println();
        System.out.println("An empty deck has just been created...");

        Deck cardDeck = new Deck();

        System.out.println(cardDeck.toStringDeck());
        System.out.println();
    }

    private static void printFill(Deck cardDeck) {
        System.out.println();

        System.out.println("Before filling deck...");
        System.out.println(cardDeck.toStringDeck());

        cardDeck.fill();

        System.out.println("After filling deck...");
        System.out.println(cardDeck.toStringDeck());

        System.out.println();
    }

    private static void printShuffle(Deck cardDeck) {
        System.out.println();
        
        System.out.println("Before shuffling...");
        System.out.println(cardDeck.toStringDeck());

        cardDeck.shuffle();

        System.out.println("After shuffling...");
        System.out.println(cardDeck.toStringDeck());

        System.out.println();
    }

    private static void printCardRank(Card card) {
        System.out.println();
        System.out.println("Printing card rank...");
        System.out.println(card.getRank());
        System.out.println();
    }

    private static void printCardSuit(Card card) {
        System.out.println();
        System.out.println("Printing card suit...");
        System.out.println(card.getSuit());
        System.out.println();
    }

    private static void printCard(Card card) {
        System.out.println();
        System.out.println("Printing card...");
        System.out.println(card.toStringCard());
        System.out.println();
    }

    private static void printNewValuelessCard() {
        System.out.println();
        System.out.println("A valueless card has just been created...");

        Card valuelessCard = new Card();

        System.out.println(valuelessCard.toStringCard());
        System.out.println();
    }

    private static void printNewCard(char cardRank, char cardSuit) {
        System.out.println();
        System.out.println("A card has just been created...");

        Card newCard = new Card(cardRank, cardSuit);

        System.out.println(newCard.toStringCard());
        System.out.println();
    }

    private static void printCardComparison(Card firstCard, Card secondCard) {
        System.out.println();
        
        System.out.println("The first card is displayed...");
        System.out.println(firstCard.toStringCard());

        System.out.println();

        System.out.println("The second card is displayed...");
        System.out.println(secondCard.toStringCard());

        System.out.println();

        Card betterCard = Card.compare(firstCard, secondCard);
        System.out.println("In comparison, the card that is of higher value is displayed...");
        System.out.println(betterCard.toStringCard());

        System.out.println();

        if (betterCard.equals(firstCard)) {
            System.out.println("Therefore, the first card should be placed after it within ascending order...");
        } else {

            System.out.println("Therefore, the second card should be placed after it within ascending order...");

        }

        System.out.println();
    }

    public static void main(String[] args) {
        System.out.print("\n\n");

        printNewEmptyDeck();

        Deck deckOne = new Deck();

        printFill(deckOne);
        printDeck(deckOne);
        printShuffle(deckOne);

        printNewValuelessCard();

        printNewCard('7', 'S');
        Card lonelyCardOne = new Card('7', 'S');

        printCardRank(lonelyCardOne);
        printCardSuit(lonelyCardOne);
        printCard(lonelyCardOne);

        Card lonelyCardTwo = new Card('T', 'S');
        Card loneyCardThree = new Card('T', 'D');

        printCardComparison(lonelyCardOne, lonelyCardTwo);
        printCardComparison(lonelyCardOne, loneyCardThree);
        printCardComparison(lonelyCardTwo, loneyCardThree);
    }
}
