package botB2W;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import botB2W.model.BestPrice;
import botB2W.model.submarino.pagamentos.B2WSuba;
import botB2W.model.submarino.pagamentos.Pagamento;

public class Main {

	public static void main(String[] args) {
		
		Document page;
		String url = "https://www.shoptime.com.br/produto/2290964000";
		
		String str = null;
		Gson gson = new Gson();
		try {
			System.out.println("entrou");
			// Get Document object after parsing the html from given url.
			page = Jsoup.connect(url).get();
			Pattern getJson = Pattern.compile("(?i)<script>\\n? {0,20}window.__PRELOADED_STATE__ = (.*)\\n? {0,20}<\\/script>");
			Matcher m = getJson.matcher(page.toString());
			
			if (m.find()) {
				
				str = m.group(1);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		JsonReader reader = new JsonReader(new StringReader(str));
		reader.setLenient(true);
		var json = JsonParser.parseReader(reader);

				var result = json.getAsJsonObject().getAsJsonObject("entities")
						.getAsJsonObject("offers").getAsJsonArray("2290964000").get(0).getAsJsonObject();
		
				System.out.println(result);
				
				B2WSuba test = gson.fromJson(result, B2WSuba.class);
				
				System.out.println(test.getEmbedded().getSeller().getName());
				System.out.println(test.getEmbedded().getSeller().getId());
				
				List<Pagamento> pgto = new ArrayList<>();
				
				test.getPaymentOptions().forEach((key,value) -> {

					Pagamento t = gson.fromJson(gson.toJson(value), Pagamento.class);
					t.setOrigem(key);
					
					pgto.add(t);
				});
				
				System.out.println("id: " + test.getLinks().getProds().getId());
				test.setPagamento(pgto);
				test.getPagamento().forEach(System.out::println);
				
				System.out.println(test.getPagamento().get(0).getInstallments().get(0).getValue());
				
				Map<String, Double[]> map = new HashMap<>();
				test.getPagamento().stream().forEach(x -> {
					Double[] db = new Double[2];

					if (x.getInstallments() != null && !x.getInstallments().isEmpty()
							&& x.getInstallments().get(0).getValue() < x.getPrice()) {
						db[0] = x.getInstallments().get(0).getValue();
					} else {
						db[0] = x.getPrice();
					}

					db[1] = x.getCashback().getValue();

					map.put(x.getOrigem(), db);
				});
				getBestPrice(map);
	}

	
	private static void getBestPrice(Map<String, Double[]> map) {

		BestPrice bestPrice = new BestPrice();

		map.forEach((key, value) -> {
			if (bestPrice.getKey() == null && bestPrice.getValor() == null) {
				bestPrice.setKey(key);
				bestPrice.setValor(value[0]);
				bestPrice.setCashback(value[1]);
			}

			value[0] = (value[0] == null) ? 0.0 : value[0];
			value[1] = (value[1] == null) ? 0.0 : value[1];

			if (bestPrice.getValor() > (value[0] - value[1])) {
				bestPrice.setKey(key);
				bestPrice.setValor(value[0]);
				bestPrice.setCashback(value[1]);
			}

		});

		System.out.println(bestPrice);
	}
}
