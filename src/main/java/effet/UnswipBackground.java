package effet;

import java.awt.Color;

import bandeau.Bandeau;

public class UnswipBackground extends AbstractEffect{

	private Color color;
	private int duration;
	
	
	public UnswipBackground(Bandeau bandeau, int delay, Color color, int duration) {
		super(bandeau, delay);
		this.color = color;
		this.duration = duration;
	}
	@Override
	public void execute() {
		this.bandeau.sleep(delay);
		bandeau.setBackground(color);
    	for (int i = 1; i < duration/5; i++) {
			bandeau.setSubBackgroundY(Math.round(bandeau.getHeight()*((float)i/(float)(duration/5))));
    		bandeau.sleep(5);
		}
		
	}
	
}
