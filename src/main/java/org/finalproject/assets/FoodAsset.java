package org.finalproject.assets;

import org.finalproject.output.Responder;

public class FoodAsset extends Asset{

    public FoodAsset(String name, String description, Responder responder){
        super(name, description, responder);
        this.setConsumeBehavior(new FoodConsume(responder));
//        this.setPickupBehavior(new PickupStandard(responder));
    }

}
