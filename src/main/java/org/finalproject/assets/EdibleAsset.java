package org.finalproject.assets;

import org.finalproject.output.Responder;

public class EdibleAsset extends Asset{

    public EdibleAsset(String name, String description, Responder responder){
        super(name, description, responder);
        this.setConsumeBehavior(new FoodConsume(responder));
//        this.setPickupBehavior(new PickupStandard(responder));
    }

}
