package servicos;

import java.util.List;

import entidades.Geladeira;
import fabricas.FabricaGeladeira;
import repositorio.RepositorioGeladeira;

public class ServicoGeladeira {
	
	static RepositorioGeladeira repositorioGeladeira = new RepositorioGeladeira();
	FabricaGeladeira fabricaGeladeira = FabricaGeladeira.nova();
	
	public Geladeira inserirGeladeira(String marca, String modelo){
		Geladeira geladeira = fabricaGeladeira.criarGeladeira(marca, modelo);
		repositorioGeladeira.inserirGeladeira(geladeira);
		return geladeira;
	}
	
	public Geladeira inserirGeladeiraDB(String marca, String modelo){
		Geladeira geladeira = fabricaGeladeira.criarGeladeira(marca, modelo);
		repositorioGeladeira.inserirGeladeiraBD(geladeira);
		return geladeira;
	}
	
	
	public List<Geladeira> buscarTodasGeladeiras(){
		return repositorioGeladeira.buscarTodasGeladeiras();
	}
	
	public List<Geladeira> buscarTodasGeladeirasDB(){
		return repositorioGeladeira.buscarTodasGeladeirasBD();
	}

}
