package model;

public class Apartamento extends Financiamento {
    private static final long serialVersionUID = 1L;
    private int vagasGaragem;
    private int numeroAndar;

    public int getVagasGaragem() { return vagasGaragem; }
    public int getNumeroAndar() { return numeroAndar; }

    public Apartamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (getTaxaJurosAnual() / 100.0) / 12.0;
        int prazoMeses = getPrazoFinanciamentoAnos() * 12;
        double fatorExponencial = Math.pow(1 + taxaMensal, prazoMeses);
        return (getValorImovel() * taxaMensal * fatorExponencial) / (fatorExponencial - 1);
    }

    @Override
    public void mostrarDadosFinanciamento() {
        System.out.println("\n===== FINANCIAMENTO DE APARTAMENTO =====");
        super.mostrarDadosFinanciamento();
        System.out.println("Vagas de Garagem: " + getVagasGaragem());
        System.out.println("Número do Andar: " + getNumeroAndar());
        System.out.println("=====================================");
    }

    @Override
    public String toTextoDetalhado() {
        return this.toTexto() + String.format(";%d;%d;%s", this.vagasGaragem, this.numeroAndar, "Apartamento");
    }
}