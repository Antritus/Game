package util;

public class TextUtility {
	private String string;
	public TextUtility(String string) {
		this.string = string;

	}
	public String get() {
		return string;
	}
	public void setAsUpperCase() {
		string = string.toUpperCase();
	}
	public void setAsLowerCase() {
		string = string.toLowerCase();
	}
	public void setAsStrictProperCase() {
		StringBuilder builder = new StringBuilder();
		String[] string = this.string.split(" ");
		for (String value : string) {
			int letter = 0;
			for (String character : value.split("")) {
				char charAt = value.charAt(letter);
				if (letter == 0) {
					character = character.replaceFirst(character, character.toUpperCase());
				} else {
					character = character.replaceFirst(character, character.toLowerCase());
				}
				letter++;
				builder.append(character);
			}
			builder.append(" ");
		}
		this.string = builder.toString();
	}
	public void setAsProperCase() {
		StringBuilder builder = new StringBuilder();
		String[] string = this.string.split(" ");
		for (String value : string) {
			int letter = 0;
			for (String character : value.split("")) {
				char charAt = value.charAt(letter);
				if (letter == 0) {
					character = character.replaceFirst(character, character.toUpperCase());
				}
				letter++;
				builder.append(character);
			}
			builder.append(" ");
		}
		this.string = builder.toString();

	}
	public void setAsPascalCase() {
		StringBuilder builder = new StringBuilder();
		String[] string = this.string.split(" ");
		for (String value : string) {
			int letter = 0;
			for (String character : value.split("")) {
				char charAt = value.charAt(letter);
				if (letter == 0) {
					character = character.replaceFirst(character, character.toUpperCase());
				}
				letter++;
				builder.append(character);
			}
		}
		this.string = builder.toString();
	}
	public void setAsStrictPascalCase() {
		StringBuilder builder = new StringBuilder();
		String[] string = this.string.split(" ");
		for (String value : string) {
			int letter = 0;
			for (String character : value.split("")) {
				char charAt = value.charAt(letter);
				if (letter == 0) {
					character = character.replaceFirst(character, character.toUpperCase());
				} else {
					character = character.replaceFirst(character, character.toLowerCase());
				}
				letter++;
				builder.append(character);
			}
		}
		this.string = builder.toString();
	}

	public void translateChatColors(String colorStarter, String string) {

	}

}
