import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import classes.Funcionario;
import util.Util;

public class App {
    public static void main(String[] args) throws Exception {
        
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList( 
            Funcionario.jorgeCarvalho, 
            Funcionario.mariaSouza, 
            Funcionario.anaSilva, 
            Funcionario.joaoMendes, 
            Funcionario.julianaAlves, 
            Funcionario.bentoAlbino
        ));
        List<Funcionario> funcionarios_beneficio = new ArrayList<>(Arrays.asList( 
            Funcionario.jorgeCarvalho, 
            Funcionario.mariaSouza, 
            Funcionario.anaSilva, 
            Funcionario.joaoMendes
        ));
        String mes = "01";
        String ano = "2022";
        
        double total_salario_beneficio = Util.Total_Salario_Beneficio(funcionarios, mes, ano);
        System.err.println("Total de salário + beneficio: " + total_salario_beneficio);

        double total_salario = Util.Total_Salario(funcionarios, mes, ano);
        System.err.println("Total de salário: " + total_salario);

        double total_beneficios = Util.Total_Beneficio(funcionarios_beneficio, mes, ano);
        System.err.println("Total de benefícios: " + total_beneficios);

        double maior_salario_beneficio = Util.Maior_Salario_Beneficio(funcionarios, mes, ano);
        System.err.println("Maior salário: " + maior_salario_beneficio);

        List<String> nomeFuncionario = Util.Maior_Beneficio(funcionarios_beneficio, mes, ano);
        System.err.println("Funcionário com maior benefício ou benefício iguais: " + nomeFuncionario);

        List<String> nomeVendedor = Util.Mais_Venda(funcionarios, mes, ano);
        System.err.println("Funcionário com mais vendas ou vendas iguais: " + nomeVendedor);
    }
}
