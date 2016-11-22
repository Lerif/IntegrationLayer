package rester;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entidades.Geladeira;
import servicos.ServicoGeladeira;

@Path("/prod")
public class Produtor {
	
	ServicoGeladeira servicoGeladeira = new ServicoGeladeira();

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello() {
		return "Hello Jerseys";
	}

	@GET
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Geladeira> getLoja(String marca, String modelo) {
		Geladeira g = Geladeira.nova(marca, modelo);
		g.setMarca("ops");
		g.setModelo("Ipiranga");
		
		servicoGeladeira.inserirGeladeira("a", "b");
		servicoGeladeira.inserirGeladeira("c", "d");
		servicoGeladeira.inserirGeladeira("e", "f");
		
		return servicoGeladeira.buscarTodasGeladeiras();
	}

	@POST
	@Path("/setar")
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes("application/x-www-form-urlencoded")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void setarLojas(@FormParam("marca")String marca, @FormParam("modelo") String modelo) {
		System.out.println("ma: " + marca);
		System.out.println("mo: " + modelo);
		servicoGeladeira.inserirGeladeira(marca, modelo);
		
		for(Geladeira gel : servicoGeladeira.buscarTodasGeladeiras()){
			System.out.println("mar: " + gel.getMarca());
			System.out.println("mod: " + gel.getModelo());
		}
	}

}
