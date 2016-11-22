package repositorio;

import java.util.ArrayList;
import java.util.List;

import entidades.Geladeira;

public class RepositorioGeladeira {

	List<Geladeira> geladeiras = new ArrayList<>();
	
	public RepositorioGeladeira(){
		
	}
	
	public boolean inserirGeladeira (Geladeira geladeira){
		if(geladeiras.add(geladeira)){
			return true;
		}
		return false;
	}
	
	public List<Geladeira> buscarTodasGeladeiras(){
		return geladeiras;
	}
}