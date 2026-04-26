import java.util.Scanner;

public class Wally {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String names = sc.nextLine();

			if (names.equals("wally")) {
				break;
			}
			
			String[] namelist = names.split(" ");
			int cont = 0;
			for (int i = namelist.length -1; i >= 0 ; i--) {
				cont ++; 
				String name = namelist[i];
				if (name.length() == 5) {
					System.out.println(namelist[i]);
					break;
				} else if(cont == namelist.length) {
					System.out.println("?");
				}
			}
		}
	}
}
