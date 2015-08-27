package controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.example.warriorbattle.R;

public class Warrior extends Activity {
	private int lifeTotal, armorTotal, dpsTotal, strengthTotal, criticalTotal;
	private String warrior_user, warrior_name, warrior_level, warrior_life, warrior_armor, warrior_dps, warrior_strength, warrior_critical, warrior_rightHand, warrior_leftHand, warrior_head, warrior_body, warrior_leg, warrior_gold, warrior_xp;
	private String possession_item1, possession_item2, possession_item3, possession_item4, possession_item5, possession_item6, possession_item7, possession_item8, possession_item9, possession_item10, possession_item11, possession_item12;
	private String rightHand_id, rightHand_name, rightHand_type, rightHand_armor, rightHand_dps, rightHand_strength, rightHand_critical;
	private String leftHand_id, leftHand_name, leftHand_type, leftHand_armor, leftHand_dps, leftHand_strength, leftHand_critical;
	private String head_id, head_name, head_life, head_armor;
	private String body_id, body_name, body_life, body_armor;
	private String leg_id, leg_name, leg_life, leg_armor;
	private String warriorInfo;
	private TextView textWarrior;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Delete the black line on the top of the application
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.warrior);
		// Gets the previously created intent
		Intent warrior = getIntent();
		// Will return Extra values
		warrior_user = warrior.getStringExtra("warrior_user");
		warrior_name = warrior.getStringExtra("warrior_name");
		warrior_level = warrior.getStringExtra("warrior_level");
		warrior_life = warrior.getStringExtra("warrior_life");
		warrior_armor = warrior.getStringExtra("warrior_armor");
		warrior_dps = warrior.getStringExtra("warrior_dps");
		warrior_strength = warrior.getStringExtra("warrior_strength");
		warrior_critical = warrior.getStringExtra("warrior_critical");
		warrior_rightHand = warrior.getStringExtra("warrior_rightHand");
		warrior_leftHand = warrior.getStringExtra("warrior_leftHand");
		warrior_head = warrior.getStringExtra("warrior_head");
		warrior_body = warrior.getStringExtra("warrior_body");
		warrior_leg = warrior.getStringExtra("warrior_leg");
		warrior_gold = warrior.getStringExtra("warrior_gold");
		warrior_xp = warrior.getStringExtra("warrior_xp");
		possession_item1 = warrior.getStringExtra("possession_item1");
		possession_item2 = warrior.getStringExtra("possession_item2");
		possession_item3 = warrior.getStringExtra("possession_item3");
		possession_item4 = warrior.getStringExtra("possession_item4");
		possession_item5 = warrior.getStringExtra("possession_item5");
		possession_item6 = warrior.getStringExtra("possession_item6");
		possession_item7 = warrior.getStringExtra("possession_item7");
		possession_item8 = warrior.getStringExtra("possession_item8");
		possession_item9 = warrior.getStringExtra("possession_item9");
		possession_item10 = warrior.getStringExtra("possession_item10");
		possession_item11 = warrior.getStringExtra("possession_item11");
		possession_item12 = warrior.getStringExtra("possession_item12");
		rightHand_id = warrior.getStringExtra("rightHand_id");
		rightHand_name = warrior.getStringExtra("rightHand_name");
		rightHand_type = warrior.getStringExtra("rightHand_type");
		rightHand_armor = warrior.getStringExtra("rightHand_armor");
		rightHand_dps = warrior.getStringExtra("rightHand_dps");
		rightHand_strength = warrior.getStringExtra("rightHand_strength");
		rightHand_critical = warrior.getStringExtra("rightHand_critical");
		leftHand_id = warrior.getStringExtra("leftHand_id");
		leftHand_name = warrior.getStringExtra("leftHand_name");
		leftHand_type = warrior.getStringExtra("leftHand_type");
		leftHand_armor = warrior.getStringExtra("leftHand_armor");
		leftHand_dps = warrior.getStringExtra("leftHand_dps");
		leftHand_strength = warrior.getStringExtra("leftHand_strength");
		leftHand_critical = warrior.getStringExtra("leftHand_critical");
		head_id = warrior.getStringExtra("head_id");
		head_name = warrior.getStringExtra("head_name");
		head_life = warrior.getStringExtra("head_life");
		head_armor = warrior.getStringExtra("head_armor");
		body_id = warrior.getStringExtra("body_id");
		body_name = warrior.getStringExtra("body_name");
		body_life = warrior.getStringExtra("body_life");
		body_armor = warrior.getStringExtra("body_armor");
		leg_id = warrior.getStringExtra("leg_id");
		leg_name = warrior.getStringExtra("leg_name");
		leg_life = warrior.getStringExtra("leg_life");
		leg_armor = warrior.getStringExtra("leg_armor");

		/*
		 * TEXTVIEW
		 */

		// TextView textWarrior
		textWarrior=(TextView)findViewById(R.id.textWarrior);

		// Calcul Warrior Info
		lifeTotal = Integer.parseInt(warrior_life);
		armorTotal = Integer.parseInt(warrior_armor);
		dpsTotal = Integer.parseInt(warrior_dps);
		strengthTotal = Integer.parseInt(warrior_strength);
		criticalTotal = Integer.parseInt(warrior_critical);
		if(!warrior_rightHand.equals("null")) {
			if(!warrior_rightHand.equals("0")) {
				armorTotal = armorTotal + Integer.parseInt(rightHand_armor);
				dpsTotal = dpsTotal + Integer.parseInt(rightHand_dps);
				strengthTotal = strengthTotal + Integer.parseInt(rightHand_strength);
				criticalTotal = criticalTotal + Integer.parseInt(rightHand_critical);
			}
		}
		if(!warrior_leftHand.equals("null")) {
			if(!warrior_leftHand.equals("0")) {
				armorTotal = armorTotal + Integer.parseInt(leftHand_armor);
				dpsTotal = dpsTotal + Integer.parseInt(leftHand_dps);
				strengthTotal = strengthTotal + Integer.parseInt(leftHand_strength);
				criticalTotal = criticalTotal + Integer.parseInt(leftHand_critical);
			}
		}
		if(!warrior_head.equals("null")) {
			if(!warrior_head.equals("0")) {
				lifeTotal = lifeTotal + Integer.parseInt(head_life);
				armorTotal = armorTotal + Integer.parseInt(head_armor);
			}
		}
		if(!warrior_body.equals("null")) {
			if(!warrior_body.equals("0")) {
				lifeTotal = lifeTotal + Integer.parseInt(body_life);
				armorTotal = armorTotal + Integer.parseInt(body_armor);
			}
		}
		if(!warrior_leg.equals("null")) {
			if(!warrior_leg.equals("0")) {
				lifeTotal = lifeTotal + Integer.parseInt(leg_life);
				armorTotal = armorTotal + Integer.parseInt(leg_armor);
			}
		}
		// Display Warrior Info
		warriorInfo = "\n\n" + warrior_name + "\n\n\nLevel: " + warrior_level + "\nExperience: " + warrior_xp + "/100\n\nLife: " + Integer.toString(lifeTotal) + "\nArmor: " + Integer.toString(armorTotal);
		warriorInfo = warriorInfo + "\nDamage Per Second: " + Integer.toString(dpsTotal) + "\nStrength: " + Integer.toString(strengthTotal) + "\nCritical: " + Integer.toString(criticalTotal) + "\n";
		warriorInfo = warriorInfo + "\nRight Hand: " + rightHand_name + "\nLeft Hand: " +  leftHand_name + "\n";
		warriorInfo = warriorInfo + "\nHead: " + head_name + "\nBody: " + body_name + "\nLeg: " + leg_name + "\n\n\nGold: " + warrior_gold;

		textWarrior.setText(warriorInfo);
	}
}
