package exe_1_totalEleitores;

public class VotosTotalEleitores {

    public static void main(String[] args) {
        var total = 1000;
        var validos = 800;
        var emBranco = 150;
        var nulos = 50;

        calculaValidos(total, validos);
        calculaBrancos(total, emBranco);
        calculaNulos(total, nulos);
    }

    private static void calculaValidos(int total, int validos) {
        System.out.println("total validos: " + (validos * 100.0)/total + "%");
    }

    private static void calculaBrancos(int total, int emBranco) {
        System.out.println("total em branco: " + (emBranco * 100.0)/total + "%");
    }

    private static void calculaNulos(int total, int nulos) {
        System.out.println("total nulos: " + (nulos * 100.0)/total + "%");
    }
}
