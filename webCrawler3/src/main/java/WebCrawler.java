import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WebCrawler implements Runnable {
    private static final int max_Depth = 3; //limits the depth of crawling process
    private final Thread thread1; //thread object
    private final String link;// link to be crawled
    private final ArrayList<String> visited_Links = new ArrayList<>();
    private final int id;

    // HashMaps to store CPU and GPU prices
    private static final HashMap<String, Double> CPUPrices = new HashMap<>();
    private static final HashMap<String, Double> GPUPrices = new HashMap<>();
    //Constructor
    // also starts the thread for crawling
    public WebCrawler(String url, int ID) {
        System.out.println("WebCrawler for Bot ID = " + ID);
        this.link = url;
        this.id = ID;
        this.thread1 = new Thread(this);
        thread1.start();
    }

    @Override
    public void run() {
        crawl(link);     //
    }
    //prevents revisiting URLs and checks depth
    private void crawl(String url) {
        if (1 <= max_Depth && !visited_Links.contains(url)) {
            Document doc = request(url);
            if (doc != null) {
                if (url.contains("CPU")) {
                    parseCPUs(doc);
                    parseCPUsWalmart(doc);
                    amazonCPUs(doc);
                } else if (url.contains("GPU")) {
                    parseGPUs(doc);
                    parseGPUsWalmart(doc);
                    amazonGPUs(doc);
                }
            }
            visited_Links.add(url);
        }
    }
    //uses jsoup to connect to a webpage and retrieve its HTML
    private Document request(String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36")
                    .get();
            System.out.println("Bot ID: " + id + " Retrieved: " + url);
            return doc;
        } catch (IOException e) {
            System.err.println("Cannot fetch URL: " + url);
            return null;
        }
    }

    private void parseCPUs(Document doc) {
        Elements products = doc.select(".product_wrapper");

        for (Element product : products) {
            String name = product.select("a").attr("data-name");
            String priceText = product.select("div.price").text();
            double price = parsePrice(priceText);

            if (!name.isEmpty() && price > 0) {
                CPUPrices.put(name, price);
                System.out.println("MicroCenter CPU: " + name);
                System.out.println("price: "+ price);
            }
        }}
    private void parseGPUs(Document doc) {
        Elements products = doc.select(".product_wrapper");

        for (Element product : products) {
            String name = product.select("a").attr("data-name");
            String priceText = product.select("div.price").text();
            double price = parsePrice(priceText);

            if (!name.isEmpty() && price > 0) {
                GPUPrices.put(name, price);
                System.out.println("MicroCenter GPU: " + name);
                System.out.println("price: "+ price);

            }
        }
    }
    private void parseCPUsWalmart(Document doc) {
        Elements products = doc.select("div[data-item-id]");

        for (Element product : products) {
            // Extract the product name
            Element nameElement = product.selectFirst("span.w_iUH7");
            String name = nameElement != null ? nameElement.text() : "N/A";

            // Extract the product price
            Element priceElement = product.selectFirst("div[data-automation-id=product-price] .f2");
            String priceText = priceElement != null ? priceElement.text() : "";
            double price = parsePrice(priceText);

            if (!name.isEmpty() && price > 0) {
                CPUPrices.put(name, price);
                System.out.println("Walmart CPU: " + name);
                System.out.println("price: "+ price);

            }
        }
    }
    private void parseGPUsWalmart(Document doc) {
        Elements products = doc.select("div[data-item-id]");

        for (Element product : products) {
            // Extract the product name
            Element nameElement = product.selectFirst("span.w_iUH7");
            String name = nameElement != null ? nameElement.text() : "N/A";

            // Extract the product price
            Element priceElement = product.selectFirst("div[data-automation-id=product-price] .f2");
            String priceText = priceElement != null ? priceElement.text() : "";
            double price = parsePrice(priceText);

            if (!name.isEmpty() && price > 0) {
                GPUPrices.put(name, price);
                System.out.println("Walmart GPU: " + name);
                System.out.println("price: "+ price);

            }
        }
    }
    private void amazonCPUs(Document doc) {
        Elements products = doc.select(".s-main-slot .s-result-item");

        for (Element product : products) {
            // Get the name of the CPU
            String name = product.select("span.a-text-normal").text();

            // Get the price of the CPU
            String priceText = product.select("span.a-price-whole").text();
            double price = parsePrice(priceText);

            // Ensure both name and price are valid before saving
            if (!name.isEmpty() && price > 0) {
                CPUPrices.put(name, price);
                System.out.println("Amazon CPU: " + name);
                System.out.println("price: "+ price);

            }
        }
    }
    private void amazonGPUs(Document doc) {Elements products = doc.select(".s-main-slot .s-result-item");

        for (Element product : products) {
            // Get the name of the CPU
            String name = product.select("span.a-text-normal").text();

            // Get the price of the CPU
            String priceText = product.select("span.a-price-whole").text();
            double price = parsePrice(priceText);

            // Ensure both name and price are valid before saving
            if (!name.isEmpty() && price > 0) {
                CPUPrices.put(name, price);
                System.out.println("Amazon GPU: " + name);
                System.out.println("price: "+ price);

            }
        }
    }
    //The parsePrice() method cleans price strings
    // (removing symbols) and converts them to double.
    private double parsePrice(String priceText) {
        try {
            return Double.parseDouble(priceText.replaceAll("[^\\d.]", ""));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static Map<String, Double> getCpuPrices() {
        return CPUPrices;
    }

    public static Map<String, Double> getGPUPrices() {
        return GPUPrices;
    }
    // Find the cheapest CPU
    public static void findCheapestCPU() {
        String cheapestCPU = null;
        double lowestPrice = Double.MAX_VALUE;

        for (Map.Entry<String, Double> entry : CPUPrices.entrySet()) {
            if (entry.getValue() < lowestPrice) {
                lowestPrice = entry.getValue();
                cheapestCPU = entry.getKey();
            }
        }

        if (cheapestCPU != null) {
            System.out.println("Cheapest CPU: " + cheapestCPU + " - Price: $" + lowestPrice);
        } else {
            System.out.println("No CPUs found!");
        }
    }

    // Find the cheapest GPU
    public static void findCheapestGPU() {
        String cheapestGPU = null;
        double lowestPrice = Double.MAX_VALUE;

        for (Map.Entry<String, Double> entry : GPUPrices.entrySet()) {
            if (entry.getValue() < lowestPrice) {
                lowestPrice = entry.getValue();
                cheapestGPU = entry.getKey();
            }
        }

        if (cheapestGPU != null) {
            System.out.println("Cheapest GPU: " + cheapestGPU + " - Price: $" + lowestPrice);
        } else {
            System.out.println("No GPUs found!");
        }
    }

    public Thread getThread1() {
        return thread1;

}
}


