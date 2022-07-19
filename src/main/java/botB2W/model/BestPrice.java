package botB2W.model;

public class BestPrice {
	private String key;
	private Double valor;
	private Double cashback;

	public BestPrice() {
		// TODO Auto-generated constructor stub
	}
	
	public BestPrice(String key, Double valor) {
		super();
		this.key = key;
		this.valor = valor;
	}
	
	public BestPrice(String key, Double valor,Double cashback) {
		super();
		this.key = key;
		this.valor = valor;
		this.cashback = cashback;
	}



	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Double getCashback() {
		return cashback;
	}

	public void setCashback(Double cashback) {
		this.cashback = cashback;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BestPrice [key=");
		builder.append(key);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", cashback=");
		builder.append(cashback);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
