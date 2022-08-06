package util.panelextenions;

public class ACExtensionsRunner {
	public static void main(String[] args) {
		ACAlert acAlert = new ACAlert();
		acAlert.debugMessage("TEST");
		acAlert.errorMessage("TEST");
		acAlert.infoMessage("TEST");
		acAlert.warningMessage("TEST");
	}
}
