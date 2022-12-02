package org.finalproject;

import org.finalproject.assets.Asset;
import org.finalproject.assets.FoodAsset;
import org.finalproject.input.InputDecoraterRemovePunctuation;
import org.finalproject.input.InputFormatter;
import org.finalproject.output.ConsoleResponder;
import org.finalproject.output.Responder;
import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.LowerCaseConversion;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Holds the hand to be checked and determines your hand
 * @author 42Null
 */
public class Main{//MOVE TO GAME



    public static void main(String[] args) throws IOException {
        Game game = new StandardGame(ConsoleResponder.getInstance());




//        items.add(new UnConsumeableAsset());
//        Duck mallard = new MallardDuck();
//        mallard.display();
//        mallard.performQuack();
//        mallard.performFly();
//
//        Duck model = new ModelDuck();
//        model.display();
//        model.performFly();
//        model.setFlyBehavior(new FlyRocketPowered());
//        model.performFly();
    }

}