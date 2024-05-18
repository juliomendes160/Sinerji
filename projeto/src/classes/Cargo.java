package classes;

public class Cargo {

    public static final Cargo secretaria = new Cargo("Secretário", 7000.0, 1000.0, 0.2);
    public static final Cargo vendedor = new Cargo("Vendedor", 12000.0, 1800.0, 0.3);
    public static final Cargo gerente = new Cargo("Gerente", 20000.0, 3000.0, 0.0);

    private String funcao;
    private double salario;
    private double adicional;
    private double beneficios;

    private Cargo(String funcao, double salario, double adicional, double beneficios) {
        this.funcao = funcao;
        this.salario = salario;
        this.adicional = adicional;
        this.beneficios = beneficios;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getAdicional() {
        return adicional;
    }

    public void setAdicional(double adicional) {
        this.adicional = adicional;
    }


    public double getBeneficio() {
        return beneficios;
    }

    public void setBeneficio(double beneficios) {
        this.beneficios = beneficios;
    }
}