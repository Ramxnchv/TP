package tp.p1.objects;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;

public class Sun extends PassiveGameObject {

	private boolean catched;

	public Sun(String symbol, int x, int y, Game game) {
		super("*",x, y, game);
		catched=false;
	}

	public String printInfo() {

		String str = "*";

		return str;
	}
	public void catchSun () {
		catched=true;
	}

	public void setPosition(int x, int y) {
		setX(x);
		setY(y);
	}

	public boolean isCatched() {
		return catched;
	}

	public void store(BufferedWriter bw) throws IOException {
		bw.write(symbol + ":" + x + ":" + y + ", ");
	}

}
