package model;

import util.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento {
    private static final long serialVersionUID = 1L;
    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaConstruida() { return areaConstruida; }
    public double getAreaTerreno() { return areaTerreno; }

    private void aumentoExcedeJuros(double valorJurosMensais, double valorAcrescimo) throws AumentoMaiorDoQueJurosException {
        double limite = valorJurosMensais / 2;
        if (valorAcrescimo > limite) {
            throw new AumentoMaiorDoQueJurosException("ALERTA: O acréscimo é maior que o limite permitido.");
        }
    }

    private double calcularJurosMensais() {
        return this.valorImovel * (this.taxaJurosAnual / 100.0 / 12.0);
    }

    @Override
    public double calcularPagamentoMensal() {
        double valorJurosMensais = calcularJurosMensais();
        double valorAcrescimo = 80;
        try {
            aumentoExcedeJuros(valorJurosMensais, valorAcrescimo);
        } catch (AumentoMaiorDoQueJurosException e) {
            System.out.println(e.getMessage());
            valorAcrescimo = valorJurosMensais / 2;
        }
        double taxaMensalDecimal = (this.taxaJurosAnual / 100.0) / 12.0;
        double calculoBase = (this.valorImovel / (this.prazoFinanciamentoAnos * 12)) * (1 + taxaMensalDecimal);
        return calculoBase + valorAcrescimo;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        System.out.println("\n===== FINANCIAMENTO DE CASA =====");
        super.mostrarDadosFinanciamento();
        System.out.println("Área Construída: " + getAreaConstruida() + " m²");
        System.out.println("Tamanho do Terreno: " + getAreaTerreno() + " m²");
        System.out.println("=====================================");
    }

    @Override
    public String toTextoDetalhado() {
        return this.toTexto() + String.format(";%.2f;%.2f;%s", this.areaConstruida, this.areaTerreno, "Casa");
    }
}