package com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.skills.skill;

import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.skills.Skill;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.skills.SkillType;
import com.gmail.antcoreservices.games.laura.entity.livingentity.humanentity.player.character.skills.SkillName;

public class WITHER extends Skill {
	public WITHER(int skillLevel) {
		super(SkillName.WITHER, SkillType.KILL_SKILL, 4, skillLevel);
	}

	@Override
	public void executeSkill() {
		super.executeSkill();
	}
}
