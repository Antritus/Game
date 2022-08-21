package com.gmail.antcoreservices.games.laura.entity.livingentity.hostile.zombie;

import com.gmail.antcoreservices.games.laura.damage.DamageElement;
import com.gmail.antcoreservices.games.laura.entity.EntityType;
import com.gmail.antcoreservices.games.laura.entity.livingentity.LivingEntity;
import com.gmail.antcoreservices.games.laura.entity.livingentity.hostile.HostileEntity;
import com.gmail.antcoreservices.games.laura.main.GamePanel;

public class ZombieAI extends HostileEntity {
	GamePanel gp;
	DamageElement damageElement;

	ZombieAI ai;
	public ZombieAI(GamePanel gp) {
		super(gp);
		this.ai = new ZombieAI(gp, DamageElement.NORMAL_ELEMENT);
	}


	public ZombieAI(GamePanel gp, DamageElement element) {
		super(gp);
		this.gp = gp;
		this.damageElement = element;
		this.ai = this;
	}	
}
