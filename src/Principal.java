import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        ConsultarMoeda consultaMoeda = new ConsultarMoeda();
        Moedas moeda;
        Scanner leitura = new Scanner(System.in);
        String resultadoInicial;
        double resultado;
        String valor;


        while (true) {
            System.out.println("MENU");
            System.out.println("1 - USD >>> BRL");
            System.out.println("2 - BRL >>> USD");
            System.out.println("3 - EUR >>> BRL");
            System.out.println("4 - BRL >>> EUR");
            System.out.println("5 - CNY >>> BRL");
            System.out.println("6 - BRL >>> CNY");
            System.out.println("99 - Sair");
            System.out.println("Digite a opção: ");

            valor = leitura.next();
            if (valor.equalsIgnoreCase("99")) {
                System.out.println("Conversor encerrado!");
                break;
            }
            switch (valor) {
                case "1", "2", "3", "4", "5", "6":
                    System.out.println("Digite o valor para conversão: ");
                    resultadoInicial = leitura.next();
                    if (validarValor(resultadoInicial)) {
                        resultado = Double.parseDouble(resultadoInicial);


                        switch (valor) {
                            case "1":
                                moeda = consultaMoeda.buscarMoedas("USD", "BRL");
                                System.out.println("Valor convertido entre USD para BRL: " + resultado * moeda.conversion_rate());
                                break;
                            case "2":
                                moeda = consultaMoeda.buscarMoedas("BRL", "USD");
                                System.out.println("Valor convertido entre BRL para USD: " + resultado * moeda.conversion_rate());
                                break;
                            case "3":
                                moeda = consultaMoeda.buscarMoedas("EUR", "BRL");
                                System.out.println("Valor convertido entre EUR para BRL: " + resultado * moeda.conversion_rate());
                                break;
                            case "4":
                                moeda = consultaMoeda.buscarMoedas("BRL", "EUR");
                                System.out.println("Valor convertido entre BRL para EUR: " + resultado * moeda.conversion_rate());
                                break;
                            case "5":
                                moeda = consultaMoeda.buscarMoedas("CNY", "BRL");
                                System.out.println("Valor convertido entre CNY para BRL: " + resultado * moeda.conversion_rate());
                                break;
                            case "6":
                                moeda = consultaMoeda.buscarMoedas("BRL", "CNY");
                                System.out.println("Valor convertido entre BRL para CNY: " + resultado * moeda.conversion_rate());
                                break;
                        }

                    } else {
                        System.out.println("Favor, digitar um valor numérico.");
                    }
                    break;
                default:
                    System.out.println("Digite uma das opções do menu.");
                    break;


            }
        }
    }

    public static boolean validarValor(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
