package pcmania;

import java.util.Scanner;

public class PCMania {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int matricula = 598;

        float precoPromo1 = matricula;
        float precoPromo2 = matricula + 1234;
        float precoPromo3 = matricula + 5678;

        // promoções
        // apple
        HardwareBasico hb11 = new HardwareBasico("Processador Core i3", 2200);
        HardwareBasico hb12 = new HardwareBasico("Memória RAM", 8);
        HardwareBasico hb13 = new HardwareBasico("HD", 500);
        SistemaOperacional so1 = new SistemaOperacional("macOS Sequoia", 64);
        Computador pc1 = new Computador("Apple", precoPromo1, hb11, hb12, hb13, so1);
        pc1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        // samsung
        HardwareBasico hb21 = new HardwareBasico("Processador Core i5", 3370);
        HardwareBasico hb22 = new HardwareBasico("Memória RAM", 16);
        HardwareBasico hb23 = new HardwareBasico("HD", 1000);
        SistemaOperacional so2 = new SistemaOperacional("Windows 8", 64);
        Computador pc2 = new Computador("Samsung", precoPromo2, hb21, hb22, hb23, so2);
        pc2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        // dell
        HardwareBasico hb31 = new HardwareBasico("Processador Core i7", 4500);
        HardwareBasico hb32 = new HardwareBasico("Memória RAM", 32);
        HardwareBasico hb33 = new HardwareBasico("HD", 2000);
        SistemaOperacional so3 = new SistemaOperacional("Windows 10", 64);
        Computador pc3 = new Computador("Dell", precoPromo3, hb31, hb32, hb33, so3);
        pc3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

        // cliente
        System.out.print("Digite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu CPF: ");
        String cpf = sc.nextLine();

        Cliente cliente = new Cliente(nome, cpf);

        // menu
        int codigo;
        while (true) {
            System.out.println("Escolha a promocao:");
            System.out.println("1 - Apple");
            System.out.println("2 - Samsung");
            System.out.println("3 - Dell");
            System.out.println("0 - finalizar compra");
            System.out.print("Digite o código: ");

            codigo = sc.nextInt();

            if (codigo == 1) {
                cliente.comprar(pc1);
            } else if (codigo == 2) {
                cliente.comprar(pc2);
            } else if (codigo == 3) {
                cliente.comprar(pc3);
            } else if (codigo == 0) {
                System.out.println("Compra finalizada!");
            } else {
                System.out.println("Código inválido!");
            }

            if (codigo == 0) {
                break;
            }
        }

        cliente.mostraInfo();

        float total = 0;
        Computador[] compras = cliente.getCompra();

        for (int i = 0; i < cliente.getQtdCompras(); i++) {
            compras[i].mostraPCConfig();
            total += compras[i].getPreco();
        }

        System.out.println("Total da compra: R$ " + total);

        System.out.println("\nProcessando pedido...");
        ProcessarPedido.processar(compras);

        sc.close();
    }
}
