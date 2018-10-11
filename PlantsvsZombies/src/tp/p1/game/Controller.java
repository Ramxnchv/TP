package tp.p1.game;

import java.util.Scanner;

public class Controller {
	private Game game;
	private Scanner in;
	public Controller(Game game,Scanner in) {
		this.game=game;
		this.in=in;
	}
	public void run() {
		System.out.println("Random seed used: "+game.getSeed());
		System.out.println(game);
		
		while((game.getZombieManager().getZombiesRestantes()>0)&&(true)) { //cambiar 2ª condicion zombie ganador
			System.out.println("Command > ");
			String comando=in.nextLine();
			comando.toLowerCase();
			
			//parsear/separar comando y realizar update
			if(comando.startsWith("a")||(comando.startsWith("add"))) {
				
			}
			else if(comando.startsWith("r")||(comando.startsWith("reset"))) {
				game.reset();
			}
			else if(comando.startsWith("l")||(comando.startsWith("list"))) {
				
			}
			else if(comando.startsWith("h")||(comando.startsWith("help"))) {
				
			}
			else if(comando.startsWith("")||(comando.startsWith("none"))) {
				
			}
			else {
				
			}
			
			
			game.update();
			game.setNumCiclos(game.getNumCiclos()+1);
		}
		//si el zombie gana
		System.out.println("Zombies win");
		//else
		System.out.println("Player wins");
	}
}
