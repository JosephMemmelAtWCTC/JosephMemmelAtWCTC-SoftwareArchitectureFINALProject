package org.finalproject.rooms;

import org.finalproject.assets.Asset;

import java.util.ArrayList;
import java.util.List;

public interface Room {

	List<Asset> roomAssets = new ArrayList<Asset>();

	List<Asset> getAssets();

	void populateRoom();

	void searchRoom();

	void setExit(Exit exit);

	Exit[] getExits();

}
