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
		
		while((game.getZombieManager().getZombiesRestantes()>0)&&(true)) { //cambiar 2ª condicion zombie ganador
			game.update();
			System.out.println(game);
			
			
			System.out.println("Command > ");
			String[] comando=in.nextLine().toLowerCase().split(" ");
			
			//parsear/separar comando y realizar update
			if(comando[0].equals("a")||comando[0].equals("add")) {
				
			}
			else if(comando[0].equals("r")||comando[0].equals("reset")) {
				game.inicializar();
			}
			else if(comando[0].equals("l")||comando[0].equals("list")) {
				
			}
			else if(comando[0].equals("h")||comando[0].equals("help")) {
				
			}
			else if(comando[0].equals("")||comando[0].equals("none")) {
				
			}
			else {
				System.out.println("Comando incorrecto");
				comando=in.nextLine().toLowerCase().split(" ");
			}
			
		}
		//si el zombie gana
		System.out.println("Zombies win");
		//else
		System.out.println("Player wins");
	}
}
