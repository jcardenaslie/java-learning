import java.util.Scanner;

class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        boolean isHit = false;
        boolean isAcceptable = false;

        System.out.println("Enter a letter: ");
        if (scanner.hasNextLine()) {
            do {
                String guessInput = scanner.nextLine();
                try {
                    isHit = game.applyGuess(guessInput);
                    isAcceptable = true;
                } catch (IllegalArgumentException e) {
                    System.out.printf("%s. Please try again. %n", e.getMessage());
                }

                return isHit;
            } while (!isAcceptable);
        }
        System.out.println("No line");
        return false;
    }

    public void displayProgress() {
        System.out.printf("You have %d remaining tries to solve: %s%n", game.getRemainingTries(),
                game.getCurrentProgress());
    }

	public void displayOutcome() {
        String answers = game.getAnswer();
        String outcome =  game.isWon() ? "You Won!" : "You Lose! \nThe answer was: " + answers;
        System.out.println(outcome);
	}
}