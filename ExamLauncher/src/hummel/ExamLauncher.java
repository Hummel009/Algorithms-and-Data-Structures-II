package hummel;

import java.util.*;

public class ExamLauncher {
	public static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		HashMap<String, Runnable> functions = new HashMap<>();
		functions.put("0201", Ex0201::launch);
		functions.put("0202", Ex0202::launch);
		functions.put("0203", Ex0203::launch);
		functions.put("0204", Ex0204::launch);
		functions.put("0205", Ex0205::launch);
		functions.put("0301", Ex0301::launch);
		functions.put("0302", Ex0302::launch);
		functions.put("0401", Ex0401::launch);
		functions.put("0402", Ex0402::launch);
		functions.put("0501", Ex0501::launch);
		functions.put("0502", Ex0502::launch);
		functions.put("0503", Ex0503::launch);
		functions.put("0601", Ex0601::launch);
		functions.put("0602", Ex0602::launch);
		functions.put("0603", Ex0603::launch);
		functions.put("0604", Ex0604::launch);
		functions.put("0605", Ex0605::launch);
		String command = scan.nextLine();
		if (functions.containsKey(command)) {
			functions.get(command).run();
		} else {
			System.out.println("Invalid command");
		}
	}
}