package tp.p1.game;

import java.util.Scanner;

import tp.p1.plants.PeaShooter;
import tp.p1.plants.SunFlower;

public class Controller {
	private Game game;
	private Scanner in;
	public Controller(Game game,Scanner in) {
		this.game=game;
		this.in=in;
	}
	public void run() {
		
		System.out.println("Random seed used: "+game.getSeed());
		
		while((game.getZombieManager().getZombiesRestantes()>0)&&(!game.getZombieManager().zombiGanador())) {
			
			game.update();
			System.out.println(game);
			
			System.out.println("Command > ");
			String[] comando=new String[4];
			comando=in.nextLine().toLowerCase().split(" ");
			
			
			if(comando[0].equals("a")||comando[0].equals("add")) {
				//comprobar espacio vacio
				if(game.checkEmpty(Integer.parseInt(comando[2]), Integer.parseInt(comando[3]))) {
					//separar por tipo planta
					if(comando[1].equals("p")||comando[1].equals("peashooter")) {
						//comprobar dinero
						if(game.getSuncoins().getSunCoins()>PeaShooter.getCost()) {
							PeaShooter ps=new PeaShooter(Integer.parseInt(comando[2]),Integer.parseInt(comando[3]),game);
							game.getPeashooterList().Add(ps);
							game.update();
							game.setNumCiclos(game.getNumCiclos()+1);
							System.out.println(game);
						}
						else {
							System.out.println("You dont have enought Suncoins");
						}
					}
					else if(comando[1].equals("s")||comando[1].equals("sunflower")) {
						if(game.getSuncoins().getSunCoins()>SunFlower.getCost()) {
							SunFlower sf=new SunFlower(Integer.parseInt(comando[2]),Integer.parseInt(comando[3]),game);
							game.getSunflowerList().Add(sf);
							game.update();
							game.setNumCiclos(game.getNumCiclos()+1);
							System.out.println(game);
						}
						else {
							System.out.println("You dont have enought Suncoins");
						}
					}
					else {
						System.out.println("Wrong plant name");
					}
				}
			}
			else if(comando[0].equals("r")||comando[0].equals("reset")) {
				game.inicializar();
			}
			else if(comando[0].equals("l")||comando[0].equals("list")) {
				System.out.println("[S]unflower: Cost: "+SunFlower.getCost()+"suncoins  Harm: "+SunFlower.getDamage());
				System.out.println("[P]eashooter: Cost: "+PeaShooter.getCost()+"suncoins  Harm: "+PeaShooter.getDamage());
			}
			else if(comando[0].equals("h")||comando[0].equals("help")) {
				System.out.println("Add <plant> <x> <y>: Adds a plant in position x, y.");
				System.out.println("List: Prints the list of available plants.");
				System.out.println("Reset: Starts a new game.");
				System.out.println("Help: Prints this help message.");
				System.out.println("Exit: Terminates the program.");
				System.out.println("[none]: Skips cycle.");
			}
			else if(comando[0].equals("")||comando[0].equals("none")) {
				game.update();
				game.setNumCiclos(game.getNumCiclos()+1);
				System.out.println(game);
			}
			else {
				System.out.println("Comando incorrecto");
				comando=in.nextLine().toLowerCase().split(" ");
			}
			
		}
		
		if(game.getZombieManager().zombiGanador()) {
		System.out.println("\nZombies win");}
		else {
		System.out.println("\nPlayer wins");}
	}
}
