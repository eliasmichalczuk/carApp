package exe_2_bubbleSort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BubbleSort {
    public static void main(String[] args) {

        var v = new Object[]{5, 3, 2, 4, 7, 1, 0, 6};

        try {
            if (args.length > 0) {
                v = Arrays.stream(args).map(str -> Integer.valueOf(str)).collect(Collectors.toList()).toArray();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao receber lista de argumentos, utilizando lista em codigo");
            System.out.println("Deve ser passados argumentos para o programa no formato, ex: 2 6 4 1 2. Sem vírgulas");
        }

        var quantityAlreadySorted = 0;

        while (quantityAlreadySorted < v.length) {
            for (int i = 0; i < v.length - 1; i++) {

                if ((int) v[i] > (int) v[i + 1]) {
                    var beforeElement =v[i + 1];
                    v[i + 1] = v[i];
                    v[i] = beforeElement;
                }
            }
            quantityAlreadySorted++;
        }

        System.out.println("Imprimindo elementos ordenados: ");
        for (int i = 0; i < v.length; i++) {
            System.out.println(v[i]);
        }
    }
}
