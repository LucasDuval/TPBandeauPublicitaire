package effet;

import java.awt.Color;

import bandeau.Bandeau;

public class FadeText extends AbstractEffect {
	private String text;
	private int duration;
	private Color color;
	
	public FadeText(Bandeau bandeau, int delay, String text,Color color, int duration) {
		super(bandeau, delay);
		this.text = text;
		this.duration = duration;
		this.color = color;
	}
	@Override
	public void execute() {
		this.bandeau.sleep(this.delay);
		//2000
		//0-400 
		for (int i = 0; i < duration/50; i++) {
			if (i==0) {
				this.bandeau.setMessage(text);
				this.bandeau.setForeground(new Color(1, 1, 1, 0));
			}
			this.bandeau.setForeground(new Color(((float)color.getRed()/255), ((float)color.getGreen()/255), ((float)color.getBlue()/255), ((float) i/((duration/50)-1))));
			this.bandeau.sleep(50);
		}
		
		
	}
	
	
}
