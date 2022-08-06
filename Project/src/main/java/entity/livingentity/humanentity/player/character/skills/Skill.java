package entity.livingentity.humanentity.player.character.skills;

public class Skill {
	private final SkillName skillName;
	private final SkillType skillType;
	private final boolean isKillSkill;
	private final int maxLevel;
	private int level;

	// todo: skills

	public Skill(SkillName skillName, SkillType skillType, int maxLevel, int level) {
		this.skillName = skillName;
		this.skillType = skillType;
		this.isKillSkill = this.getSkillType() == SkillType.KILL_SKILL;
		this.maxLevel = maxLevel;
		this.level = level;
	}
	public SkillName getSkillName() {
		return skillName;
	}
	public SkillType getSkillType() {
		return skillType;
	}
	public boolean isKillSkill() {
		return isKillSkill;
	}
	public int getMaxLevel() {
		return maxLevel;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void executeSkill(){}
}
