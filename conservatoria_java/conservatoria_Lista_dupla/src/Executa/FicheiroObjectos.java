package executa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FicheiroObjectos {
	
	// serializar: gravar o objecto no ficheiro "nomeFich"
	public static void gravarFicheiroObjecto(ArrayList<Object> lista, String nomeFich) {
		File ficheiro = new File(nomeFich);
		try {
			
			ficheiro.delete();
			ficheiro.createNewFile();
			ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(ficheiro));
			objOutput.writeObject(lista);
			objOutput.close();
			
			
			
			
		} catch (IOException erro) {
			System.out.printf("Erro: %s",  erro.getMessage());
		}
		
		
	}
	
	// desserializar: recuperar objectos gravados no ficheiro nomeFich
	public static ArrayList<Object> lerFicheiroObjectos(String nomeFich){
		
		ArrayList<Object> lista = new ArrayList<>();
		try {
			File ficheiro = new File(nomeFich);
			if(ficheiro.exists()) {
				
				ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(ficheiro));
				lista = (ArrayList<Object>)objectInput.readObject();
				objectInput.close();
			}
		} catch (IOException erro1) {
			System.out.printf("Erro: %s",  erro1.getMessage());
		}
		catch (ClassNotFoundException erro2) {
			System.out.printf("Erro: %s",  erro2.getMessage());
		}
		
		return (lista);
		
	}
	

}
