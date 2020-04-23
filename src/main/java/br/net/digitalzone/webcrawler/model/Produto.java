package br.net.digitalzone.webcrawler.model;

public class Produto {
	private String nomeProduto;
	private String preco;
	private String precoComDesconto;
	private String hrefUrl;
	
	
	public Produto(String nomeProduto, String preco,String precoComDesconto, String hrefUrl) {
		this.nomeProduto = nomeProduto;
		this.preco = preco;
		this.precoComDesconto = precoComDesconto;
		this.hrefUrl = hrefUrl;
	}

	

	public String getNomeProduto() {
		return nomeProduto;
	}



	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}



	public String getPreco() {
		return preco;
	}



	public void setPreco(String preco) {
		this.preco = preco;
	}



	public String getPrecoComDesconto() {
		return precoComDesconto;
	}



	public void setPrecoComDesconto(String precoComDesconto) {
		this.precoComDesconto = precoComDesconto;
	}



	public String getHrefUrl() {
		return hrefUrl;
	}



	public void setHrefUrl(String hrefUrl) {
		this.hrefUrl = hrefUrl;
	}



	@Override
	public String toString() {
		return "Produto [nomeProduto=" + nomeProduto + ", preco=" + preco + ", precoComDesconto=" + precoComDesconto
				+ ", hrefUrl=" + hrefUrl + "]";
	}


	
}
