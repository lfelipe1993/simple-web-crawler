package botB2W.model.lista;

import java.util.List;

public class Listagem {
	private List<Products> products;
	
	public Listagem() {
		// TODO Auto-generated constructor stub
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(products);
		return builder.toString();
	}
	
}
