package effet;

import bandeau.Bandeau;

public abstract class AbstractEffect {
	protected Bandeau bandeau;
	protected int delay;
	
	public AbstractEffect(Bandeau bandeau,int delay) {
		this.bandeau = bandeau;
		this.delay = delay;
	}
	
	public abstract void execute();
}
