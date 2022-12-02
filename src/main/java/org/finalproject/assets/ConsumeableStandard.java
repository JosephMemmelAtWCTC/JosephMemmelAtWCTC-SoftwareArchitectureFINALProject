package org.finalproject.assets;

import org.finalproject.output.Responder;

public class ConsumeableStandard implements ConsumeBehavior {

    @Override
    public void consume() {

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
