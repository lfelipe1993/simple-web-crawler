package botB2W.model.scraping;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BestPaymentOption {
	private String type;
	private Double price;
	@SerializedName("cashback")
	private CashBack cashBack;
	
	List<MinQuantity> minQuantity;
	
	public BestPaymentOption() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<MinQuantity> getMinQuantity() {
		return minQuantity;
	}

	public void setMinQuantity(List<MinQuantity> minQuantity) {
		this.minQuantity = minQuantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public CashBack getCashBack() {
		return cashBack;
	}

	public void setCashBack(CashBack cashBack) {
		this.cashBack = cashBack;
	}
	
	
}
