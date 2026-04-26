import java.util.Scanner;

public class MaiorQueMedia {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String seq = sc.nextLine();
		String[] parts = seq.split(" ");

		int total = 0;
		int[] numeros = new int[parts.length];

		for (int i = 0; i < parts.length; i++ ) {
			numeros[i] = Integer.parseInt(parts[i]);
			total += numeros[i]; 
		}

		float media = (float) total / parts.length;

		for (int numero : numeros) {
			if (numero > media) {
				System.out.print(numero + " ");
			}
		}
	}	
}

