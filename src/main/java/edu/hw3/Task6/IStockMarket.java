package edu.hw3.Task6;

public interface IStockMarket {
    /** Добавить акцию */
    void add(Stock stock);

    /** Удалить акцию */
    void remove(Stock stock);

    /** Самая дорогая акция */
    Stock mostValuableStock();
}
