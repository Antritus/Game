package entity.livingentity.hostile.zombie;

import entity.*;

public class ZombieAI extends LivingEntity {
	GamePanel gp;
	DamageElement damageElement;
	public ZombieAI(GamePanel gp) {
		ZombieAI(gp, DamageElement.Normal_Element);
	}
	public ZombieAI(GamePanel gp, ElementType element) {
		super(false);
		this.gp = gp;
		this.elementType = element;
	}	
}
