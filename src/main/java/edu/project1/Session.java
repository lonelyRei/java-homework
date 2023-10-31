package edu.project1;

import java.util.Random;
import org.jetbrains.annotations.NotNull;

class Session {
    private final String answer;
    private String userAnswer;
    private int attempts;

    private static final int MAX_ATTEMPTS = 5;

    Session() {
        String[] words = new Vocabulary().getWords();
        this.answer = words[new Random().nextInt(words.length)];

        this.prepareGame();
    }

    Session(String answer) {
        this.answer = answer;
        this.prepareGame();

    }

    private void prepareGame() {
        this.userAnswer = "*".repeat(this.answer.length());
        this.attempts = 0;
    }

    public int getAttempts() {
        return this.attempts;
    }

    public @NotNull String getSessionInfo() {
        return String.format("The word: %s", userAnswer);
    }

    public @NotNull GuessResult guess(@NotNull Character guess) {
        if (answer.contains(guess.toString())) {
            return this.checkSymbolSuccess(guess);
        } else {
            return this.checkSymbolFailed();
        }
    }

    private @NotNull GuessResult checkSymbolFailed() {
        this.attempts += 1;
        if (attempts > MAX_ATTEMPTS) {
            return new GuessResult.Defeat();
        } else {
            return new GuessResult.FailedGuess(this.attempts, MAX_ATTEMPTS);
        }
    }

    private @NotNull GuessResult checkSymbolSuccess(@NotNull Character guess) {
        StringBuilder updatedAnswer = new StringBuilder(userAnswer);
        for (int i = 0; i < this.answer.length(); i++) {
            if (this.answer.charAt(i) == guess) {
                updatedAnswer.setCharAt(i, guess);
            }
        }

        this.userAnswer = updatedAnswer.toString();
        return this.checkUserVictory();
    }

    private @NotNull GuessResult checkUserVictory() {
        if (this.userAnswer.contains("*")) {
            return new GuessResult.SuccessfulGuess();
        } else {
            return new GuessResult.Win();
        }
    }

    public @NotNull GuessResult giveUp() {
        return new GuessResult.GameInterrupt();
    }
}
