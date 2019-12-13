package effet;

import java.awt.Color;

import bandeau.Bandeau;

public class SwipBackground extends AbstractEffect{

	private Color color;
	private int duration;
	
	
	public SwipBackground(Bandeau bandeau, int delay, Color color, int duration) {
		super(bandeau, delay);
		this.color = color;
		this.duration = duration;
	}
	@Override
	public void execute() {
		this.bandeau.sleep(delay);
		bandeau.setSubBackgroundColor(color);
		bandeau.setSubBackgroundY(0);
    	for (int i = 0; i < duration/5; i++) {
			bandeau.setSubBackgroundHeight(Math.round(i*((float) bandeau.getHeight()/((float)duration/5))));
    		bandeau.sleep(5);
		}
	}
	
}
