package org.finalproject.rooms;

import java.util.List;

public interface RoomController {

	List<Room> rooms = null;
	Room currentRoom = null;
	public static enum DirectionCodes {
		NORTH,
		EAST,
		SOUTH,
		WEST;

		private DirectionCodes(){
		}
	}

	void attemptMove(DirectionCodes direction);

	void generateRoom(Room connection, DirectionCodes direction);

}
