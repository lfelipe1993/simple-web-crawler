package botB2W.model.scraping;

import java.util.List;

public class WhatProduct {
	private String name;
	
	private List<Skus> skus;
	
	public WhatProduct() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Skus> getSkus() {
		return skus;
	}

	public void setSkus(List<Skus> skus) {
		this.skus = skus;
	}



}
