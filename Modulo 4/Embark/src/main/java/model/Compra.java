package model;

public class Compra {
	private  int nota_fiscal;
	private  String  data_compra;
	private  String nome_cliente;
	private int quantidade_compra;
	private String destino ;
	private String valorCompra;
	
	
	public String getvalorCompra() {
		return valorCompra;
	}

	public void setvalorCompra(String valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Compra(int nota_fiscal, String data_compra, String nome_cliente, int quantidade_compra, String destino,
			int cpf_cliente, String valorCompra) {
		super();
		this.nota_fiscal = nota_fiscal;
		this.data_compra = data_compra;
		this.nome_cliente = nome_cliente;
		this.quantidade_compra = quantidade_compra;
		this.destino = destino;
		this.valorCompra = valorCompra;
	}
	
	public Compra() {
		
	}
			
	public int getnota_fiscal() {
		return nota_fiscal;
	}

	public void setnota_fiscal(int nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
	}

	
	public String getdata_compra() {
		return data_compra;
	}

	public void setdata_compra(String data_compra) {
		this.data_compra = data_compra;
	}
	
	
	public String getnome_cliente() {
		return nome_cliente;
	}

	public void setnome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	
	
	public int getquantidade_compra() {
		return quantidade_compra;
	}

	public void setquantidade_compra(int quantidade_compra) {
		this.quantidade_compra = quantidade_compra;
	}
	
	
	
	public String getdestino() {
		return destino;
	}

	public void setdestino(String destino) {
		this.destino = destino;
	}
}
