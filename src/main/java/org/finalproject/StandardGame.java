package org.finalproject;

import org.finalproject.assets.Asset;
import org.finalproject.assets.FoodAsset;
import org.finalproject.input.InputFormatter;
import org.finalproject.output.Responder;

import java.util.Scanner;

public class StandardGame implements Game{

	Responder responder;

	//MOVE TO CLASS ETC.
	void obtainContext(String[] words, Asset[] assets){
		System.out.println(assets.length);

		byte task = 0x00b;//0 for unset, 1 for eat, make ENUM

		for(String word : words){
			switch(word){
				case "?intro","?instructions","?start" -> this.provideIntroInstructions();
				case "?movement","?move","?mv" -> this.provideMovementInstructions();
				case "?actions" -> this.provideActionSampleInstructions();

				case "i" -> this.displayInventory();

				case "describe","desc","des" -> task = 1;
				case "eat","consume","drink" -> task = 2;
				default -> {
				}
			}


			for (Asset asset : assets) {
				if(asset.getName().equals(word)){
					if(task == 1){
						responder.actionRespond("The "+asset.getName()+" is described as \""+asset.getDescription()+"\"");
					}else if(task == 2){
						asset.performConsumption();
					}

				}
			}
		}

	}

	private void displayInventory(){//RESPOND LIST? or ... with newlines?
		String tmpStr = "";
		for(Asset asset: playerAssets) {
			tmpStr+=asset.getName()+": "+asset.getQuantity()+"\n";
		}

		this.responder.simpleOutput(tmpStr);
	}

	public StandardGame(Responder responder){
		this.setResponder(responder);

		Asset apple = new FoodAsset("apple", "", responder);
        apple.setDescription("A tasty apple");//TODO: Test


        System.out.println(apple.getDescription());
//        apple.stateDescription();
        apple.performConsumption();

        playerAssets.add(apple);
        playerAssets.add(new FoodAsset("Stale Bread", "A loaf of bread so hard it might hurt you to eat it.", responder));



		provideIntroInstructions();

		Scanner scanner = new Scanner(System.in);
		InputFormatter formatter = new InputFormatter();

		String tmpString;
		do{
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
		}while(!tmpString.equals("end"));

	}

	public void provideIntroInstructions(){
		responder.helpUserMessage(
				"This is the standard mode of the game, type your player's actions\n" +
				"after the '>'. Respond \"?actions\" to get a list of all current\n" +
				"possible actions, or \"?movement\" to see how to move between\n" +
				"rooms or \"?intro\" to get this message again.");
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

	public void setResponder(Responder responder){ this.responder = responder; }


}
