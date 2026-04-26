package lp2.lab01;
public class IdadePreferencialInteligente {
    public static void main(String[] args) {

        int idade = 20;
        boolean gravida = true;
        int criancasDeColo = 0;

        if (idade >= 60) {
            System.out.println("Preferencial Idoso.");
        } else if (gravida) {
            System.out.println("Preferencial Gestante.");
        } else if (criancasDeColo > 0) {
            System.out.println("Preferencial pois está com " + criancasDeColo + " crianças de colo.");
        } else {
            System.out.println("Sem atendimento preferencial.");
        }
    }
}
