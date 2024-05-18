package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Funcionario {

    public static final Funcionario jorgeCarvalho = new Funcionario("Jorge Carvalho", Cargo.secretaria, "01/2018", new ArrayList<>());
    public static final Funcionario mariaSouza = new Funcionario("Maria Souza", Cargo.secretaria, "12/2015",  new ArrayList<>());
    public static final Funcionario anaSilva = new Funcionario("Ana Silva", Cargo.vendedor, "12/2021", new ArrayList<>(Arrays.asList( new Venda("12/2021", 5200.00), new Venda("01/2022", 4000.0), new Venda("02/2022", 4200.0), new Venda("03/2022", 5850.0), new Venda("04/2022", 7000.0))));
    public static final Funcionario joaoMendes = new Funcionario("João Mendes", Cargo.vendedor, "12/2021", new ArrayList<>(Arrays.asList(new Venda("12/2021", 3400.00), new Venda("01/2022", 7700.0), new Venda("02/2022", 5000.0), new Venda("03/2022", 5900.0), new Venda("04/2022", 6500.0))));
    public static final Funcionario julianaAlves = new Funcionario("Juliana Alves", Cargo.gerente, "07/2017",  new ArrayList<>());
    public static final Funcionario bentoAlbino = new Funcionario("Bento Albino", Cargo.gerente, "03/2014",  new ArrayList<>());

    private String nome;
    private Cargo cargo;
    private String contratacao;
    private List<Venda> vendas;

    public Funcionario(String nome, Cargo cargo, String contratacao, List<Venda> vendas) {
        this.nome = nome;
        this.cargo = cargo;
        this.contratacao = contratacao;
        this.vendas = vendas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getContratacao() {
        return contratacao;
    }

    public void setContratacao(String contratacao) {
        this.contratacao = contratacao;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}
