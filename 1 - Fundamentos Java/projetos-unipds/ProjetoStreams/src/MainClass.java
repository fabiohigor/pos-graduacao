import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
	public static void main(String[] args) {
		List<Veiculo> lista = new ArrayList<>() {{
			add(new Veiculo("Corsa", "Cinza", 25000, 1998, 160));
			add(new Veiculo("Corolla", "Prata", 70000, 2020, 200));
			add(new Veiculo("Corolla", "Preto", 100000, 2025, 210));
			add(new Veiculo("X1", "Branco", 250000, 2023, 250));
			add(new Veiculo("GLA200", "Prata", 300000, 2025, 280));
		}};
		
		List<Veiculo> ordenada = lista.stream()
				                      .sorted(Comparator.comparing(Veiculo::getMarca).reversed())
				                      .collect(Collectors.toList());
		
		List<Veiculo> corolas = lista.stream()
									 .filter(v -> v.getMarca().equalsIgnoreCase("corolla"))
									 .toList();
		
		double precoMedio = lista.stream().mapToDouble(Veiculo::getPreco).average().orElse(0.0);
		System.out.println("Preco Medio = "+precoMedio);
		double maximo = lista.stream().mapToDouble(Veiculo::getPreco).max().orElse(0.0);
		System.out.println("Preco maximo = "+maximo);
		double minimo = lista.stream().mapToDouble(Veiculo::getPreco).min().getAsDouble();
		System.out.println("Preco minimo = "+minimo);
		
		double mediaDosCorolas = lista.stream()
				                      .filter(v-> v.getMarca().equalsIgnoreCase("corolla"))
				                      .mapToDouble(Veiculo::getPreco)
				                      .average()
				                      .orElse(0.0);
		
		System.out.println("Media dos corollas = " +mediaDosCorolas );
		
		List<Veiculo> listaCorola = lista.stream()
										 .filter(v -> v.getMarca().equalsIgnoreCase("Corolla"))
										 .map(v -> converterParaMaiusculo(v))
										 .toList();
		System.out.println(listaCorola);
											
	}
	
	public static Veiculo converterParaMaiusculo(Veiculo v) {
		return new Veiculo(v.getMarca().toUpperCase(),
				           v.getCor().toUpperCase(),
				           v.getPreco(),
				           v.getAno(),
				           v.getVelMaxima());
	}
}
