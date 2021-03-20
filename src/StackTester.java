public class StackTester {

    public static void main(String[] args) throws CannotAddException {
        Game testInstance = new Game(); //Initializing test instance of card game

        //Running each component of the game for this test instance
        testInstance.initializeCards();
        testInstance.shuffleCards();
        testInstance.displayDeck();
        testInstance.initializeCardStack();
        testInstance.dealCards();
        testInstance.runGame();
        testInstance.displayWinners();
    }

}