package test;

import java.math.BigInteger;

import modelo.Concurrente;
import modelo.Secuencial;

public class Test {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		//QUEREMOS SABER EL FACTORIAL DE n
		final int n = 100000;
		
		//Iniciamos a contar el tiempo para el algoritmo secuencial
		long inicioTiempo = System.currentTimeMillis();
		
		//Claculamos el factorial de 100000 de manera secuencial
		Secuencial s1 = new Secuencial(n);
		s1.calcularFactorialSecuencial();
		
		//tomamos el tiempo final del algoritmo secuencial
		long finTiempo=System.currentTimeMillis();

		//System.out.printf("Factorial de %d de forma Secuencial----> Tiempo = %.4f%n", n, (finTiempo-inicioTiempo)/1000.0);
		System.out.printf("Factorial de %d de forma Secuencial----> Resultado = %d, Tiempo = %.4f%n", n, s1.getResultadoSecuencial(), (finTiempo-inicioTiempo)/1000.0);
		
		
		
		
		//iniciamos a contar el tiempo para el algoritmo concurrente con 2 hilos
		inicioTiempo = System.currentTimeMillis();
						
		//Creamos los 2 hilos
		Concurrente f1 = new Concurrente(2, n / 2);
		Concurrente f2 = new Concurrente(n / 2 + 1, n);
		Thread t1 = new Thread(f1);
		Thread t2 = new Thread(f2);
						
		//iniciamos los hilos
		t1.start();
		t2.start();
						
		t1.join();
		t2.join();
						
		//multiplicamos el resultado del hilo 1 y del hilo 2 para tener el resultado final
		BigInteger total = f1.getResultado().multiply(f2.getResultado());
						
		//tomamos el tiempo final del algoritmo concurrente
		finTiempo=System.currentTimeMillis();

		//System.out.printf("Factorial de %d de forma concurrente con 2 hilos----> Tiempo = %.4f%n", n, (finTiempo-inicioTiempo)/1000.0);
		System.out.printf("\nFactorial de %d de forma concurrente con 2 hilos----> Resultado = %d, Tiempo = %.4f%n", n, total, (finTiempo-inicioTiempo)/1000.0);
	}

}
