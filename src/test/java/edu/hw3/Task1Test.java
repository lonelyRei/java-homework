package edu.hw3;

import org.junit.jupiter.api.Test;
import static edu.hw3.Task1.atbash;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task1Test {
    @Test
    public void testAtbashEncryptMethodSmallString() {
        String actual = atbash("Hello world!");
        String expected = "Svool dliow!";

        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashEncryptMethodWithHugeString() {
        String actual = atbash(
            "Any fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler");
        String expected =
            "Zmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        assertEquals(expected, actual);
    }

    @Test
    public void testAtbashEncryptMethodWithRussianWord() {
        String actual = atbash(
            "Яny fool can write code that a computer can understand. Good programmers write code that humans can understand. ― Martin Fowler");
        String expected =
            "Яmb ullo xzm dirgv xlwv gszg z xlnkfgvi xzm fmwvihgzmw. Tllw kiltiznnvih dirgv xlwv gszg sfnzmh xzm fmwvihgzmw. ― Nzigrm Uldovi";

        assertEquals(expected, actual);
    }
}
