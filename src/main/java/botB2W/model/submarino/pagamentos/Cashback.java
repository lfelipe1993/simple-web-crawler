package botB2W.model.submarino.pagamentos;

public class Cashback {
	private Double value;
	
	public Cashback() {
		// TODO Auto-generated constructor stub
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
		builder.append("Cashback [value=");
		builder.append(value);
		builder.append("]");
		return builder.toString();
	}
	
	
}
