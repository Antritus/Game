package entity.livingentity.hostile.zombie;

import damage.Damage;
import damage.DamageElement;
import entity.*;
import entity.livingentity.LivingEntity;
import main.GamePanel;

import java.lang.annotation.ElementType;

public class ZombieAI extends LivingEntity {
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
