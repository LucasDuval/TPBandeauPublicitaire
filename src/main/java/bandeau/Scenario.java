package bandeau;

import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.LinkedList;

import effet.AbstractEffect;
import effet.FadeText;
import effet.FlashText;
import effet.SwipBackground;
import effet.TypeWritterText;
import effet.UnswipBackground;
import effet.ZoomText;

public class Scenario {
    private final Bandeau b = new Bandeau();
    private LinkedList<AbstractEffect> effects = new LinkedList<AbstractEffect>();
    
    public static void main(String[] args) {
    	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    	try {
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Orkney Bold.ttf")));
		} catch (Exception e) {
			e.printStackTrace();
		}
    	Color mainColor = new Color(183, 26, 81);
	    Scenario scenario = new Scenario();
	    scenario.getBandeau().setFont(new Font("Orkney", Font.TRUETYPE_FONT, 200));
	    scenario
	    .ajouteEffet(new SwipBackground(scenario.getBandeau(), 0, mainColor , 500))
	    .ajouteEffet(new FadeText(scenario.getBandeau(), 0, "WE", Color.WHITE, 200))
	    .ajouteEffet(new UnswipBackground(scenario.getBandeau(), 1000, Color.WHITE,500))
	    .ajouteEffet(new FadeText(scenario.getBandeau(), 0, "ARE", mainColor, 200))
	    .ajouteEffet(new SwipBackground(scenario.getBandeau(), 1000, mainColor, 500))
	    .ajouteEffet(new FadeText(scenario.getBandeau(), 0, "JE", Color.WHITE, 200))
	    .ajouteEffet(new FlashText(scenario.getBandeau(), 1000, "WE", mainColor, Color.WHITE))
	    .ajouteEffet(new FlashText(scenario.getBandeau(), 500, "ARE", Color.WHITE, mainColor))
	    .ajouteEffet(new FlashText(scenario.getBandeau(), 500, "JE", mainColor, Color.WHITE))
	    .ajouteEffet(new FlashText(scenario.getBandeau(), 1000, "WE", mainColor, Color.WHITE))
	    .ajouteEffet(new FlashText(scenario.getBandeau(), 500, "ARE", Color.WHITE, mainColor))
	    .ajouteEffet(new FlashText(scenario.getBandeau(), 500, "JE", mainColor, Color.WHITE))
	    .ajouteEffet(new ZoomText(scenario.getBandeau(), 500, "WE ARE JE", mainColor, Color.WHITE,200,200,true,3000))
	    .ajouteEffet(new ZoomText(scenario.getBandeau(), 0, "WE", Color.WHITE,mainColor, 1,200,true,1000))
	    .ajouteEffet(new ZoomText(scenario.getBandeau(), 500, "ARE", Color.WHITE,mainColor,1,200,true,1000))
	    .ajouteEffet(new ZoomText(scenario.getBandeau(), 500, "JE", Color.WHITE,mainColor,1,200,true,1000))
	    .ajouteEffet(new TypeWritterText(scenario.getBandeau(), 500, "WE ARE JE", Color.WHITE,mainColor, 3000,4000));
	    scenario.run();
    }
    
    public Scenario ajouteEffet(AbstractEffect e) {
    	this.effects.add(e);
    	return this;
    }
    public Scenario ajouteMultipleEffets(AbstractEffect e,int n) {
    	for (int i = 0; i < n; i++) {
			this.ajouteEffet(e);
		}
    	return this;
    }
    public Bandeau getBandeau() {
    	return b;
    }
	public void run() {
		for (AbstractEffect abstractEffect : effects) {
			abstractEffect.execute();
			System.out.println(abstractEffect.getClass());
		}
	}
}
