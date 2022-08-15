package com.gmail.antcoreservices.games.laura.main;

import com.gmail.antcoreservices.games.laura.entity.livingentity.hostile.slime.HOS_Slime;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.npc.NPC_OldMan;

public class AssetSetter {

	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}
	public void setObject() {
		/*
		gp.obj[0] = new OBJ_Key();
		gp.obj[0].setWorldX(2 * gp.tileSize);
		gp.obj[0].setWorldY(1* gp.tileSize);
	*/
	}
	boolean returnContinue = true;
	public void setNPC() {
		if (returnContinue) {
			return;
		}
		gp.npc[0] = new NPC_OldMan(gp);
		gp.npc[0].setX(3*gp.getDefaultSettings().getTileSize());
		gp.npc[0].setY(3*gp.getDefaultSettings().getTileSize());
	}

	public void setHostile() {
		if (returnContinue) {
			return;
		}
		gp.hostile[0] = new HOS_Slime(gp);
		gp.hostile[0].setX(2*gp.getDefaultSettings().getTileSize());
		gp.hostile[0].setY(3*gp.getDefaultSettings().getTileSize());
	}
}
