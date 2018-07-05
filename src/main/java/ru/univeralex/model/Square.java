package ru.univeralex.model;

/**
 * Created by Татьяна on 18.01.2017.
 */
public class Square extends Rectangle {

    public Square() {
        this(getRandomLength());
    }

    Square(int length) {
        super(length, length);
    }

}
