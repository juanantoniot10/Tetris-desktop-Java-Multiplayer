package acceso;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class DAO<T> {
	public T leer(String path) {
		return leer(path, 0);
	}

	public T leer(String path, int posicion) {
		assert path != null && posicion >= 0;
		T t = null;
		FileInputStream flujoR = abrir(path);
		if (flujoR != null) {
			try {
				ObjectInputStream adaptador = new ObjectInputStream(flujoR);
				for (int i = 0; i <= posicion; i++) {
					t = (T) adaptador.readObject();
				}
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
				t = null;
			}
			cerrarFlujo(flujoR);
		}
		return t;
	}

	public boolean grabar(String path, T t) {
		return grabar(path, t, false);
	}

	public boolean grabar(String path, T t, boolean adicion) {
		assert path != null && t != null;
		boolean retorno = true;
		if(!new File(path.substring(0,path.lastIndexOf('/'))).exists()) {
			new File(path.substring(0,path.lastIndexOf('/'))).mkdirs();
		}
		boolean existe = new File(path).exists() && adicion;
		FileOutputStream flujoW = abrir(path, adicion);
		try {
			ObjectOutputStream adaptador = null;
			if (existe) {
				adaptador = new MyObjectOutputStream(flujoW);
			} else {
				adaptador = new ObjectOutputStream(flujoW);
			}
			adaptador.writeObject(t);
		} catch (IOException e) {
			e.printStackTrace();
			retorno = false;
		}
		boolean cierreFalso = cerrarFlujo(flujoW);
		if (retorno)
			retorno = cierreFalso;
		return retorno;
	}

	private FileInputStream abrir(String path) {
		FileInputStream flujoR = null;
		File file = new File(path);
		try {
			if (file.exists()) {
				flujoR = new FileInputStream(path);
			}
		} catch (FileNotFoundException e) {
		}
		return flujoR;
	}

	private FileOutputStream abrir(String path, boolean adicion) {
		// no hay assert porque ya habria saltado en el public
		FileOutputStream flujoW = null;
		File file = new File(path);
		try {
			flujoW = new FileOutputStream(file, adicion);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return flujoW;

	}

	private boolean cerrarFlujo(Closeable closeable) {
		boolean retorno = true;
		try {
			closeable.close();
		} catch (IOException e) {
			retorno = false;
		}
		return retorno;
	}

	class MyObjectOutputStream extends ObjectOutputStream {

		public MyObjectOutputStream(OutputStream out) throws IOException {
			// quiero que se quede como esta
			super(out);
		}

		@Override
		protected void writeStreamHeader() throws IOException {
			// Este es el que escribe la cabecera
			/*
			 * La solucion pasa por eliminar la escritura de la cabecera para
			 * objetos de mi tipo
			 */
			// super.writeStreamHeader();
			// System.out.println("soy la otra");
		}
	}

	public void borrar(String rutaarchivo) {
		File file = new File(rutaarchivo);
		file.delete();
	}

	public boolean borrarElemtento(String pathDatos, Integer posicion) {
		int i = 0;
		boolean retorno=true;
		String rutaCopia = new String(pathDatos.substring(0, pathDatos.lastIndexOf('/')+1)+"copia");
		T t = leer(pathDatos, i);
		while (t != null) {
			if (i != posicion.intValue()) {
				grabar(rutaCopia, t, true);
			}
			i++;
			t = leer(pathDatos, i);
		}
		File original=new File(pathDatos);
		File copia = new File (rutaCopia);
		original.delete();
		copia.renameTo(original);
		return retorno;
	}
}