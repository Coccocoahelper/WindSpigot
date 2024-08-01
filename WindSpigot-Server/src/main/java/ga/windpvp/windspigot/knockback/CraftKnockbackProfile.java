package ga.windpvp.windspigot.knockback;

import dev.cobblesword.nachospigot.knockback.KnockbackProfile;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CraftKnockbackProfile implements KnockbackProfile {

	private String name;
	private final String saveProfilePath;

	private double horizontal = 0.4D;
	private double vertical = 0.4D;
	private double verticalMin = -1.0D;
	private double verticalMax = 0.4D;
	private double extraHorizontal = 0.5D;
	private double extraVertical = 0.1D;
	private double frictionHorizontal = 2.0D;
	private double frictionVertical = 2.0D;
	private double rangeFactor = 0.025D;
	private double maxRangeReduction = 1.2D;
	private double startRangeReduction = 3.0D;
	private double minRange = 0.12D;

	private boolean stopSprint = true;

	private double rodHorizontal = 0.4D;
	private double rodVertical = 0.4D;
	private double arrowHorizontal = 0.4D;
	private double arrowVertical = 0.4D;
	private double pearlHorizontal = 0.4D;
	private double pearlVertical = 0.4D;
	private double snowballHorizontal = 0.4D;
	private double snowballVertical = 0.4D;
	private double eggHorizontal = 0.4D;
	private double eggVertical = 0.4D;
	
	private double wTapHorizontal = 0.5;
	private double wTapVertical = 0.1;
	
	private double addHorizontal = 0;
	private double addVertical = 0;

	public CraftKnockbackProfile(String name) {
		this.name = name;
		this.saveProfilePath = "knockback.profiles." + this.name;
	}

	@Override
	public void save() {
		save(false);
	}
	
	private void set(String savePath, Object value) {
		KnockbackConfig.set(saveProfilePath + savePath, value);
	}

	@Override
	public void save(boolean projectiles) {

		set(".stop-sprint", this.stopSprint);
		set(".friction-horizontal", this.frictionHorizontal);
		set(".friction-vertical", this.frictionVertical);
		set(".horizontal", this.horizontal);
		set(".range-factor", this.rangeFactor);
		set(".max-range-reduction", this.maxRangeReduction);
		set(".start-range-reduction", this.startRangeReduction);
		set(".min-range", this.minRange);
		set(".vertical", this.vertical);
		set(".vertical-max", this.verticalMax);
		set(".vertical-min", this.verticalMin);
		set(".extra-horizontal", this.extraHorizontal);
		set(".extra-vertical", this.extraVertical);
		
		set(".wtap-extra-horizontal", this.wTapHorizontal);
		set(".wtap-extra-vertical", this.wTapVertical);
		
		set(".add-horizontal", this.addHorizontal);
		set(".add-vertical", this.addVertical);
		
		if (projectiles) {
			set(".projectiles.rod.horizontal", this.rodHorizontal);
			set(".projectiles.rod.vertical", this.rodVertical);
			set(".projectiles.arrow.horizontal", this.arrowHorizontal);
			set(".projectiles.arrow.vertical", this.arrowVertical);
			set(".projectiles.pearl.horizontal", this.pearlHorizontal);
			set(".projectiles.pearl.vertical", this.pearlVertical);
			set(".projectiles.snowball.horizontal", this.snowballHorizontal);
			set(".projectiles.snowball.vertical", this.snowballVertical);
			set(".projectiles.egg.horizontal", this.eggHorizontal);
			set(".projectiles.egg.vertical", this.eggVertical);
		}

		KnockbackConfig.save();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String[] getKnockbackValues() {
		return new String[] { "Horizontal§7: " + this.horizontal, 
				"Range Factor§7: " + this.rangeFactor, "Max Range Reduction§7: " + this.maxRangeReduction, 
				"Start Range Reduction§7: " + this.startRangeReduction, "Min Range§7: " + this.minRange,
				"Vertical§7: " + this.vertical,
				"Vertical-Max§7: " + this.verticalMax, "Vertical-Min§7: " + this.verticalMin,
				"Extra-Horizontal§7: " + this.extraHorizontal, "Extra-Vertical§7: " + this.extraVertical,
				"Friction-Horizontal§7: " + this.frictionHorizontal, "Friction-Vertical§7: " + this.frictionVertical,
				"Stop-Sprint§7: " + this.stopSprint, "WTap-Extra-Horizontal§7: " + this.wTapHorizontal,
				"WTap-Extra-Vertical§7: " + this.wTapVertical, "Add-Horizontal§7: " + this.addHorizontal,
				"Add-Vertical§7: " + this.addVertical };
	}

	@Override
	public String[] getProjectilesValues() {
		return new String[] { "Rod-Horizontal§7: " + this.rodHorizontal, "Rod-Vertical§7: " + this.rodVertical,
				"Arrow-Horizontal§7: " + this.arrowHorizontal, "Arrow-Vertical§7: " + this.arrowVertical,
				"Pearl-Horizontal§7: " + this.pearlHorizontal, "Pearl-Vertical§7: " + this.pearlVertical,
				"Snowball-Horizontal§7: " + this.snowballHorizontal, "Snowball-Vertical§7: " + this.snowballVertical,
				"Egg-Horizontal§7: " + this.eggHorizontal, "Egg-Vertical§7: " + this.eggVertical, };
	}
}
