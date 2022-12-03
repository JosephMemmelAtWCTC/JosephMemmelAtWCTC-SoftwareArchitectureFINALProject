package org.finalproject;

import org.finalproject.assets.Asset;
import org.finalproject.assets.DrinkAsset;
import org.finalproject.assets.EdibleAsset;
import org.finalproject.assets.FoodAsset;
import org.finalproject.output.ConsoleResponder;
import org.finalproject.output.Responder;

import java.io.IOException;

/**
 * Holds the hand to be checked and determines your hand
 * @author 42Null
 */
public class Main{//MOVE TO GAME



    static Asset edibleFactory(String name, String type, String description, int quantity, Responder responder) {
        return switch(type){
//           case "food" -> new EdibleAsset();
            case "food" -> new FoodAsset(name, description, responder);
            case "drink" -> new DrinkAsset(name, description, responder);
            default -> {throw new IllegalArgumentException("A type from the list must be used in the factory in order to create the correct kind of Asset!");
                }
        };

    }

    public static void main(String[] args) throws IOException {
        Game game = new StandardGame(ConsoleResponder.getInstance());

//        Asset apple = new EdibleAsset("apple", "", ConsoleResponder.getInstance());
//        apple.setDescription("A tasty apple");//TODO: Test
//        game.addAssetToInventory(apple);

        game.addAssetToInventory(edibleFactory("StaleBread", "food", "A loaf of bread so hard it might hurt you to eat it.", 2, ConsoleResponder.getInstance()));

        game.addAssetToInventory(edibleFactory("BottledWater", "drink","A simple 8 fluid ounce plastic disposable bottle willed with water.", 3, ConsoleResponder.getInstance()));

        while(game.playUserMove() != 15){
        }

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