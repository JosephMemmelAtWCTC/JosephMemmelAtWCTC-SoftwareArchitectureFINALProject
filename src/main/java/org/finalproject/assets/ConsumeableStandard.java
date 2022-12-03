package org.finalproject.assets;

import org.finalproject.output.Responder;

public class ConsumeableStandard implements ConsumeBehavior {

    @Override
    public boolean consume() {
        System.out.println("!!!!!!!!!!!!!!!!!!! NEEDS TO BE IMPLEMENTED");
        return false;
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
