package botB2W;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import botB2W.model.B2W;
import botB2W.model.lista.Listagem;
import botB2W.model.scraping.WhatProduct;
import botB2W.model.submarino.SubMarino;

public class Program {

	static WhatProduct whatProduct = new WhatProduct();

	public static void main(String[] args) {

		Document page;
		String url = "https://www.americanas.com.br/produto/338918556";

		Gson gson = new Gson();
		B2W data = new B2W();
		try {
			System.out.println("entrou");
			// Get Document object after parsing the html from given url.
			page = Jsoup.connect(url).get();

			Pattern getJson = Pattern
					.compile("(?i)<script>\\n? {0,20}window.__PRELOADED_STATE__ = (.*)\\n? {0,20}<\\/script>");
			Matcher m = getJson.matcher(page.toString());

			if (m.find()) {

				data = gson.fromJson(m.group(1), B2W.class);
				System.out.println(m.group(1));
			}

		} catch (Exception e) {
			e.getMessage();
		}

		String element = gson.toJson(data.getProducts().get("338918556"));

		// System.out.println("data: " + element);
		WhatProduct data2 = gson.fromJson(element, WhatProduct.class);

		try {

			if (data2.getSkus().get(0).getOffers().getResult().get(0).getBestPaymentOption().getMinQuantity().isEmpty()) {
				System.out.println(
						data2.getSkus().get(0).getOffers().getResult().get(0).getBestPaymentOption().getPrice());
				System.out.println(data2.getSkus().get(0).getOffers().getResult().get(0).getBestPaymentOption()
						.getCashBack().getValue());
			} else {
				System.out.println(data2.getSkus().get(0).getOffers().getResult().get(0).getBestPaymentOption()
						.getMinQuantity().get(0).getValue());
				System.out.println(data2.getSkus().get(0).getOffers().getResult().get(0).getBestPaymentOption()
						.getMinQuantity().get(0).getCashback().getValue());
			}

			
		} catch (

		IndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}

	}

	// public static String URL =
	// "https://mystique-v2-americanas.juno.b2w.io/search?sortBy=rating&source=blanca&filter=%7B%22id%22%3A%22category.id%22%2C%22value%22%3A%22229187%22%2C%22fixed%22%3Atrue%7D&filter=%7B%22id%22%3A%22tag%22%2C%22value%22%3A%22tag_iphone11all_acom%22%2C%22fixed%22%3Afalse%7D&limit=100&suggestion=true&testab=searchTestAB%3Dout";
	public static String URL = "https://mystique-v2-americanas.juno.b2w.io/search?sortBy=higherPrice&source=blanca&filter={%22id%22:%22condicao%22,%22value%22:%22novo%22}&filter={%22id%22:%22category.id%22,%22value%22:%22229187%22,%22fixed%22:true}"
			+ "&filter={%22id%22:%22product_feature_marca%22,%22value%22:%22apple%22}&filter={%22id%22:%22loja%22,%22value%22:%22Americanas.com%22,%22fixed%22:false}&filter={%22id%22:%22content%22,%22value%22:%22iphone%2011%22,%22fixed%22:false}&limit=162&suggestion=true&testab=searchTestAB=old";

	static Listagem listagem = new Listagem();

	public static void main2(String[] args) {
		try {
			listagem = json2JavaObjectListViaVarejo(URL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		listagem.getProducts().forEach(x -> {
			System.out.println("[" + x.getModelo() + "-" + x.getArmaz() + "] " + x.getName());
		});
	}

	public static Listagem json2JavaObjectListViaVarejo(String url) throws IOException {

		String response = Jsoup.connect(url).ignoreContentType(true).execute().body();

		Gson gson = new Gson();
		return gson.fromJson(response, Listagem.class);
	}

}
