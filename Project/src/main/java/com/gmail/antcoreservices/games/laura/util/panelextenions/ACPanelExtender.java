package com.gmail.antcoreservices.games.laura.util.panelextenions;

public class ACPanelExtender {
	private ACObjects objects;
	public void ACPanelExtender() {
		objects = new ACObjects();
	}

	public ACTextField getTextField(int id) {
		if (objects.getPasswordFieldIDs().isEmpty() || !objects.getPasswordFieldIDs().containsKey(id)) {
		}
		return objects.getTextFieldIDs().get(id);
	}

	public ACPasswordField getPasswordField(int id) {
		return objects.getPasswordFieldIDs().get(id);
	}
}
