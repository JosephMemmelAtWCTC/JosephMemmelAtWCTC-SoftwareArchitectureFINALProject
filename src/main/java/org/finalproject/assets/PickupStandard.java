package org.finalproject.assets;

import org.finalproject.output.Responder;

public class PickupStandard implements PickupBehavior {

    @Override
    public void pickup() {
        System.out.println("I'm flying!");
    }

    @Override
    public String toString() {
        return "Fly With Wings";
    }

    @Override
    public void setResponder(Responder responder) {
//        this.responder = responder;
    }
}
