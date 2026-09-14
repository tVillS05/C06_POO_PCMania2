
public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores;
    private int qtdComputadores;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.computadores = new Computador[20];
        this.qtdComputadores = 0;
    }

    public void adicionarComputador(Computador pc) {
        if (qtdComputadores < computadores.length) {
            computadores[qtdComputadores] = pc;
            qtdComputadores++;
        }
    }

    public float calculaTotalCompra() {
        float total = 0;
        for (int i = 0; i < qtdComputadores; i++) {
            total += computadores[i].getPreco();
        }
        return total;
    }

    public Computador[] getComputadores() {
        return computadores;
    }

    public int getQtdComputadores() {
        return qtdComputadores;
    }

    public void mostraInfo() {
        System.out.println("Dados do Cliente");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Quantidade de PCs comprados: " + qtdComputadores);
        System.out.println();
    }
}