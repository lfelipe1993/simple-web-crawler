package botB2W.model.submarino.pagamentos;

import java.util.List;

public class Pagamento {
	
	private String pricingId;
	private Double price;
	private String points;
	private Cashback cashback;
	private String origem;
	
	private List<Installments> installments;
	
	public Pagamento() {
		// TODO Auto-generated constructor stub
	}
	
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	public Cashback getCashback() {
		return cashback;
	}

	public void setCashback(Cashback cashback) {
		this.cashback = cashback;
	}
	
	public String getPricingId() {
		return pricingId;
	}

	public void setPricingId(String pricingId) {
		this.pricingId = pricingId;
	}

	public List<Installments> getInstallments() {
		return installments;
	}

	public void setInstallments(List<Installments> installments) {
		this.installments = installments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pagamento [origem=");
		builder.append(origem);
		builder.append(", price=");
		builder.append(price);
		builder.append(", cashback=");
		builder.append(cashback);
		builder.append("]");
		return builder.toString();
	}

}
