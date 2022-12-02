package org.finalproject.assets;

import org.finalproject.output.Responder;

public class ModelDuck extends Asset {

    public ModelDuck(String name, String description, Responder responder) {
        super(name, description, responder);
        pickupBehavior = new PickupStandard();
        consumeBehavior = new ConsumeableStandard();
    }

    @Override
    public String toString() {
        return "Model Duck";
    }
}
