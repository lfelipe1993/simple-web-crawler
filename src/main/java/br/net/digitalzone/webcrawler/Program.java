package br.net.digitalzone.webcrawler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import br.net.digitalzone.webcrawler.excel.ExcelGenerator;
import br.net.digitalzone.webcrawler.model.Produto;

public class Program {

	public static void main(String[] args) {
		List<String> urlHref = new ArrayList();
		List<Produto> produtos = new ArrayList();
		
		//url = URLEncoder.encode(url, StandardCharsets.UTF_8.toString());
		
		
		String url = setUrl();
		System.out.println("Carregando links a serem vasculhados...");
		//https://www.casasbahia.com.br/busca?q=iphone+11
		urlHref = GetUrlOnSearch(url);
		System.out.println("Carregando Dados dos produtos...");
		produtos = PriceAndName(urlHref);

		System.out.println("Gerando Excel com os dados...");
		ExcelGenerator.GerarExcel(produtos);
		System.out.println("Sucesso! Visite: www.digitalzone.net.br");
		
		//Teste();
		
		

	}

	private static List<String> GetUrlOnSearch(String urlForSearch) {
		Document page;
		List<String> urlHref = new ArrayList();

		try {
			// Get Document object after parsing the html from given url.
			page = Jsoup.connect(urlForSearch).get();

			List<String> links = page.select("div.nm-product-info > div.nm-product-name > a").stream()
					.map(l -> l.attr("href")).map(h -> h.replace("//", "http://")).collect(Collectors.toList());

			for (String s : links) {
				urlHref.add(s);
			}

			// urlHref.forEach(System.out::println);
		} catch (Exception e) {
			e.getMessage();
		}

		return urlHref;
	}

	private static List<Produto> PriceAndName(List<String> urlsForSearch) {
		Document page;
		List<Produto> produtos = new ArrayList<>();
		try {
			for (String url : urlsForSearch) {
				page = Jsoup.connect(url).get();

				String nomeProduto = page.select("div.produtoNome > h1 > b").text();
				String precoProduto = page.select("i.sale.price").text();
				String precoComDesconto = page.select("span.for.price.discount").text();

				produtos.add(new Produto(nomeProduto, precoProduto,precoComDesconto, url));
			} // end for

		} catch (Exception e) {
			e.getMessage();
		}
		//produtos.forEach(System.out::println);
		return produtos;
	}
	
	public static String setUrl() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Exemplo de entrada: https://www.casasbahia.com.br/busca?q=iphone+11");
		System.out.print("Entre com a url de pesquisa (Extra/Casas Bahia/Ponto frio):");
		String path = sc.nextLine();
		
		sc.close();
		
		return path;
	}

	private static void Teste() {
		Document page;
		List<Produto> produtos = new ArrayList<>();
		String url = "https://www.pontofrio.com.br/TelefoneseCelulares/Smartphones/iPhone/iphone-11-apple-com-256gb-tela-retina-hd-de-61-ios-13-dupla-camera-traseira-de-12-mp-resistente-a-agua-e-bateria-de-longa-duracao-branco-50004411.html?IdSku=50004411";

		try {
			System.out.println("entrou");
			// Get Document object after parsing the html from given url.
			page = Jsoup.connect(url).get();

			String one = "Produto: " + page.select("div.produtoNome > h1 > b").text();
			String two = "Preço Normal: " + page.select("i.sale.price").text();
			String three = "Preço com Desconto: " + page.select("span.for.price.discount").text();

			System.out.println("produto: " + one + " " + two + " " + three);

		} catch (Exception e) {
			e.getMessage();
		}
	}

}
