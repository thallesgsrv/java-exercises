import java.util.Scanner;

public class DifAbs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int posicaoum = sc.nextInt();
        int velocidadeum = sc.nextInt();
        int posicaodois = sc.nextInt();
        int velocidadedois = sc.nextInt();
        int tempo = sc.nextInt();
        int dif = ((velocidadeum * tempo) + posicaoum) - ((velocidadedois * tempo) + posicaodois);
        System.out.println(Math.abs(dif));

    }
}
