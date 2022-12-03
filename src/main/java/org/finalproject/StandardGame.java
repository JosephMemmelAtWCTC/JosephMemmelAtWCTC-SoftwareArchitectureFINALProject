package org.finalproject;

import org.finalproject.assets.Asset;
import org.finalproject.input.InputFormatter;
import org.finalproject.output.Responder;
import org.finalproject.rooms.RoomController;

import java.util.Locale;
import java.util.Scanner;

public class StandardGame implements Game{

	Responder responder;
	RoomController roomController;//TODO: Make setable

	//MOVE TO CLASS ETC.
	void obtainContext(String[] words, Asset[] assets){

		byte task = 0;//0 for unset, 1 for eat, make ENUM

		for(String word : words){
			switch(word){
				case "?intro","?instructions","?start","?help" -> this.provideIntroInstructions();
				case "?movement","?move","?mv" -> this.provideMovementInstructions();
				case "?actions" -> this.provideActionSampleInstructions();
				case "?commands","?command","?cmd" -> this.provideCommandList();
				case "i" -> this.displayInventory();

//				MOVEMENT
				case "move","mv" -> task = 6;

//				ASSET COMMANDS, standardised for extra behavior?//TODO: CHECK
				case "d","describe","desc","des" -> task = 10;
				case "eat","consume","drink" -> task = 11;
				case "p","pickup" -> task = 12;

				default -> {
				}
			}

			for (Asset asset : assets) {
				if(asset.getName().toLowerCase(Locale.ROOT).equals(word)){
					if(task == 6){
						roomController.attemptMove(RoomController.DirectionCodes.NORTH);
					}else if(task == 10){
						responder.actionRespond("The "+asset.getName()+" is described as \""+asset.getDescription()+"\"");
					}else if(task == 11){
						if(asset.getQuantity() < 1){
							responder.actionRespond("You have no "+asset.getName()+"'s in your inventory.");
						}else{
							asset.performConsumption();
							responder.actionRespond("You now have "+asset.getQuantity()+" "+asset.getName()+"'s in your inventory.");

							if(asset.getQuantity() <= 0){
								playerAssets.remove(asset);
							}
						}


					}else if(task == 12){

					}

				}
			}
		}

	}


	public StandardGame(Responder responder){
		this.setResponder(responder);
		provideIntroInstructions();
	}

	public byte playUserMove(){

		Scanner scanner = new Scanner(System.in);
		InputFormatter formatter = new InputFormatter();

		String tmpString;//MOVE
		System.out.print("\n> ");
		tmpString = formatter.clearFormatting(scanner.nextLine());
		String[] words = formatter.breakIntoWords(tmpString);

		//Convert to array
//			playerAssets.toArray();

		Asset[] tmpArray = new Asset[playerAssets.size()];
		for (int i = 0; i < playerAssets.size(); i++) {
			tmpArray[i] = playerAssets.get(i);
		}
		obtainContext(words, tmpArray);
		return (byte) ((tmpString.equals("end"))? 15:0);
	}


	private void displayInventory(){//RESPOND LIST? or ... with newlines?
		String tmpStr = "You have "+playerAssets.size()+" items in your inventory\n\n";
		for(Asset asset: playerAssets) {
			tmpStr+=asset.getName()+": x"+asset.getQuantity()+"\n";
		}

		this.responder.simpleOutput(tmpStr);
	}

	public void provideIntroInstructions(){
		responder.helpUserMessage(
				"This is the standard mode of the game, type your player's actions\n" +
				"after the '>'. Respond \"?actions\" to get a list of all current\n" +
				"possible actions, \"?movement\" to see how to move between rooms,\n" +
				"\"?intro\" to get this message again, or \"?commands\" so set a \n" +
				"list of all commands.");
	}

	public void provideMovementInstructions(){//TODO: Make more programmatic with construction
		responder.helpUserMessage(
				"To move to another room, say \"move north/east/south/west\" This \n" +
				"might not always be possible. For quicker movement, use \"mv\" \n" +
				"instead of \"move\" and the first letter of the direction.");
	}

	public void provideActionSampleInstructions(){
		responder.helpUserMessage("THIS STILL NEEDS TO BE IMPLEMENTED");
	}

	public void provideCommandList(){//TODO: Make more programmatic with construction
		responder.helpUserMessage(
				"i: list inventory" +
				"d: describe <item name>"
		);
	}


	public void setResponder(Responder responder){ this.responder = responder; }


}
