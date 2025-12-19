package main;

import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;
import model.Financiamento;
import model.Casa;
import model.Apartamento;
import model.Terreno;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaFinanciamento = new ArrayList<>();

        System.out.println("\n--- Simulação ---");
        try {
            double valor = interfaceUsuario.pedirValorimovel();
            int prazo = interfaceUsuario.pedirPrazoFinanciamento();
            double taxa = interfaceUsuario.pedirTaxaJuros();
            double areaC = interfaceUsuario.pedirAreaContruida();
            double areaT = interfaceUsuario.pedirAreaTerreno();
            
            listaFinanciamento.add(new Casa(valor, prazo, taxa, areaC, areaT));
        } catch (Exception e) {
            System.out.println("Erro na entrada de dados: " + e.getMessage());
        }

        listaFinanciamento.add(new Casa(500000.0, 10, 10.0, 20, 20));
        listaFinanciamento.add(new Apartamento(500000.0, 10, 10.0, 1, 1));
        listaFinanciamento.add(new Apartamento(200000.0, 5, 8.0, 1, 1));
        listaFinanciamento.add(new Terreno(500000.0, 10, 10.0, "C"));

        System.out.println("\n--- Resultados ---");
        double totalImoveis = 0;
        double totalFinanciamentos = 0;

        for (Financiamento f : listaFinanciamento) {
            f.mostrarDadosFinanciamento();
            totalImoveis += f.getValorImovel();
            totalFinanciamentos += f.calcularTotalPagamento();
        }

        System.out.printf("\nTotal Imóveis: R$ %.2f\nTotal Financiamentos: R$ %.2f\n", totalImoveis, totalFinanciamentos);

        salvarTexto(listaFinanciamento);
        salvarSerializado(listaFinanciamento);
    }

    public static void salvarTexto(List<Financiamento> lista) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("financiamentos.txt"))) {
            for (Financiamento f : lista) writer.println(f.toTextoDetalhado());
            System.out.println("Arquivo texto salvo.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar texto: " + e.getMessage());
        }
    }

    public static void salvarSerializado(List<Financiamento> lista) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("financiamentos.ser"))) {
            out.writeObject(lista);
            System.out.println("Arquivo serializado salvo.");
        } catch (IOException e) {
            System.out.println("Erro ao serializar: " + e.getMessage());
        }
    }
}