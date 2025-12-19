package model;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    protected double valorImovel;
    protected int prazoFinanciamentoAnos;
    protected double taxaJurosAnual;

    public double getValorImovel() { return valorImovel; }
    public int getPrazoFinanciamentoAnos() { return prazoFinanciamentoAnos; }
    public double getTaxaJurosAnual() { return taxaJurosAnual; }

    public Financiamento(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamentoAnos = prazoFinanciamentoAnos;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        return (this.calcularPagamentoMensal()) * this.prazoFinanciamentoAnos * 12;
    }

    public void mostrarDadosFinanciamento() {
        System.out.println(" DETALHES DO FINANCIAMENTO");
        System.out.println("Valor do Imóvel R$ " + String.format("%.2f", getValorImovel()));
        System.out.println("Prazo do Financiamento: " + getPrazoFinanciamentoAnos() + " anos");
        System.out.println("Taxa de Juros Anual: " + getTaxaJurosAnual() + "%");
        System.out.println("------------------------------------");
        System.out.println("\n RESUMO DO FINANCIAMENTO CALCULADO");
        System.out.println("Pagamento Mensal Estimado: R$ " + String.format("%.2f", calcularPagamentoMensal()));
        System.out.println("Total Pago no Financiamento: R$ " + String.format("%.2f", calcularTotalPagamento()));
        System.out.println("\n------------------------------------");
    }

    public abstract String toTextoDetalhado();

    public String toTexto() {
        return String.format("%.2f;%d;%.2f;%.2f;%.2f",
                getValorImovel(), getPrazoFinanciamentoAnos(), getTaxaJurosAnual(),
                calcularPagamentoMensal(), calcularTotalPagamento());
    }
}