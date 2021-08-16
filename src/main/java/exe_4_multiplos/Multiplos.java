package exe_4_multiplos;

public class Multiplos {
    public static void main(String[] args) {
        var numero = Integer.valueOf(args[0]);
        multipleSum(numero);
    }

    private static void multipleSum(int num) {
        var sum = 0;
        for (int i = 0; i < num; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum+=i;
            }
        }
        System.out.println("A soma dos multiplos de 3 ou 5 de " + num + " é: " + sum);
    }
}
