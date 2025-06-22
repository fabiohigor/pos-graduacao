import java.io.BufferedWriter;
import java.io.FileWriter;

public class MainClass {
	public static void main(String[] args)  {
		String fileName = "benchmark.txt";
		String linhaBase = "Esta eh uma linha de exemplo para benchmark de leitura de arquivos\n";
		long tamanho = 100L * 1024 * 1024;
		
		try {
			long tamanhoAtual = 0;
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			while (tamanhoAtual < tamanho) {
				writer.write(linhaBase);
				tamanhoAtual += linhaBase.getBytes().length;
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
