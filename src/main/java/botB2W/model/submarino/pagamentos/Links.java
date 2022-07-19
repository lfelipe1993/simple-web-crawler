package botB2W.model.submarino.pagamentos;

import com.google.gson.annotations.SerializedName;

public class Links {
	@SerializedName("product")
	private Prods prods;
	
	public Links() {
		// TODO Auto-generated constructor stub
	}

	public Prods getProds() {
		return prods;
	}

	public void setProds(Prods prods) {
		this.prods = prods;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Links [prods=");
		builder.append(prods);
		builder.append("]");
		return builder.toString();
	}

}
