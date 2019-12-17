import java.util.Scanner;

class Prompter {
    private Game game;

    public Prompter(Game game) {
        this.game = game;
    }

    public boolean promptForGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a letter: ");

        // String guessInput = scanner.nextLine();
        // char guess = guessInput.charAt(0);
        // return game.applyGuess(guess);

        if (scanner.hasNextLine()){
            String guessInput = scanner.nextLine();
            char guess = guessInput.charAt(0);
            return game.applyGuess(guess);
        }

        System.out.println("No line");
        return false;
    }

    public void displayProgress() {
        System.out.printf("You have %d remaining tries to solve: %s%n", game.getRemainingTries(),
                game.getCurrentProgress());
    }
}