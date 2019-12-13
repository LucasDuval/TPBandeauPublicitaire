package effet;

import java.awt.Color;

import bandeau.Bandeau;

public class TypeWritterText extends AbstractEffect {
	private String text;
	private int duration;
	private Color color1;
	private Color color2;
	private int additionnalDuration;
	
	public TypeWritterText(Bandeau bandeau, int delay, String text,Color color1,Color color2,int duration,int additionnalDuration) {
		super(bandeau, delay);
		this.text = text;
		this.duration = duration;
		this.color1 = color1;
		this.color2 = color2;
		this.additionnalDuration = additionnalDuration;
	}
	@Override
	public void execute() {
		this.bandeau.sleep(this.delay);
		this.bandeau.resetCustomEffect();
		this.bandeau.setForeground(color2);
		this.bandeau.setBackground(color1);
		for (int i = 0; i < text.length()+1; i++) {
			this.bandeau.setMessage(text.substring(0, i)+(i-1==text.length()?"":"_"));
			this.bandeau.sleep(duration/text.length());
		}
		if (additionnalDuration!=0) {
			for (int i = 0; i < duration/500; i++) {
				if (i%2==1) {
					this.bandeau.setMessage(text+"_");
				}
				else {
					this.bandeau.setMessage(text+"   ");
				}
				this.bandeau.sleep(500);
			}
		}
	}
		
		
	
	
}
