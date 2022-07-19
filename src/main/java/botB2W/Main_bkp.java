package botB2W;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import botB2W.model.submarino.pagamentos.B2WSuba;
import botB2W.model.submarino.pagamentos.Pagamento;

public class Main_bkp {

	public static void main(String[] args) {
		
		Document page;
		String url = "https://www.submarino.com.br/produto/1614132251";
		
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
		
		/*var result1 = json.getAsJsonObject().get("device").getAsString();
		
		System.out.println(result1);*/
		
		
				var result = json.getAsJsonObject().getAsJsonObject("entities")
						.getAsJsonObject("offers").getAsJsonArray("1614132251").get(0).getAsJsonObject();
		
				System.out.println(result);
				
				B2WSuba test = gson.fromJson(result, B2WSuba.class);
				
				System.out.println(test.getEmbedded().getSeller().getName());
				System.out.println(test.getEmbedded().getSeller().getId());
				
				List<Pagamento> pgto = new ArrayList<>();
				
				test.getPaymentOptions().forEach((key,value) -> {

					Pagamento t = gson.fromJson(value.toString(), Pagamento.class);
					t.setOrigem(key);
					
					pgto.add(t);
				});
				
				test.setPagamento(pgto);
				test.getPagamento().forEach(System.out::println);
				

	/*String element = gson.toJson(data.getProducts().get("1614132251"));
		
		System.out.println("data: " + element);
		WhatProduct data2 = gson.fromJson(element, WhatProduct.class);
	*/
	}

}
