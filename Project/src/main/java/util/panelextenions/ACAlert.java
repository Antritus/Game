package util.panelextenions;

public class ACAlert {
	public void debugMessage(String message) {
		message(ACMessageTypes.DEBUG, message);
	}
	public void errorMessage(String message) {
		message(ACMessageTypes.ERROR, message);
	}
	public void warningMessage(String message) {
		message(ACMessageTypes.WARNING, message);
	}
	public void infoMessage(String message) {
		message(ACMessageTypes.INFO, message);
	}
	public void message(ACMessageTypes messageType, String message) {
		if (messageType == ACMessageTypes.DEBUG) {
			System.out.println(ACConsoleColor.BLUE + "[Debug] " + message);
		}
		if (messageType == ACMessageTypes.ERROR) {
			System.out.println(ACConsoleColor.RED + "[Error] " + message);
		}
		if (messageType == ACMessageTypes.WARNING) {
			System.out.println(ACConsoleColor.YELLOW + "[Warning] " + message);
		}
		if (messageType == ACMessageTypes.INFO){
			System.out.println(ACConsoleColor.WHITE + "[Info] " + message);

		}
		System.out.print(ACConsoleColor.RESET);
	}













}
