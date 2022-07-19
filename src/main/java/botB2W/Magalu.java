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

public class Magalu {

	public static void main(String[] args) {
		
		Document page;
		String url = "https://www.magazineluiza.com.br/iphone-11-apple-64gb-preto-61-12mp-ios/p/155610500/te/ip11/";
		
		String str = null;
		Gson gson = new Gson();
		try {
			System.out.println("entrou");
			// Get Document object after parsing the html from given url.
			
			
			page = Jsoup.connect(url).get();
			
			System.out.println(page);
			
			Pattern getJson = Pattern.compile("(?i)<script>\\n? {0,20}window.__PRELOADED_STATE__ = (.*)\\n? {0,20}<\\/script>");
			Matcher m = getJson.matcher(page.toString());
			
			if (m.find()) {
				
				str = m.group(1);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println(str);
		
/*
		JsonReader reader = new JsonReader(new StringReader(str));
		reader.setLenient(true);
		var json = JsonParser.parseReader(reader);

				var result = json.getAsJsonObject().getAsJsonObject("entities")
						.getAsJsonObject("offers").getAsJsonArray("1611315933").get(0).getAsJsonObject();
		
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
				
				System.out.println("id: " + test.getLinks().getProds().getId());
				test.setPagamento(pgto);
				test.getPagamento().forEach(System.out::println);*/
	}

}
