package org.finalproject.assets;

import org.finalproject.output.Responder;

/**
 * The main difference with this 7th version is that a person can interact with
 * the program through a GUI. Run the Startup class to see it in action.
 *
 * Other than using the GUI, this version is the same as version 5.
 */
public abstract class Asset {

    /**
     * Instance variables of interface type Each duck has a reference to
     * something that implements the behaviors via an interface. Hey, isn't this
     * composition the DIP way!!! Only problem is we still have the limitation
     * that all Ducks have fly and quack behaviors, even thought that is not
     * always needed.
     */


    String name;
    String description;

    Responder responder;

    int quantity = 1;

    protected PickupBehavior pickupBehavior;
    protected ConsumeBehavior consumeBehavior;

    public Asset(String name, String description, Responder responder) {
        this.setName(name);
        this.setDescription(description);
        this.setResponder(responder);
    }

//SETTERS
    private void setResponder(Responder responder) { this.responder = responder; }//Has own responder in case of separate display location such as a sidebar

    public void setDescription(String description){ this.description = description; }
    public void setName(String name){ this.name = name; }

    public void performPickup(){ pickupBehavior.pickup(); }
    public void performConsumption(){
        if(consumeBehavior.consume()){
            this.decrementStack();
        }
    }

    public void setPickupBehavior(PickupBehavior pb){ this.pickupBehavior = pb; }
    public void setConsumeBehavior(ConsumeBehavior cb){ this.consumeBehavior = cb; }

//GETTERS

    public String getName(){ return name; }
    public String getDescription(){ return description; }

    public int getQuantity() { return quantity;}

    public void decrementStack(){ this.quantity--; }
}
