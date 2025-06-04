package modelo;

import java.math.BigInteger;

public class Secuencial {
	
	private BigInteger resultadoSecuencial = BigInteger.ONE;
	private int numero;
	
	public Secuencial(int numero) {
		this.numero = numero;
	}
	
	public void calcularFactorialSecuencial() {
		
		for(int i=2; i<=numero; i++) {
			resultadoSecuencial = resultadoSecuencial.multiply(BigInteger.valueOf(i));
		}
		
	}

	public BigInteger getResultadoSecuencial() {
		return resultadoSecuencial;
	}

	public void setResultadoSecuencial(BigInteger resultadoSecuencial) {
		this.resultadoSecuencial = resultadoSecuencial;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	
	
}
