package br.com.soma;
import java.util.Scanner;

public class SomaSimples
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int num01 = 0;
		int num02 = 0;

		System.out.print("Digite o valor do primeiro numero: ");
		num01 = scanner.nextInt();
		System.out.print("Digite o valor do segundo numero: ");
		num02 = scanner.nextInt();

		System.out.println("Resultado da soma: " + (num01 + num02));
		
		scanner.close();
	}
}