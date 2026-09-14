import java.util.Scanner;

public class PCMania2 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        int matricula = 598;

        float preco1 = matricula;
        float preco2 = matricula + 1;
        float preco3 = matricula + 2;

        //Apple
        HardwareBasico proc1 = new HardwareBasico("Pentium Core i5", 2200);
        HardwareBasico ram1  = new HardwareBasico("Memória RAM", 8);
        HardwareBasico hd1   = new HardwareBasico("HD", 500);
        SistemaOperacional so1 = new SistemaOperacional("macOS Sequoia", 64);
        Computador apple = new Computador("Apple", preco1, proc1, ram1, hd1, so1);
        apple.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

        //Samsung
        HardwareBasico proc2 = new HardwareBasico("Pentium Core i7", 3370);
        HardwareBasico ram2  = new HardwareBasico("Memória RAM", 16);
        HardwareBasico hd2   = new HardwareBasico("HD", 1000); // 1Tb
        SistemaOperacional so2 = new SistemaOperacional("Windows 8", 64);
        Computador samsung = new Computador("Samsung", preco2, proc2, ram2, hd2, so2);
        samsung.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

        //Dell
        HardwareBasico proc3 = new HardwareBasico("Pentium Core i7", 4500);
        HardwareBasico ram3  = new HardwareBasico("Memória RAM", 32);
        HardwareBasico hd3   = new HardwareBasico("HD", 2000); // 2Tb
        SistemaOperacional so3 = new SistemaOperacional("Windows 10", 64);
        Computador dell = new Computador("Dell", preco3, proc3, ram3, hd3, so3);
        dell.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000)); // 1Tb

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = entrada.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        String cpfCliente = entrada.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpfCliente);

        int codigo;
        do {
            System.out.println("\nPC MANIA - Promoções");
            System.out.println("1 - Promoção 1 (Apple)");
            System.out.println("2 - Promoção 2 (Samsung)");
            System.out.println("3 - Promoção 3 (Dell)");
            System.out.println("0 - Finalizar compra");
            System.out.print("Digite o código da promoção desejada: ");
            codigo = entrada.nextInt();

            if (codigo == 1) {
                cliente.adicionarComputador(apple);
                System.out.println("PC Apple adicionado ao carrinho!");
            } else if (codigo == 2) {
                cliente.adicionarComputador(samsung);
                System.out.println("PC Samsung adicionado ao carrinho!");
            } else if (codigo == 3) {
                cliente.adicionarComputador(dell);
                System.out.println("PC Dell adicionado ao carrinho!");
            } else if (codigo != 0) {
                System.out.println("Código inválido! Tente novamente.");
            }
        } while (codigo != 0);

        System.out.println("\nResumo da compra");
        cliente.mostraInfo();

        Computador[] pcsComprados = cliente.getComputadores();
        for (int i = 0; i < cliente.getQtdComputadores(); i++) {
            pcsComprados[i].mostraPCConfigs();
        }

        float total = cliente.calculaTotalCompra();
        System.out.println("Total: R$ " + total);

        // Processamento do pedido
        ProcessarPedido.processar(pcsComprados);

        entrada.close();
    }
}