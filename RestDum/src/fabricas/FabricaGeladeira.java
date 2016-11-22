package fabricas;

import entidades.Geladeira;

public class FabricaGeladeira {

	
	private FabricaGeladeira(){
	}
	
	public static FabricaGeladeira nova(){
		return new FabricaGeladeira();
	}
	
	public Geladeira criarGeladeira(String marca, String modelo){
		return Geladeira.nova(marca, modelo);
	}
}
