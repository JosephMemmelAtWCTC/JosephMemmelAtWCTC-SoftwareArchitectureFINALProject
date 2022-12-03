package org.finalproject.assets;

import org.finalproject.output.Responder;

public class DrinkAsset extends EdibleAsset{

    public DrinkAsset(String name, String description, Responder responder){
        super(name, description, responder);
        this.setConsumeBehavior(new DrinkConsume(responder));
//        this.setPickupBehavior(new PickupStandard(responder));
    }

}
