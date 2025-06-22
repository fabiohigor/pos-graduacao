import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainClass {
	public static void main(String[] args) {
		List<Produto> lista = new ArrayList<>();
		lista.add(new Produto(1,"Computador",1500.0));		
		lista.add(new Produto(2,"Mouse",50.0));
		lista.add(new Produto(3,"Teclado",100.0));
		lista.add(new Produto(1,"Computador",1500.0));
		lista.add(new Produto(1,"Computador",1500.0));
		System.out.println(lista);
		
		Set<Produto> conjunto = new HashSet<>();		
		conjunto.add(new Produto(1,"Computador",1500.0));
		conjunto.add(new Produto(1,"Computador",1500.0));  // daqui pra frente é ignorado
		conjunto.add(new Produto(1,"Computador",1500.0));
		conjunto.add(new Produto(1,"Computador",1500.0));
		conjunto.add(new Produto(1,"Computador",1500.0));				
		System.out.println(conjunto);
		
		Map<Integer, Produto> mapa = new HashMap<>();
		mapa.put(1, new Produto(1,"Computador",1500));
		mapa.put(2, new Produto(2,"Mouse",50.0));
		mapa.put(3, new Produto(3,"Teclado", 100.0));
		mapa.put(4, new Produto(1,"Computador",1500));
		mapa.put(1, new Produto(1,"Mesa",200.0));
		System.out.println(mapa);
		
		//benchmarkList(100000);
		benchmarkMapa(100000);
	}
	
	
	public static void benchmarkList(int tamanho) {
		List<Produto> lista = new ArrayList<>();
		for (int i=0;i<tamanho;i++) {
			lista.add(new Produto(i+1,"produto "+(i+1), (i+1)*10));			
		}
		
		int itemBusca = tamanho -1;
		
		long ini, fim;
		ini = System.currentTimeMillis();
		for (int count = 1; count <= 1000; count++) {
			for(Produto p: lista) {
				if (p.getId()==itemBusca)
					break;
			}
		}		
		fim = System.currentTimeMillis();
		
		System.out.println("Demorou "+(fim-ini)+"ms para a busca");
	}
	
	public static void benchmarkMapa(int tamanho) {
		Map<Integer, Produto> mapa = new HashMap<>();
		
		for (int i=0;i<tamanho;i++) {
			mapa.put(i+1, new Produto(i+1,"produto "+(i+1), (i+1)*10));
		}
		
		int itemBusca = tamanho -1;
		long ini, fim;
		ini = System.currentTimeMillis();
		for (int count=0;count<1000;count++) {
			if (mapa.get(itemBusca)!= null) {
				// codigo para achar
			}
		}
		fim = System.currentTimeMillis();
		System.out.println("Demorou "+(fim-ini)+"ms para a busca");
	}
}


