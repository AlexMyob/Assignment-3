import java.util.*;

public class Game {
    //Declaring ArrayList for initial cards and appropriate LinkedStacks
    private ArrayList<Integer> cardsDeck = new ArrayList<Integer>();
    private LinkedStack<Integer> cardStack = new LinkedStack<>();
    private LinkedStack<Integer> p1cards = new LinkedStack<>();
    private LinkedStack<Integer> p2cards = new LinkedStack<>();
    private LinkedStack<Integer> p1cardsWon = new LinkedStack<>();
    private LinkedStack<Integer> p2cardsWon = new LinkedStack<>();

    public void initializeCards() {
        // Deck of cards is filled with integers 0 through 51
        for (int i = 0; i < 52; i++) {
            this.cardsDeck.add(i);
        }
    }

    public void shuffleCards() {
        // Shuffle the ArrayList holding the initial deck of cards
        Collections.shuffle(this.cardsDeck);
    }

    public void displayDeck() {
        // Simple method to display all items in deck of cards
        System.out.println("Original shuffled deck of cards: ");
        for (int card : this.cardsDeck) {
            System.out.print(card + " ");
        }
    }

    public void initializeCardStack() throws CannotAddException {
        // The inital ArrayList was used to facilitate shuffling, now we use the Stack ADT to implement the rest of our game
        for (int i = 0; i < 52; i++) {
            this.cardStack.push(this.cardsDeck.get(i));
        }
    }

    public void dealCards() throws CannotAddException {
        // Deal cards to each player
        System.out.println("\n\nDealing 26 cards to player 1 and player 2: ");
        for (int i = 0; i < 52; i++) {
            if (i % 2 == 0) {
                this.p1cards.push(this.cardStack.pop());
            } else {
                this.p2cards.push(this.cardStack.pop());
            }
        }
        System.out.println("\nPlayer 1 now has " + this.p1cards.length() + " cards.");
        System.out.println("Player 1 cards are: ");
        System.out.println(this.p1cards);
        System.out.println();


        System.out.println("Player 2 now has " + this.p2cards.length() + " cards.");
        System.out.println("Player 2 cards are: ");
        System.out.println(this.p2cards);
        System.out.println();
    }

    public void runGame() throws CannotAddException {
        //Method to loop through all 26 rounds of the game and keep track of cards won
        for (int i = 0; i < 26; i++) {
            @SuppressWarnings("resource")
            Scanner scan = new Scanner(System.in);

            //Variables to hold values of each players card for each round
            int p1card;
            int p2card;

            //Set value of each card equal to the cards at the top of each player's stack
            p1card = this.p1cards.pop();
            p2card = this.p2cards.pop();

            //Display drawn cards
            System.out.println("Player 1 has drawn " + p1card);
            System.out.println("Player 2 has drawn " + p2card);

            //Display winners and push the winning card to the proper stack
            if (p1card > p2card) {
                System.out.println("Player 1 has won round " + (i + 1));
                System.out.println("Press Enter to continue to the next round");
                this.p1cardsWon.push(p1card);
            } else {
                System.out.println("Player 2 has won round " + (i + 1));
                System.out.println("Press Enter to continue to the next round");
                this.p2cardsWon.push(p2card);
            }

            //Wait for user to press Enter to proceed to the next round
            scan.nextLine();
        }
    }

    public void displayWinners() {
        //Method to display total cards won and calculate/display a final winner

        //Display cards won
        System.out.println("Player 1 has won " + this.p1cardsWon.length() + " rounds");
        System.out.println("Player 2 has won " + this.p2cardsWon.length() + " rounds");
        System.out.println();

        //Display winning player
        if (this.p1cardsWon.length() == this.p2cardsWon.length()) {
            System.out.println("This was a draw!");
        } else if (this.p1cardsWon.length() > this.p2cardsWon.length()) {
            System.out.println("Player 1 has won the game!");
        } else {
            System.out.println("Player 2 has won the game!");
        }
    }
}