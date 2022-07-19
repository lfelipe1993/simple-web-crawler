package botB2W.model.submarino.pagamentos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class B2WSuba {
	Map<String, Object> paymentOptions = new HashMap<String, Object>();
	
	@SerializedName("_embedded")
	private Embedded embedded;
	
	private List<Pagamento> pagamento;
	
	@SerializedName("_links")
	private Links links;

	public B2WSuba() {
		// TODO Auto-generated constructor stub
	}
	
	public Map<String, Object> getPaymentOptions() {
		return paymentOptions;
	}

	public void setPaymentOptions(Map<String, Object> paymentOptions) {
		this.paymentOptions = paymentOptions;
	}

	public Embedded getEmbedded() {
		return embedded;
	}

	public void setEmbedded(Embedded embedded) {
		this.embedded = embedded;
	}

	public List<Pagamento> getPagamento() {
		return pagamento;
	}

	public void setPagamento(List<Pagamento> pagamento) {
		this.pagamento = pagamento;
	}

	public Links getLinks() {
		return links;
	}

	public void setLinks(Links links) {
		this.links = links;
	}
	
}

