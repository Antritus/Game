package com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.classes.timewarp;

import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.Character;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.CharacterAbility;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.CharacterPassivePerk;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.CharacterType;

import com.gmail.antcoreservices.games.laura.main.GamePanel;
import com.gmail.antcoreservices.games.laura.util.ImageUtility;

import java.awt.image.BufferedImage;

public class TimeWarp extends Character {

    private GamePanel gp;
    public TimeWarp(GamePanel gp) {
        super(CharacterType.KNIGHT,
                new TimeWarpAbility("Is There Somebody?", "Allows player to do something", 0, 50),
                new TimeWarpPassivePerk("Supernatural Death", "Deals +20% more com.gmail.antcoreservices.games.laura.damage to all undead enemies. Undead enemies explode when killed. Deals +10% com.gmail.antcoreservices.games.laura.damage to all enemies."),//30% to undead
                "Killing enemies has never been this fun! (BS!)",
                "Nightly",
                "Knight",
                ImageUtility.setup("/entity/player/timewarp_class/icon.png", false, false, ((((gp.getDefaultSettings().getTileSize()/3)*2)))));
    }

    public TimeWarp(CharacterType characterType, CharacterAbility characterAbility, CharacterPassivePerk characterPassivePerk, String characterDescription, String characterName, String characterClassName, BufferedImage classIcon) {
        super(characterType, characterAbility, characterPassivePerk, characterDescription, characterName, characterClassName, classIcon);
    }

    public void callAbility() {
        if (this.getCharacterAbility().getCooldown() != 0) {
            return;
        }
        this.getCharacterAbility().executeAbility();
        this.getCharacterAbility().resetCooldown();
    }
}
