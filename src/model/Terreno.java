package model;

public class Terreno extends Financiamento {
    private String tipoDeZona;

    public Terreno(double valorImovel, int prazoFinanciamentoAnos, double taxaJurosAnual, String tipoDeZona) {
        super(valorImovel, prazoFinanciamentoAnos, taxaJurosAnual);
        this.tipoDeZona = tipoDeZona;
    }

    public String getTipoDeZona() { return tipoDeZona; }

    @Override
    public double calcularPagamentoMensal() {
        double calculoBase = (this.valorImovel / (this.prazoFinanciamentoAnos * 12)) * (1 + ((this.taxaJurosAnual / 100.0) / 12));
        return calculoBase * 1.02;
    }

    @Override
    public void mostrarDadosFinanciamento() {
        System.out.println("\n===== FINANCIAMENTO DE TERRENO =====");
        super.mostrarDadosFinanciamento();
        System.out.println("Tipo de Zona: " + getTipoDeZona());
        System.out.println("=====================================");
    }

    @Override
    public String toTextoDetalhado() {
        return this.toTexto() + String.format(";%s;%s", this.tipoDeZona, "Terreno");
    }
}