package rester;

import java.io.InputStream;
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
	@Path("/buscar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Geladeira> getLoja(String marca, String modelo) {
		//return servicoGeladeira.buscarTodasGeladeiras();
		return servicoGeladeira.buscarTodasGeladeirasDB();
	}

	@POST
	@Path("/setar")
	@Consumes(MediaType.APPLICATION_JSON)
	public void setarLojas(InputStream json) {
		
		//servicoGeladeira.inserirGeladeira(marca, modelo);
	}
	
	
	@POST
	@Path("/setar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public void setarLojas(@FormParam("marca")String marca, @FormParam("modelo") String modelo) {
		//servicoGeladeira.inserirGeladeira(marca, modelo);
		servicoGeladeira.inserirGeladeiraDB(marca, modelo);
	}

}
