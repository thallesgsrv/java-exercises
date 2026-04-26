import java.util.Scanner;

public class Credito {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		float value = sc.nextFloat();
		sc.nextLine();
		String form = sc.nextLine(); 

		if (form.equals("credito")) {
			String decisao = sc.nextLine();

			if (decisao.equals("s")) {
				int quant = sc.nextInt();
				float parcela = value / quant;
				System.out.println(quant + " PARCELAS DE " + parcela + " REAIS");
			} else {
				System.out.println(value + " REAIS NO CREDITO (DIRETO)");
			}
		
		} else {
			System.out.println(value + " REAIS NO DEBITO");
			}
	}
}	
