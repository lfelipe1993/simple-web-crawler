package botB2W.model.submarino.pagamentos;

public class Prods {
	private String id;
	
	public Prods() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Links [id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

}
