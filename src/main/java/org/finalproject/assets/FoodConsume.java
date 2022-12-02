package org.finalproject.assets;

import org.finalproject.output.Responder;

public class FoodConsume implements ConsumeBehavior{

    Responder responder = null;

    public FoodConsume(Responder responder) {
        this.setResponder(responder);
    }

    @Override
    public void consume(){
        this.responder.actionRespond("yummy");
    }


    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }

}
