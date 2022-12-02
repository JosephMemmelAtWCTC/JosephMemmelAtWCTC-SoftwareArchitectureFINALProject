package org.finalproject.rooms;

import org.finalproject.assets.Asset;

import java.util.ArrayList;
import java.util.List;

public interface Room {

	List<Asset> assets = new ArrayList<Asset>();

	public List<Asset> getAssets();


}
