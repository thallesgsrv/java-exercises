import java.util.Scanner;
    
public class DefineFuncao {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int primeiro = sc.nextInt();
        int segundo = sc.nextInt();
        int terceiro = sc.nextInt();
        int quarto = sc.nextInt();
        if (primeiro > segundo && segundo > terceiro && terceiro > quarto) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE DECRESCENTE");
        }
        else if (primeiro < segundo && segundo < terceiro && terceiro < quarto) {
            System.out.println("POSSIVELMENTE ESTRITAMENTE CRESCENTE");
        }
        else {
            System.out.println("FUNCAO NAO ESTRITAMENTE CRES/DECR");
        }
    }
}
