package botB2W.model.submarino.pagamentos;

import com.google.gson.annotations.Expose;

public class Installments {
	private Double price;
	private Double value;
    @Expose(serialize = false, deserialize = false)
	private String campaign;
	
	public Installments() {
		// TODO Auto-generated constructor stub
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Installments [price=");
		builder.append(price);
		builder.append(", value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}

}
