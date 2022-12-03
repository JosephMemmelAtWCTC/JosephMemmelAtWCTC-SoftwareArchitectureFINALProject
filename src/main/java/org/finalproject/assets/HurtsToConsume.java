package org.finalproject.assets;

import org.finalproject.output.Responder;

public class HurtsToConsume implements ConsumeBehavior{

    Responder responder = null;

    static String[] consumingResponses = new String[]{
        "Ow!"
    };

    static private String getGetRandomConsumingMessage(){
        return consumingResponses[(int) Math.round(Math.random()*(consumingResponses.length-1))];
    }


    public HurtsToConsume(Responder responder) {
        this.setResponder(responder);
    }

    @Override
    public boolean consume(){
        this.responder.actionRespond("\""+this.getGetRandomConsumingMessage()+"\"");
        return true;
    }


    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }

}
