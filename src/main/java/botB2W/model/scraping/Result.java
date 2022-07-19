package botB2W.model.scraping;

public class Result {
	private BestPaymentOption bestPaymentOption;
	private String currency;

	public Result() {
		// TODO Auto-generated constructor stub
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BestPaymentOption getBestPaymentOption() {
		return bestPaymentOption;
	}

	public void setBestPaymentOption(BestPaymentOption bestPaymentOption) {
		this.bestPaymentOption = bestPaymentOption;
	}

}
