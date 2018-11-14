
package tp.p1.game;

import java.util.Scanner;
import tp.p1.command.*;


public class Controller {
	
	private Game game;
	private Scanner in;
	
	public Controller(Game game,Scanner in) {
		this.game=game;
		this.in=in;
	}
	
	public void run() {
		boolean exit=false;
		String prompt=game.printPrompt();
		String unknownCommandMsg="Comando incorrecto";
		
		while (!game.isNotFinished() && !exit) {
			printGame();
			boolean noPrint = false;
			System.out.print(prompt);
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			Command command = CommandParser.parseCommand(words, this);
			if (command != null) {
			command.execute(game, this);
			}
			else {
			System.err.println (unknownCommandMsg);
			setNoPrintGameState();
			}
		}
	}
		
		private void setNoPrintGameState() {
		
		}
		
		private void printGame() {
			game.setGamePrinter(new GamePrinter(game,game.getFILAS(),game.getCOLUMNAS()));
			System.out.println(game);
		}

		/*
		//variable para controlar el exit
		
		
		//variables para controlar update si no hay suncoins o si la accion no requiere update y draw
		boolean suncoins=true,list=false,help=false;
		
		while(game.isNotFinished()&&!exit) {
			
			if(suncoins&&!help&&!list) {
			//actualizar
			game.update();
			
			//draw
			printGame();
			}
			
			//user command
			System.out.println("Command > ");
			String[] comando=new String[4];
			comando=in.nextLine().toLowerCase().trim().split(" ");
			help=false;
			list=false;
			
			if(comando[0].equals("a")||comando[0].equals("add")) {
				//comprobar espacio vacio y coordenada dentro tablero
				if(game.checkEmpty(Integer.parseInt(comando[2]), Integer.parseInt(comando[3]))&&game.comprobarDentroTablero(comando[2], comando[3])) {
					//separar por tipo planta
					if(comando[1].equals("p")||comando[1].equals("peashooter")) {
						//comprobar dinero
						if(game.enoughMoneyPeaShooter()) {
							suncoins=true;
							game.decreaseSuncoins(PeaShooter.getCost());
							//aniadir peashooter en lista
							game.addPeashooter(Integer.parseInt(comando[2]), Integer.parseInt(comando[3]));
							//computer action
							game.addZombieAction();
							//aniadir ciclo
							game.addCycle();
						}
						else {
							System.out.println("You dont have enought Suncoins");
							suncoins=false;
						}
					}
					else if(comando[1].equals("s")||comando[1].equals("sunflower")) {
						//comprobar dinero
						if(game.enoughMoneySunFlower()) {
							suncoins=true;
							game.decreaseSuncoins(SunFlower.getCost());
							//aniadir sunflower a lista
							game.addSunflower(Integer.parseInt(comando[2]),Integer.parseInt(comando[3]));
							//computer action
							game.addZombieAction();
							//aniadir ciclo
							game.addCycle();
						}
						else {
							System.out.println("You dont have enought Suncoins");
							suncoins=false;
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
				list=true;
				System.out.println("[S]unflower: Cost: "+SunFlower.getCost()+"suncoins  Harm: "+SunFlower.getDamage());
				System.out.println("[P]eashooter: Cost: "+PeaShooter.getCost()+"suncoins  Harm: "+PeaShooter.getDamage()+"\n");
			}
			else if(comando[0].equals("h")||comando[0].equals("help")) {
				help=true;
				System.out.println("Add <plant> <x> <y>: Adds a plant in position x, y.");
				System.out.println("List: Prints the list of available plants.");
				System.out.println("Reset: Starts a new game.");
				System.out.println("Help: Prints this help message.");
				System.out.println("Exit: Terminates the program.");
				System.out.println("[none]: Skips cycle.\n");
			}
			else if(comando[0].equals("")||comando[0].equals("none")) {
				suncoins=true;
				//computer action
				game.addZombieAction();
				//aniadir ciclo
				game.addCycle();
			}
			else if((comando[0].equals("e")||comando[0].equals("exit"))) {
				exit=true;
			}
			else {
				System.out.println("Comando incorrecto");
				comando=in.nextLine().toLowerCase().trim().split(" ");
			}
		}
		if(exit) {
		System.out.println("Game Over");	
		}
		else if(game.getZombieManager().zombiGanador()) {
		System.out.println("\nZombies win");
		}
		else {
		System.out.println("\nPlayer wins");
		}
	}
	
	*/
		
}

