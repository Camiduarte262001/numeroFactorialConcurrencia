package modelo;

import java.math.BigInteger;

public class Concurrente implements Runnable{
	
	private int inicio, fin;
	private BigInteger resultado = BigInteger.ONE;
	
	public Concurrente(int inicio, int fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
	
	@Override
	public void run() {
		for(int i = inicio; i <= fin; i++) {
			resultado=resultado.multiply(BigInteger.valueOf(i));
		}
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public BigInteger getResultado() {
		return resultado;
	}

	public void setResultado(BigInteger resultado) {
		this.resultado = resultado;
	}
	
}
