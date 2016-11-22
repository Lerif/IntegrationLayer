package entidades;

public class Geladeira {

	private String marca;
	private String modelo;
	
	private Geladeira(String marca, String modelo){
		this.marca = marca;
		this.modelo = modelo;
	}
	
	public static Geladeira nova(String marca, String modelo){
		return new Geladeira(marca, modelo);
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
