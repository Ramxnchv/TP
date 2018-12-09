package tp.p1.objects;

import java.io.BufferedWriter;
import java.io.IOException;

import tp.p1.game.Game;

public abstract class GameObject {
	protected int x;
	protected int y;
	protected Game game;


	public GameObject(int x, int y, Game game) {
		this.x=x;
		this.y=y;
		this.game=game;
	}

	public abstract String printInfo();

	//getters y setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public abstract void store (BufferedWriter bw) throws IOException;


}
