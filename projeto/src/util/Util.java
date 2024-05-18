package util;

import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import classes.Funcionario;
import classes.Venda;

public class Util {

    public static  Map<String, Object> ValidarAnoMes(String mesString, String anoString){

        if(!Pattern.compile("^(0[1-9]|1[0-2])$").matcher(mesString).matches()){
            throw new IllegalArgumentException("\nO mês deve conter 2 digitos e estar no intervalo de 01 a 12.");
        }

        if(!Pattern.compile("^\\d{4}$").matcher(anoString).matches()){
            throw new IllegalArgumentException("\nO ano deve conter 4 digitos.");
        }

        Map<String, Object> objeto = new HashMap<>();

        String dataString = mesString + "/" + anoString;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");

        YearMonth data = YearMonth.parse(dataString, formatter);

        objeto.put("data", data);
        objeto.put("formatter", formatter);

        return objeto;
    }

    public static double Total_Salario_Beneficio(List<Funcionario> funcionarios, String mesString, String anoString) {

        Map<String, Object> objeto = ValidarAnoMes(mesString, anoString);

        double total_salario = 0;
        double total_beneficio = 0;
        double total_salario_beneficio = 0;

        for (Funcionario funcionario : funcionarios) {
            
            String nome = funcionario.getNome();
            String cargo = funcionario.getCargo().getFuncao();
            double salario = funcionario.getCargo().getSalario();
            double adicional = funcionario.getCargo().getAdicional();
            double beneficio = funcionario.getCargo().getBeneficio();
            YearMonth contratacao = YearMonth.parse(funcionario.getContratacao(), (DateTimeFormatter) objeto.get("formatter"));
            int ano = (int) contratacao.until((YearMonth) objeto.get("data"), ChronoUnit.YEARS);
            double total_parcial = salario + (adicional * ano) + (beneficio * salario);

            if (contratacao.isBefore((YearMonth)objeto.get("data"))) {
                
                total_salario = total_salario + salario;
                total_beneficio = total_beneficio + (beneficio * salario);
                total_salario_beneficio = total_salario + total_beneficio;

                // System.err.println("Nome: " + nome);
                // System.err.println("Cargo: " + cargo);
                // System.err.println("Salário: " + salario);
                // System.err.println("Adicional: "+ adicional * ano);
                // System.err.println("Benefício: " +  beneficio * salario);
                // System.err.println("Contratação: " + contratacao);
                // System.err.println("Total Parcial: " + total_parcial);
                // System.err.println();

            } 
        }

        // System.err.println("Total Salário + Benefício: " + total_salario_beneficio);
        // System.err.println("Total Salário: " + total_salario);
        // System.err.println("Total Benefício: " + total_beneficio);
        // System.err.println();

        return total_salario_beneficio;
    }

    public static double Total_Salario(List<Funcionario> funcionarios, String mesString, String anoString) {

        Map<String, Object> objeto = ValidarAnoMes(mesString, anoString);

        double total_salario = 0;

        for (Funcionario funcionario : funcionarios) {
            
            double salario = funcionario.getCargo().getSalario();

            YearMonth contratacao = YearMonth.parse(funcionario.getContratacao(), (DateTimeFormatter)objeto.get("formatter"));
            
            if (contratacao.isBefore((YearMonth)objeto.get("data"))) {
                total_salario = total_salario + salario;
            } 
        }

        return total_salario;
    }

    public static double Total_Beneficio(List<Funcionario> funcionarios_beneficio, String mesString, String anoString) {

        Map<String, Object> objeto = ValidarAnoMes(mesString, anoString);

        double total_beneficio = 0;

        for (Funcionario funcionario : funcionarios_beneficio) {

            if (funcionario.getCargo().getBeneficio() == 0) {
                throw new IllegalArgumentException("\nSua lista deve conter apenas funcionários com benefícios.");
            }

            double beneficio = funcionario.getCargo().getBeneficio() * funcionario.getCargo().getSalario();

            YearMonth contratacao = YearMonth.parse(funcionario.getContratacao(), (DateTimeFormatter)objeto.get("formatter"));
            
            if (contratacao.isBefore((YearMonth)objeto.get("data"))) {
                
                total_beneficio = total_beneficio + beneficio;
            } 
        }

        return total_beneficio;
    }

    public static double Maior_Salario_Beneficio(List<Funcionario> funcionarios, String mesString, String anoString) {

        Map<String, Object> objeto = ValidarAnoMes(mesString, anoString);   

        double total_salario_beneficio = 0;
        double maior_salario_beneficio = 0;

        for (Funcionario funcionario : funcionarios) {
            
            double salario = funcionario.getCargo().getSalario();
            double adicional = funcionario.getCargo().getAdicional();
            double beneficio = funcionario.getCargo().getBeneficio();
            YearMonth contratacao = YearMonth.parse(funcionario.getContratacao(), (DateTimeFormatter)objeto.get("formatter"));
            int ano = (int) contratacao.until((YearMonth) objeto.get("data"), ChronoUnit.YEARS);

            if (contratacao.isBefore((YearMonth)objeto.get("data"))) {

                total_salario_beneficio = salario + (adicional * ano) + (beneficio * salario);

                if (maior_salario_beneficio < total_salario_beneficio) {
                    maior_salario_beneficio = total_salario_beneficio;
                }
            } 
        }

        return maior_salario_beneficio;
    }

    public static List<String> Maior_Beneficio(List<Funcionario> funcionarios_beneficio, String mesString, String anoString) {

        Map<String, Object> objeto = ValidarAnoMes(mesString, anoString);

        double total_beneficio = 0;
        double maior_beneficio = 0;
        List<String> nome = new ArrayList<>();

        for (Funcionario funcionario : funcionarios_beneficio) {

            if (funcionario.getCargo().getBeneficio() == 0) {
                throw new IllegalArgumentException("\nSua lista deve conter apenas funcionários com benefícios.");
            }

            double salario = funcionario.getCargo().getSalario();
            double beneficio = funcionario.getCargo().getBeneficio();
            YearMonth contratacao = YearMonth.parse(funcionario.getContratacao(), (DateTimeFormatter)objeto.get("formatter"));
            
            if (contratacao.isBefore((YearMonth)objeto.get("data"))) {
                
                total_beneficio = beneficio * salario;

                if (maior_beneficio < total_beneficio) {
                    maior_beneficio = total_beneficio;
                    if(nome.size() != 0){
                        nome.clear();
                    }
                    nome.add(funcionario.getNome());
                }else if (maior_beneficio == total_beneficio) {
                    nome.add(funcionario.getNome());
                }
            } 
        }

        return nome;
    }

    public static List<String> Mais_Venda(List<Funcionario> funcionarios_vendedor, String mesString, String anoString) {

        Map<String, Object> objeto = ValidarAnoMes(mesString, anoString);

        double maior_venda = 0;
        List<String> nome = new ArrayList<>();

        for (Funcionario funcionario : funcionarios_vendedor) {

            double total_venda = 0;

            for (Venda venda : funcionario.getVendas()){ 
                
                YearMonth dataVenda = YearMonth.parse(venda.getData(), (DateTimeFormatter)objeto.get("formatter"));
                double valor = venda.getValor();

                if (dataVenda.isBefore((YearMonth)objeto.get("data")) || dataVenda.equals((YearMonth)objeto.get("data"))) {
                    total_venda = total_venda + valor;
                } 
            }

            if (maior_venda < total_venda) {
                maior_venda = total_venda;
                if(nome.size() != 0){
                    nome.clear();
                }
                nome.add(funcionario.getNome());
            }else if (maior_venda == total_venda && total_venda > 0) {
                nome.add(funcionario.getNome());
            }
        }

        return nome;
    }
}