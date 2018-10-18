
package tp.p1.game;

import java.util.Random;
import java.util.Scanner;

import tp.p1.plants.PeaShooter;
import tp.p1.plants.SunFlower;
import tp.p1.zombies.Zombie;

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
		
		while((game.getZombieManager().getZombiesRestantesVivos() > 0)&&(!game.getZombieManager().zombiGanador())) {
			System.out.println("Command > ");
			String[] comando=new String[4];
			comando=in.nextLine().toLowerCase().split(" ");
			
			
			if(comando[0].equals("a")||comando[0].equals("add")) {
				//comprobar espacio vacio
				if(game.checkEmpty(Integer.parseInt(comando[2]), Integer.parseInt(comando[3]))) {
					//separar por tipo planta
					if(comando[1].equals("p")||comando[1].equals("peashooter")) {
						//comprobar dinero
						if(game.getSuncoins().getSunCoins()>=PeaShooter.getCost()) {
							game.getSuncoins().setSunCoins(game.getSuncoins().getSunCoins()-PeaShooter.getCost());
							//aniadir peashooter en lista
							PeaShooter ps=new PeaShooter(Integer.parseInt(comando[2]),Integer.parseInt(comando[3]),game);
							game.getPeashooterList().Add(ps);
							System.out.println(game.getPeashooterList().getContador());
							//update
							game.update();
							//aniadir zombie
							if(game.getZombieManager().isZombieAdded()) {
								int filaZombie= new Random().nextInt(3);
								Zombie zomb=new Zombie(filaZombie,7,game);
								game.getZombieList().Add(zomb);
								game.getZombieManager().setZombiesRestantes(game.getZombieManager().getZombiesRestantes()-1);
							}
							//aniadir ciclo
							game.setNumCiclos(game.getNumCiclos()+1);
							//repintar tablero
							game.setGamePrinter(new GamePrinter(game,4,8));
							System.out.println(game);
						}
						else {
							System.out.println("You dont have enought Suncoins");
						}
					}
					else if(comando[1].equals("s")||comando[1].equals("sunflower")) {
						//comprobar dinero
						if(game.getSuncoins().getSunCoins()>=SunFlower.getCost()) {
							game.getSuncoins().setSunCoins(game.getSuncoins().getSunCoins()-SunFlower.getCost());
							//aniadir sunflower a lista
							SunFlower sf=new SunFlower(Integer.parseInt(comando[2]),Integer.parseInt(comando[3]),game);
							game.getSunflowerList().Add(sf);
							//update
							game.update();
							//aniadir zombie
							if(game.getZombieManager().isZombieAdded()) {
								int filaZombie= new Random().nextInt(3);
								Zombie zomb=new Zombie(filaZombie,7,game);
								game.getZombieList().Add(zomb);
								game.getZombieManager().setZombiesRestantes(game.getZombieManager().getZombiesRestantes()-1);
							}
							//aniadir ciclo
							game.setNumCiclos(game.getNumCiclos()+1);
							//repintar tablero
							game.setGamePrinter(new GamePrinter(game,4,8));
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
				if(game.getZombieManager().isZombieAdded()) {
					int filaZombie= new Random().nextInt(3);
					Zombie zomb=new Zombie(filaZombie,7,game);
					game.getZombieList().Add(zomb);
					game.getZombieManager().setZombiesRestantes(game.getZombieManager().getZombiesRestantes()-1);
				}
				game.setNumCiclos(game.getNumCiclos()+1);
				game.setGamePrinter(new GamePrinter(game,4,8));
				System.out.println(game);
			}
			else {
				System.out.println("Comando incorrecto");
				comando=in.nextLine().toLowerCase().split(" ");
			}
			
		}
		System.out.println("Los zombies restantes son: " + game.getZombieManager().getZombiesRestantes() + " los zombies vivos son: " + game.getZombieManager().getZombiesRestantesVivos());
		System.out.println("Game Over");
		if(game.getZombieManager().zombiGanador()) {
		System.out.println("\nZombies win");}
		else {
		System.out.println("\nPlayer wins");}
	}
}