package edu.hw3;

import edu.hw3.Task6.Stock;
import edu.hw3.Task6.StockMarket;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task6Test {
    @Test
    public void testStockMarketReturnsMostExpensiveStock() {
        StockMarket market = new StockMarket();

        Stock sberbank = new Stock("Sberbank", 105);

        market.add(new Stock("Gazprom", 100));
        market.add(sberbank);
        market.add(new Stock("Magnit", 99));

        assertEquals(sberbank.getName(), market.mostValuableStock().getName());
    }

    @Test
    public void testStockMarketReturnsMostExpensiveStockAfterRemove() {
        StockMarket market = new StockMarket();

        Stock sberbank = new Stock("Sberbank", 105);
        Stock gazprom = new Stock("Gazprom", 100);

        market.add(gazprom);
        market.add(sberbank);
        market.add(new Stock("Magnit", 99));

        market.remove(sberbank);

        assertEquals(gazprom.getName(), market.mostValuableStock().getName());
    }
}
