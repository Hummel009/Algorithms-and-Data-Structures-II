package hummel;

import java.util.*;

import hummel.ADS01.Room.*;

public class ADS01 {
	public static Scanner input = new Scanner(System.in);

	public static boolean compareRooms(Room room1, Room room2) {
		return room1.direct.equals(room2.direct) && room1.color.equals(room2.color) && room1.glowing.equals(room2.glowing) && room1.environment.equals(room2.environment) && room1.roomType.roomName.equals(room2.roomType.roomName) && room1.windowType.windowName.equals(room2.windowType.windowName);
	}

	public static void drawAsAMatrix(int left1, int right, int left2) {
		int lLeft1 = left1 / 5;
		int lRight = right / 5;
		int lLeft2 = left2 / 5;
		String[][] matr = new String[26][26];
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				matr[i][j] = " ";
			}
		}
		int x = 12;
		int y = 12;
		while (lLeft1 > 0) {
			matr[x][y] = "G";
			x--;
			lLeft1--;
		}
		while (lRight > 0) {
			matr[x][y] = "G";
			y--;
			lRight--;
		}
		while (lLeft2 > 0) {
			matr[x][y] = "G";
			x++;
			lLeft2--;
		}
		matr[x][y] = "L";
		matr[12][12] = "S";
		System.out.println("|=======================================|");
		System.out.println("|===============  ROUTE  ===============|");
		System.out.println("|=======================================|");
		System.out.println();
		System.out.println("==========================");
		for (int i = 0; i < 26; i++) {
			for (int j = 0; j < 26; j++) {
				System.out.print(matr[i][j]);
			}
			System.out.println();
		}
		System.out.println("==========================");
	}

	public static void main(String[] args) {
		System.out.println("─────────────────────────────────────────────────────────────────────────");
		System.out.println("─██████──────────██████─██████████████─██████████████████─██████████████─");
		System.out.println("─██░░██████████████░░██─██░░░░░░░░░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─");
		System.out.println("─██░░░░░░░░░░░░░░░░░░██─██░░██████░░██─████████████░░░░██─██░░██████████─");
		System.out.println("─██░░██████░░██████░░██─██░░██──██░░██─────────████░░████─██░░██─────────");
		System.out.println("─██░░██──██░░██──██░░██─██░░██████░░██───────████░░████───██░░██████████─");
		System.out.println("─██░░██──██░░██──██░░██─██░░░░░░░░░░██─────████░░████─────██░░░░░░░░░░██─");
		System.out.println("─██░░██──██████──██░░██─██░░██████░░██───████░░████───────██░░██████████─");
		System.out.println("─██░░██──────────██░░██─██░░██──██░░██─████░░████─────────██░░██─────────");
		System.out.println("─██░░██──────────██░░██─██░░██──██░░██─██░░░░████████████─██░░██████████─");
		System.out.println("─██░░██──────────██░░██─██░░██──██░░██─██░░░░░░░░░░░░░░██─██░░░░░░░░░░██─");
		System.out.println("─██████──────────██████─██████──██████─██████████████████─██████████████─");
		System.out.println("─────────────────────────────────────────────────────────────────────────");

		Floors floor;
		do {
			System.out.println("Enter the color of the floor: ");
			String color = input.nextLine();
			floor = Floors.forName(color);
		} while (floor == null);

		System.out.println("Enter the color of the room (green, black, grey): ");
		String color = input.nextLine();

		System.out.println("Enter the glowing of the room (true/false): ");
		String glowing = input.nextLine();

		System.out.println("Enter the glowing type of the room (true/false): ");
		String direct = input.nextLine();

		System.out.println("Enter the med environment of the room (true/false): ");
		String environment = input.nextLine();

		RoomType type;
		WindowType wtype;

		do {
			System.out.println("Enter the room type of the room: ");
			String r = input.nextLine();
			type = RoomType.forName(r);
		} while (type == null);

		do {
			System.out.println("Enter the window type of the room: ");
			String w = input.nextLine();
			wtype = WindowType.forName(w);
		} while (wtype == null);

		Room rm = new Room(color, glowing, direct, environment, type, wtype);

		Room blackRoom = new Room("grey", "true", "false", "false", RoomType.ROOM, WindowType.SMALL);
		Room lab = new Room("grey", "true", "true", "true", RoomType.ROOM, WindowType.BIG);
		Room prison = new Room("green", "false", "false", "false", RoomType.ROOM, WindowType.NONE);

		System.out.println("|=======================================|");
		System.out.println("|==============  GO BACK  ==============|");
		System.out.println("|=======================================|");
		System.out.println();
		switch (floor) {
		case ONE:
			if (compareRooms(rm, blackRoom)) {
				System.out.println("You are on the first floor.\n" + "Turn left and go " + 12 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 50 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 18 + " steps.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 48 + " steps.\n" + "Then use lift." + "Turn to the angle of " + 45 + " degrees to left and go " + 50 + " metres.\n");
			} else {
				Random rand = new Random();
				int left1 = rand.nextInt(20) + 20;
				int left2 = rand.nextInt(20) + 20;
				int right = rand.nextInt(20) + 20;

				System.out.println("You are on the second floor.\n" + "Turn left and go " + left1 + " steps.\n" + "Then turn right and go " + right + " steps.\n" + "Turn left and go " + left2 + " steps.\n" + "Then use lift.\n");
				drawAsAMatrix(left1, right, left2);
			}
			break;
		case TWO:
			if (compareRooms(rm, lab)) {
				System.out.println("You are on the second floor.\n" + "Turn to the angle of " + 45 + " degrees to right and go forward.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go forward.\n" + "Then use lift.\n" + "You are on the first floor.\n" + "Turn left and go " + 12 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 50 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 18 + " steps.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 48 + " steps.\n" + "Then use lift." + "Turn to the angle of " + 45 + " degrees to left and go " + 50 + " metres.\n");
			} else {
				Random rand = new Random();
				int left1 = rand.nextInt(20) + 20;
				int left2 = rand.nextInt(20) + 20;
				int right = rand.nextInt(20) + 20;

				System.out.println("You are on the second floor.\n" + "Turn left and go " + left1 + " steps.\n" + "Then turn right and go " + right + " steps.\n" + "Turn left and go " + left2 + " steps.\n" + "Then use lift.\n");
				drawAsAMatrix(left1, right, left2);
			}
			break;
		case THREE:
			if (compareRooms(rm, prison)) {
				System.out.println("You are on the third floor.\n" + "Turn left and go " + 8 + " steps.\n" + "Then use lift.\n" + "You are on the second floor.\n" + "Turn to the angle of " + 45 + " degrees to right and go forward.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go forward.\n" + "Then use lift.\n" + "You are on the first floor.\n" + "Turn left and go " + 12 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 50 + " steps.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 18 + " steps.\n" + "Turn to the angle of " + 90 + " degrees to right and go forward.\n" + "Turn to the angle of " + 45 + " degrees to right and go " + 48 + " steps.\n" + "Then use lift.\n" + "Turn to the angle of " + 45 + " degrees to left and go " + 50 + " metres.\n");
			} else {
				Random rand = new Random();
				int left1 = rand.nextInt(20) + 20;
				int left2 = rand.nextInt(20) + 20;
				int right = rand.nextInt(20) + 20;

				System.out.println("You are on the second floor.\n" + "Turn left and go " + left1 + " steps.\n" + "Then turn right and go " + right + " steps.\n" + "Turn left and go " + left2 + " steps.\n" + "Then use lift.\n");
				drawAsAMatrix(left1, right, left2);
			}
		}
	}

	public enum Floors {
		ONE("black"), TWO("grey"), THREE("green");

		public final String eName;

		Floors(String fName) {
			eName = fName;
		}

		public static Floors forName(String search) {
			for (Floors color : Floors.values()) {
				if (search.equals(color.eName)) {
					return color;
				}
			}
			return null;
		}
	}

	public static class Room {
		public String color;
		public String glowing;
		public String direct;
		public String environment;
		public RoomType roomType;
		public WindowType windowType;

		public Room(String fColor, String fGlowing, String fDirect, String fEnvironment, RoomType fRoomType, WindowType fWindowType) {
			color = fColor;
			glowing = fGlowing;
			direct = fDirect;
			environment = fEnvironment;
			roomType = fRoomType;
			windowType = fWindowType;
		}

		public enum RoomType {
			OTSEK("otsek"), ROOM("room"), CORRIDOR("corridor");

			public final String roomName;

			RoomType(String fName) {
				roomName = fName;
			}

			public static RoomType forName(String search) {
				for (RoomType r : RoomType.values()) {
					if (search.equals(r.roomName)) {
						return r;
					}
				}
				return null;
			}
		}

		public enum WindowType {
			BIG("big"), SMALL("small"), NONE("none");

			public final String windowName;

			WindowType(String fName) {
				windowName = fName;
			}

			public static WindowType forName(String search) {
				for (WindowType r : WindowType.values()) {
					if (search.equals(r.windowName)) {
						return r;
					}
				}
				return null;
			}
		}
	}

}