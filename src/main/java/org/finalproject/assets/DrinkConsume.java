package org.finalproject.assets;

import org.finalproject.output.Responder;

public class DrinkConsume implements ConsumeBehavior{

    Responder responder = null;

    static String[] drinkingResponses = new String[]{
        "Glug glug glug",
        "Gulp",
        "Gulp sip sip"
    };

    static private String getGetRandomDrinkingMessage(){
        return drinkingResponses[(int) Math.round(Math.random()*(drinkingResponses.length-1))];
    }


    public DrinkConsume(Responder responder){
        this.setResponder(responder);
    }

    @Override
    public boolean consume(){
        this.responder.actionRespond("\""+this.getGetRandomDrinkingMessage()+"\"");
        return true;
    }


    @Override
    public void setResponder(Responder responder) {
        this.responder = responder;
    }

}
