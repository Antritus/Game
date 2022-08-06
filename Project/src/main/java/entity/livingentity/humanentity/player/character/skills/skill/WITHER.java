package entity.livingentity.humanentity.player.character.skills.skill;

import entity.livingentity.humanentity.player.character.skills.Skill;
import entity.livingentity.humanentity.player.character.skills.SkillType;
import entity.livingentity.humanentity.player.character.skills.SkillName;

public class WITHER extends Skill {
	public WITHER(int skillLevel) {
		super(SkillName.WITHER, SkillType.KILL_SKILL, 4, skillLevel);
	}

	@Override
	public void executeSkill() {
		super.executeSkill();
	}
}
