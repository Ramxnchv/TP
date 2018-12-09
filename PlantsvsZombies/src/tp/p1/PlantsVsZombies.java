package tp.p1;

import tp.p1.game.*;
import tp.p1.objects.GameObject;
import tp.p1.printer.GamePrinter;
import tp.p1.printer.Release;

import java.util.Random;
import java.util.Scanner;

public class PlantsVsZombies {

	public static void main(String[] args) {
	try {
		if((args.length>0)||(args.length<3)) {
			LEVEL level;
			long seed;
			Random rand;
			Scanner scanner=new Scanner(System.in);
			
			args[0].toUpperCase();
			try {
				if(args[0].equals("EASY")) {
					level=LEVEL.EASY;
				}
				else if(args[0].equals("HARD")) {
					level=LEVEL.HARD;
				}
				else if(args[0].equals("INSANE")) {
					level=LEVEL.INSANE;
				}
				else {
					throw new LevelException("Nivel incorrecto, por defecto se asignara EASY");
				}
			}catch (LevelException e) {
				System.out.println(e.getMessage());	
				level=LEVEL.EASY;
			}
			
			if(args.length==1) {
				seed=new Random().nextInt(5);
			}
			else {
				seed=Long.parseLong(args[1]);
			}
			
			rand= new Random(seed);
			Game game = new Game(level,rand,(int)seed);
			Controller controller = new Controller(game,scanner);
			System.out.println("Random seed used: "+(int)seed);
			controller.run();
			}
	else {
		throw new NumParamsException("Has introducido un numero de parametros incorrecto");	
	}
		}catch(NumParamsException e) {
			System.out.println(e.getMessage());
		}
	}
}