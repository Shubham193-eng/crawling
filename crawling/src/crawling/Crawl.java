package crawling;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl {

	public static void main(String[] args) {
		try {
			String url = "https://www.forbes.com/lists/global2000/";

			Document doc = Jsoup.connect(url).get();

			System.out.println("Page Title: " + doc.title());

			Elements companyElements = doc.select("div.organizationName");
            
			for (Element company : companyElements) {
				String companyName = company.text();
				System.out.println("Company: " + companyName);

				Element countryElement = company.nextElementSibling();
				if (countryElement != null) {
					String countryName = countryElement.text();
					System.out.println("Country: " + countryName);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
