package tp.p1.objects;

import tp.p1.game.Game;

public class Sun extends PassiveGameObject {

	public Sun(int x, int y, Game game) {
		super(x, y, game);
	}

	public String printInfo() {
		
		String str = "*";
		
		return str;
	}
	
	public void setPosition(int x, int y) {
		setX(x);
		setY(y);
	}

}
