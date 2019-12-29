class Game{
    public static final int MAX_MISSES = 7;
    private String answer;
    private String hits;
    private String misses;

    public Game(String answer){
        this.answer = answer.toLowerCase();
        hits = "";
        misses = "";
    }

    private char normalizedGuess(char letter){
        if (! Character.isLetter(letter)) throw new IllegalArgumentException("A letter is required");
        letter = Character.toLowerCase(letter);
        if (isInMisses(letter) || isInHits(letter)) throw new IllegalArgumentException(letter + " has already been guessed");
        return letter;
    }

    private boolean isInMisses(char letter){
        return misses.indexOf(letter) != -1;
    }

    private boolean isInHits(char letter){
        return hits.indexOf(letter) != -1;
    }

    private boolean isInAnswer(char letter){
        return answer.indexOf(letter) != -1;
    }

    public String getAnswer(){
        return this.answer;
    }

    public boolean applyGuess(char letter){
        letter = normalizedGuess(letter);
        boolean isHit = isInAnswer(letter);
        if (isHit){
            hits += letter;
        } else {
            misses += letter;
        }
        return isHit;
    }

    public boolean applyGuess(String letters){
        if (letters.length() == 0) throw new IllegalArgumentException("No letter found");
        return applyGuess(letters.charAt(0));

    }
    
    public int getRemainingTries(){
        return MAX_MISSES - misses.length();
    }

    public String getCurrentProgress(){
        String progress = "";
        for (char letter : answer.toCharArray()){
            char display = '-';
            if (hits.indexOf(letter) != -1){
                display = letter;
            }
            progress += display;
        }
        return progress;
    }

    public boolean isWon(){
        return getCurrentProgress().indexOf('-') == -1 ;
    }
}