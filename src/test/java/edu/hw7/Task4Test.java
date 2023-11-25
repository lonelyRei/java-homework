package edu.hw7;

import org.junit.Test;
import java.util.concurrent.ExecutionException;
import static edu.hw7.Task4.calculatePiMultiThreaded;
import static edu.hw7.Task4SingleThread.calculatePiSingleThreaded;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task4Test {
    @Test
    public void testCalculatePiSingleThreaded() {
        double pi = calculatePiSingleThreaded(10000000);
        assertEquals(3.1415, pi, 0.001);
    }

    @Test
    public void testCalculatePiMultiThreaded() throws InterruptedException, ExecutionException {
        double pi = calculatePiMultiThreaded(10000000, 4);
        assertEquals(3.1415, pi, 0.001);
    }

    /*
    * Теоретически:
    * Среднее ускорение многопоточного решения по сравнению с однопоточным составляет:
    * Для 2 потоков: ускорение примерно в 1,5 раза.
    * Для 4 потоков: ускорение примерно в 2,8 раза.
    * Для 8 потоков: ускорение примерно в 4,5 раза.
    *
    * Уровень точности моделирования:
    * 10 миллионов симуляций: примерно 0,0001.
    * 100 миллионов симуляций: примерно 0,00001.
    * 1 миллиард симуляций: примерно 0,000001.
    * */
}
