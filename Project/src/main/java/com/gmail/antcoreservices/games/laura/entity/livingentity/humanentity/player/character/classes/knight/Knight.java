package com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.classes.knight;

import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.Character;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.CharacterType;
import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.util.ImageUtility;

public class Knight extends Character {
	private GamePanel gp;
	public Knight(GamePanel gp) {
		super(CharacterType.KNIGHT,
				new KnightAbility("Is There Somebody?", "Allows player to do something", 0, 50),
				new KnightPassivePerk("Supernatural Death", "Deals +20% more com.gmail.antcoreservices.games.laura.damage to all undead enemies. Undead enemies explode when killed. Deals +10% com.gmail.antcoreservices.games.laura.damage to all enemies."),//30% to undead
				"Killing enemies has never been this fun! (BS!)",
				"Nightly",
				"Knight",
				ImageUtility.setup("/entity/player/knight_class/icon.png", false, false, ((((gp.getDefaultSettings().getTileSize()/3)*2)))));
	}
	public void callAbility() {
		if (this.getCharacterAbility().getCooldown() != 0) {
			return;
		}
		this.getCharacterAbility().executeAbility();
		this.getCharacterAbility().resetCooldown();
	}
}
