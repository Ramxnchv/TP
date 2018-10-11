package tp.p1.game;

public enum LEVEL {
	EASY(3,0.1),
	HARD(5,0.2),
	INSANE(10,0.3);
	
	private int numeroZombies;
	private double frecuencia;
	
	LEVEL(int numeroZombies,double frecuencia) {
		this.numeroZombies=numeroZombies;
		this.frecuencia=frecuencia;
	}

	public int getNumeroZombies() {
		return numeroZombies;
	}

	public void setNumeroZombies(int numeroZombies) {
		this.numeroZombies = numeroZombies;
	}

	public double getFrecuencia() {
		return frecuencia;
	}

	public void setFrecuencia(double frecuencia) {
		this.frecuencia = frecuencia;
	}
	
	
	
}
