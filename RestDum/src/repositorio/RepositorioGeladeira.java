package repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidades.Geladeira;
import fabricas.FabricaGeladeira;

public class RepositorioGeladeira {

	List<Geladeira> geladeiras = new ArrayList<>();
	Connection conexao;

	public RepositorioGeladeira() {
		this.conexao = new ConexaoDB().conectarDB();
	}

	public boolean inserirGeladeira(Geladeira geladeira) {
		if (geladeiras.add(geladeira)) {
			//inserirGeladeira(geladeira);
			return true;
		}
		return false;
	}

	public Geladeira inserirGeladeiraBD(Geladeira geladeira) {

		final StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_geladeira ");
		sql.append("(marca, modelo)");
		sql.append("VALUES(?, ?)");

		PreparedStatement pst = null;

		try {
			pst = conexao.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			pst.setString(1, geladeira.getMarca());
			pst.setString(2, geladeira.getModelo());
			pst.execute();

		} catch (Exception e) {
			System.err.println("[RepoGel]Error: " + e);
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return geladeira;
	}
	
	public List<Geladeira> buscarTodasGeladeirasBD(){
		List<Geladeira> geladeiras = new ArrayList<Geladeira>();

		String sql = "SELECT * FROM tb_geladeira";

		Statement stm; 
		try {
			stm = (Statement) conexao.createStatement();
			ResultSet retornoSelect = stm.executeQuery(sql);
			while (retornoSelect.next()) {
				geladeiras.add(FabricaGeladeira.nova().criarGeladeira(retornoSelect.getString("marca"), retornoSelect.getString("modelo")));
			}
		} catch (Exception e) {
			System.err.println("[RepoGE]Error: " + e);
		}
		return geladeiras;
	}

	public List<Geladeira> buscarTodasGeladeiras() {
		return geladeiras;
	}
}