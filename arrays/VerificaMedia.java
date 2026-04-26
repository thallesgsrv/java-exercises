import java.util.Scanner;

public class VerificaMedia {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int maior = 0;
		int menor = 1001; 
		int acima = 0;
		int abaixo = 0;

		while (true) { 
			String date = sc.nextLine();
			if (date.equals("-")) { 
				break;
			} 

			String[] singdate = date.split(" ");
			int nota = Integer.parseInt(singdate[1]);
			sum += nota;

			if (nota > maior){
				maior = nota;
			} 
			if (nota < menor) {
				menor = nota;
			}
			if ( nota >= 700) {
				acima ++;
			} else {
				abaixo ++;
			}
		}

		int media = sum / (acima + abaixo);
		System.out.println("maior: " + maior);
		System.out.println("menor: " + menor);
		System.out.println("media: " + media);		
		System.out.println("acima: " + acima);	
		System.out.println("abaixo: " + abaixo);
	}
}

