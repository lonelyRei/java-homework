package edu.hw2.Task2;

public class Square extends Rectangle {

    public Square(int value) {
        super(value, value);
    }

    @Override
    public Rectangle setWidth(int value) {
        return new Square(value);
    }

    @Override
    public Rectangle setHeight(int value) {
        return new Square(value);
    }
}
