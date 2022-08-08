package entity.livingentity.humanentity.player.character;

import java.awt.image.BufferedImage;

public class Character {
	private final CharacterType characterType;
	private final CharacterAbility characterAbility;
	private final CharacterPassivePerk characterPassivePerk;
	private final String characterDescription;
	private final String characterClassName;
	private final String characterName;
	private final BufferedImage classIcon;

	// todo: characters


	public Character(CharacterType characterType,
					 CharacterAbility characterAbility,
					 CharacterPassivePerk characterPassivePerk,
					 String characterDescription,
					 String characterName,
					 String characterClassName,
					 BufferedImage classIcon) {
		this.characterType = characterType;
		this.characterAbility = characterAbility;
		this.characterPassivePerk = characterPassivePerk;
		this.characterDescription = characterDescription;
		this.characterName = characterName;
		this.characterClassName = characterClassName;
		this.classIcon = classIcon;
	}

	public CharacterType getCharacterType() {
		return characterType;
	}
	public CharacterPassivePerk getCharacterPassivePerk() {
		return characterPassivePerk;
	}
	public CharacterAbility getCharacterAbility() {
		return characterAbility;
	}
	public String getCharacterDescription(){
		return characterDescription;
	}
	public String getCharacterName() {
		return characterName;
	}
	public String getCharacterClassName() {
		return characterClassName;
	}
	public BufferedImage getClassIcon() {
		return classIcon;
	}
}
