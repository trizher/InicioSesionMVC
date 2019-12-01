package dad.javafx.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LectorCSV {

	private final  String PATH = "src/main/resources/users.csv";
	private String separador = ",";
	
	public Map<String, String> leerCSV() throws IOException {
		BufferedReader bufferLectura = new BufferedReader(new FileReader(this.PATH));
		String linea = bufferLectura.readLine();
		ArrayList<String> contenidoCSV = new ArrayList<String>();
		while (linea != null) {
			contenidoCSV.add(linea);
			linea = bufferLectura.readLine();
		}

		Map<String, String> contenidoCSVMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < contenidoCSV.size(); i++) {
			contenidoCSVMap.put(contenidoCSV.get(i).split(this.separador)[0],
					contenidoCSV.get(i).split(this.separador)[1]);
		}

		if (bufferLectura != null) {
			bufferLectura.close();
		}
		return contenidoCSVMap;
	}

	public boolean buscarValoresCSV(Map<String, String> mapa, String usuario, String pass) {
		boolean ret = false;
		Iterator<String> it = mapa.keySet().iterator();
		while (it.hasNext() && !ret) {
			String key = (String) it.next();
			if (usuario.equals(key) && pass.equals(mapa.get(key))) {
				ret = true;
			}
			
		}

		return ret;
	}
}
