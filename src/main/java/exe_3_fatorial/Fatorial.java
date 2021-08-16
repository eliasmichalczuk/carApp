package exe_3_fatorial;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Fatorial {


    public static void main(String[] args) {

        var numero = 5;
        if (args.length > 0) {
           numero = Integer.valueOf(args[0]);
            System.out.println("calculando fatorial de " + numero);
        } else {
            System.out.println("nada passado como parametro para o fatorial, calculando fatorial de 5");
        }
        System.out.println("fatorial: " + fatorial(numero));
    }

    private static int fatorial(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 1;
        }
        return i * fatorial(i - 1);
    }
}
