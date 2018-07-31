package almacenes;

import java.util.NavigableSet;
import acceso.DAO;
import modelo.Jugador;

public class AlmacenIndividualSet<T> {
	private NavigableSet<T> conjunto;
	private String path;
	private DAO<NavigableSet<T>> dao;

	public AlmacenIndividualSet(NavigableSet<T> set, String path) {
		super();
		this.conjunto = set;
		this.path = path;
		dao = new DAO<>();
	}

	public T first() {
		getSet();
		T retorno=null;
		try{
			retorno=conjunto.first();
		}catch(Exception e){
			
		}
		return  retorno;
	}
	public T last(){
		getSet();
		return conjunto.last();
	}
	
	public T obtener(int index){
		assert index>=0;
		T t=null;
		getSet();
		if(index<conjunto.size()){
			t=(T) conjunto.toArray()[index];
		}
		return t;
	}

	public boolean grabar(T t) {
		assert t!=null;
		boolean retorno = false;
		getSet();
		if (conjunto.add(t) && dao.grabar(path, conjunto)) {
			retorno = true;
		}
		getSet();
		return retorno;
	}

	private void getSet() {
		NavigableSet<T> temporal = dao.leer(path);
		if (temporal == null) {			
			dao.grabar(path, conjunto);
		}else{
			conjunto=temporal;
		}
	}

	public boolean borrar(Jugador jugador) {
		boolean retorno = false;
		T t=null;
		getSet();
		if(jugador.getIdJugador()<conjunto.size()){
			conjunto.remove(jugador);
			for (int i = 0; i < conjunto.size(); i++) {
				t=(T)conjunto.toArray()[jugador.getIdJugador()];
				if(((Jugador)t).getIdJugador()>jugador.getIdJugador()) {
					((Jugador)t).setIdJugador(i-1);
					retorno= true;
				}
			}
			dao.grabar(path, conjunto);
		}
		return retorno;
	}

	public int obtenerTotalJugadores() {
		getSet();
		return conjunto.size();
	}
}
