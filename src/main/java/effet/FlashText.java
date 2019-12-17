package effet;

import java.awt.Color;

import bandeau.Bandeau;

public class FlashText extends AbstractEffect {
	private String text;
	private int duration;
	private Color color1;
	private Color color2;
	
	public FlashText(Bandeau bandeau, int delay, String text,Color color1,Color color2) {
		super(bandeau, delay);
		this.text = text;
		this.duration = duration;
		this.color1 = color1;
		this.color2 = color2;
	}
	@Override
	public void execute() {
		this.bandeau.sleep(this.delay);
		this.bandeau.resetCustomEffect();
		this.bandeau.setMessage(text);
		this.bandeau.setForeground(color2);
		this.bandeau.setBackground(color1);
	}
		
		
	
	
}
