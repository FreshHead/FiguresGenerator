package sample.Model;

import javafx.scene.shape.*;

import java.util.Random;

/**
 * Created by Татьяна on 18.01.2017.
 */
public class Square extends Rectangle {

    Square () {
        this(getRandomLength());
    }

    Square(int length) {
        super(length, length);
    }

}
