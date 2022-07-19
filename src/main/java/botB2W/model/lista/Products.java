package botB2W.model.lista;

import java.util.regex.Pattern;

public class Products {
	private String id;
	private String name;
	
	public Products() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getModelo() {
		Pattern i7 = Pattern.compile("(?i)\\b(?:iphone 7)\\b");
		Pattern i7P = Pattern.compile("(?i)\\b(?:iphone 7 Plus)\\b");
		Pattern i8 = Pattern.compile("(?i)\\b(?:iphone 8)\\b");
		Pattern i8P = Pattern.compile("(?i)\\b(?:iphone 8 Plus)\\b");
		Pattern iSE = Pattern.compile("(?i)\\b(?:iphone SE)\\b");
		Pattern iXR = Pattern.compile("(?i)\\b(?:iphone XR)\\b");
		Pattern i11 = Pattern.compile("(?i)\\b(?:iphone 11)\\b");
		Pattern i12 = Pattern.compile("(?i)\\b(?:iphone 12)\\b(?!.*mini)");
		Pattern i12P = Pattern.compile("(?i)\\b(?:iphone 12 Pro)\\b");
		Pattern i12PM = Pattern.compile("(?i)\\b(?:iphone 12 Pro Max)\\b");

		try {
			if (i7.matcher(this.name).find()) {
				return "7";
			}else if (i7P.matcher(this.name).find()) {
				return "7P";
			}else if (i8.matcher(this.name).find()) {
				return "8";
			}else if (i8P.matcher(this.name).find()) {
				return "8P";
			}else if (iSE.matcher(this.name).find()) {
				return "SE";
			} else if (iXR.matcher(this.name).find()) {
				return "XR";
			} else if (i11.matcher(this.name).find()) {
				return "11";
			} else if (i12.matcher(this.name).find()) {
				return "12";
			} else if (i12P.matcher(this.name).find()) {
				return "12P";
			} else if (i12PM.matcher(this.name).find()) {
				return "12PM";
			}

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
	
	public String getArmaz() {
		Pattern p16GB = Pattern.compile("(?i)\\b(?:16|16GB)\\b");
		Pattern p32GB = Pattern.compile("(?i)\\b(?:32|32B)\\b");
		Pattern p64GB = Pattern.compile("(?i)\\b(?:64|64GB)\\b");
		Pattern p128GB = Pattern.compile("(?i)\\b(?:128|128GB)\\b");
		Pattern p256GB = Pattern.compile("(?i)\\b(?:256|256GB)\\b");
		Pattern p512GB = Pattern.compile("(?i)\\b(?:512|512GB)\\b");

		try {
			if (p16GB.matcher(this.name).find()) {
				return "16";
			}else if (p32GB.matcher(this.name).find()) {
				return "32";
			}else if (p64GB.matcher(this.name).find()) {
				return "64";
			} else if (p128GB.matcher(this.name).find()) {
				return "128";
			} else if (p256GB.matcher(this.name).find()) {
				return "256";
			} else if (p512GB.matcher(this.name).find()) {
				return "512";
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append("]\n");
		return builder.toString();
	}
	
}
