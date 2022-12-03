package org.finalproject.assets;

import org.finalproject.output.Responder;

public class FoodConsume implements ConsumeBehavior{

    Responder responder = null;

    static String[] eatingResponses = new String[]{
        "Crunch crunch gulp",
        "Chew munch chew gulp",
        "Crunch gulp smack smack"
    };

    static private String getGetRandomEatingMessage(){
        return eatingResponses[(int) Math.round(Math.random()*(eatingResponses.length-1))];
    }


    public FoodConsume(Responder responder) {
        this.setResponder(responder);
    }

    @Override
    public boolean consume(){
        this.responder.actionRespond("\""+this.getGetRandomEatingMessage()+"\"");
        return true;
    }


    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }

}
