package edu.hw3.Task6;

import java.util.PriorityQueue;

public class StockMarket implements IStockMarket {
    private final PriorityQueue<Stock> stockQueue;

    public StockMarket() {
        stockQueue = new PriorityQueue<>((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));
    }

    @Override
    public void add(Stock stock) {
        stockQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockQueue.peek();
    }
}
