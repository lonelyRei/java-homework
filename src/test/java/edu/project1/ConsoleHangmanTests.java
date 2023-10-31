package edu.project1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleHangmanTests {
    @Test
    public void testHangmanAttempts() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("f");
        hangman.tryGuess("t");

        assertEquals(hangman.getSession().getAttempts(), 2);
    }

    @Test
    public void testHangmanAttemptsDuplicate() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("f");
        hangman.tryGuess("f");

        assertEquals(hangman.getSession().getAttempts(), 1);
    }

    @Test
    public void testHangmanAttemptsIncorrectInput() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("fa");

        assertEquals(hangman.getSession().getAttempts(), 0);
    }

    @Test
    public void testHangmanAttemptsIncorrectInputWithNumbers() {
        ConsoleHangman hangman = new ConsoleHangman();
        hangman.tryGuess("1");

        assertEquals(hangman.getSession().getAttempts(), 0);
    }

    @Test
    public void testHangmanLose() {
        // make incorrect word to make player lose
        ConsoleHangman hangman = new ConsoleHangman("123");
        hangman.tryGuess("a");
        hangman.tryGuess("b");
        hangman.tryGuess("c");
        hangman.tryGuess("d");
        hangman.tryGuess("e");
        hangman.tryGuess("f");
        hangman.tryGuess("g");
        States res = hangman.tryGuess("h").state();

        assertEquals(res, States.DEFEAT);
    }

    @Test
    public void testHangmanInterruptGame() {
        ConsoleHangman hangman = new ConsoleHangman();
        States res = hangman.tryGuess(hangman.getStopWord()).state();

        assertEquals(res, States.GIVE_UP);
    }

    @Test
    public void testHangmanWinGame() {
        String answer = "java";
        ConsoleHangman hangman = new ConsoleHangman(answer);
        hangman.tryGuess("j");
        hangman.tryGuess("a");
        States res = hangman.tryGuess("v").state();

        assertEquals(res, States.WIN);
    }

    @Test
    public void testThatTryGuessRepeatInputReturnsIncorrectState() {
        String answer = "java";
        ConsoleHangman hangman = new ConsoleHangman(answer);
        hangman.tryGuess("j").state();
        States res = hangman.tryGuess("j").state();

        assertEquals(res, States.INCORRECT_INPUT);
    }

    @Test
    public void testThatTryGuessTwiceCorrectInputReturnsSuccessState() {
        String answer = "java";
        ConsoleHangman hangman = new ConsoleHangman(answer);
        hangman.tryGuess("j");
        States res = hangman.tryGuess("a").state();

        assertEquals(res, States.SUCCESS_GUESS);
    }

    @Test
    public void testThatTryGuessCorrectInputReturnsCorrectState() {
        String answer = "java";
        ConsoleHangman hangman = new ConsoleHangman(answer);
        States res = hangman.tryGuess("j").state();

        assertEquals(res, States.SUCCESS_GUESS);
    }

    @Test
    public void testThatTryGuessIncorrectInputReturnsFailGuess() {
        String answer = "java";
        ConsoleHangman hangman = new ConsoleHangman(answer);
        States res = hangman.tryGuess("k").state();

        assertEquals(res, States.FAIL_GUESS);
    }
}
