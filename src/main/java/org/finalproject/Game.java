package org.finalproject;

import org.finalproject.assets.Asset;
import org.finalproject.output.Responder;
import org.finalproject.rooms.Room;

import java.util.ArrayList;
import java.util.List;

public interface Game {

	Responder responder =  null;

	List<Asset> playerAssets = new ArrayList<Asset>();

	List<Room> rooms = null;

	Room currentRoom = null;

	void provideIntroInstructions();
	void provideMovementInstructions();
	void provideActionSampleInstructions();

	byte playUserMove();

	default void addAssetToInventory(Asset asset){ playerAssets.add(asset); }


}
