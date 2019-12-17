package effet;

import java.awt.Color;

import bandeau.Bandeau;

public class ZoomText extends AbstractEffect {
	private String text;
	private int duration;
	private Color color1;
	private Color color2;
	private int factor;
	private int base;
	private boolean ease;

	public ZoomText(Bandeau bandeau, int delay, String text, Color color1, Color color2,int base, int factor, boolean ease, int duration) {
		super(bandeau, delay);
		this.text = text;
		this.duration = duration;
		this.color1 = color1;
		this.color2 = color2;
		this.factor = factor;
		this.base = base;
		this.ease = ease;
	}

	@Override
	public void execute() {
		this.bandeau.sleep(this.delay);
		this.bandeau.setMessage(text);
		this.bandeau.setBackground(color1);
		this.bandeau.setForeground(color2);
		if (ease) {
			for (int i = 0; i < duration/3; i++) {
				this.bandeau.setFont(this.bandeau.getFont().deriveFont((float)(factor*Math.sqrt(i)*base)/(duration)));
				this.bandeau.sleep(1);
			}
			for (int i = (int) Math.sqrt(duration/3); i < duration; i+=5) {
				this.bandeau.setFont(this.bandeau.getFont().deriveFont((float)(factor*i*base)/(duration)));
				this.bandeau.sleep(1);
			}
		}
		else {
			for (int i = 0; i < duration/5; i++) {
				this.bandeau.setFont(this.bandeau.getFont().deriveFont((float)(factor*i*base)/(duration/5)));
				this.bandeau.sleep(5);
			}
		}
		
		
		
	}
	
	
}
