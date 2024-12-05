import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a game you want to play:");
        System.out.println("1. God of War: Rangnarork ");
        System.out.println("2. Fortnite");
        System.out.println("3. Call of Duty: Warzone");
        System.out.println("4. Stalker 2");
        System.out.println("5. MechWarrior 5: Clans");


        int choice = scanner.nextInt();
        ArrayList<WebCrawler> bots = new ArrayList<>();

        switch (choice) {
            case 1:
                System.out.println("Fetching recommendations for God of War: Rangnarork");
                //CPU links

                bots.add(new WebCrawler("https://www.amazon.com/s?k=CPU+core+i5+8600&crid=R4KBBQM5WUOA&sprefix=cpu+core+i5+8600%2Caps%2C100&ref=nb_sb_noss", 1));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=CPU+core+i5+8600", 2));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=CPU+core+i5+8600&searchButton=search",3));
                //GPU links
                bots.add(new WebCrawler("https://www.amazon.com/s?k=GPU+RTX+2060&ref=nb_sb_noss",4));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=GPU+RTX+2060",5));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=GPU+RTX+2060&searchButton=search",6));
                WebCrawler.findCheapestCPU();
                WebCrawler.findCheapestGPU();
                break;
            case 2:
                System.out.println("Fetching recommendations for Fortnite...");
                //CPU links
                bots.add(new WebCrawler("https://www.amazon.com/s?k=CPU+-+Core+i5&crid=A3AMMF0E73K4&sprefix=cpu+-+core+i5%2Caps%2C161&ref=nb_sb_noss_2", 7));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=CPU+-+Core+i5", 8));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=4294966995+4294820689+4294820179&rd=1&vkw=core+i5",9));
                //GPU links
                bots.add(new WebCrawler("https://www.amazon.com/s?k=GPU+GTX+960&crid=18LIE34B6XBYF&sprefix=gpu+gtx+960%2Caps%2C191&ref=nb_sb_noss_1",10));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=GPU+GTX+960",11));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=GPU+GTX+960&searchButton=search",12));
                WebCrawler.findCheapestCPU();
                WebCrawler.findCheapestGPU();
                break;
            case 3:
                System.out.println("Fetching recommendations for Call of Duty: Warzone...");
                bots.add(new WebCrawler("https://www.amazon.com/s?k=CPU+core+i5&crid=1BE4UOC8QCCFF&sprefix=cpu+core+i5%2Caps%2C128&ref=nb_sb_noss_1", 13));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=CPU+core+i5", 14));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=CPU+core+i5&searchButton=search",15));
                //GPU links
                bots.add(new WebCrawler("https://www.amazon.com/s?k=GPU+GTX+960&crid=Z96FSGW7C5IK&sprefix=gpu+gtx+960%2Caps%2C108&ref=nb_sb_noss_1",16));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=GPU+GTX+960",17));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=GPU+GTX+960&searchButton=search",18));
                WebCrawler.findCheapestCPU();
                WebCrawler.findCheapestGPU();
                break;
            case 4:
                System.out.println("Fetching recommendations for Stalker 2");
                bots.add(new WebCrawler("https://www.amazon.com/s?k=CPU+core+i7&crid=2EV3BR5DR7NLW&sprefix=cpu+core+i7%2Caps%2C116&ref=nb_sb_noss_1", 19));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=CPU+core+i7", 20));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=CPU+core+i7&searchButton=search",21));
                //GPU links
                bots.add(new WebCrawler("https://www.amazon.com/s?k=GPU+RTX+4070&crid=2U50DLOREKUXS&sprefix=gpu+rtx+4070%2Caps%2C126&ref=nb_sb_noss_1",22));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=GPU+RTX+4070",23));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=GPU+RTX+4070&searchButton=search",24));
                WebCrawler.findCheapestCPU();
                WebCrawler.findCheapestGPU();
                break;
            case 5:
                System.out.println("Fetching recommendations for MechWarrior 5: Clans");
                bots.add(new WebCrawler("https://www.amazon.com/s?k=CPU+core+i5&crid=1BE4UOC8QCCFF&sprefix=cpu+core+i5%2Caps%2C128&ref=nb_sb_noss_1", 13));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=CPU+core+i5", 14));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=CPU+core+i5&searchButton=search",15));
                //GPU links
                bots.add(new WebCrawler("https://www.amazon.com/s?k=GPU+RTX+2080&crid=2PXYY6N46PKZL&sprefix=gpu+rtx+2080%2Caps%2C115&ref=nb_sb_noss_1",28));
                bots.add(new WebCrawler("https://www.walmart.com/search?q=GPU+RTX+2080",29));
                bots.add(new WebCrawler("https://www.microcenter.com/search/search_results.aspx?N=&cat=&Ntt=GPU+RTX+2080&searchButton=search",30));
                WebCrawler.findCheapestCPU();
                WebCrawler.findCheapestGPU();
                break;


            default:
                System.out.println("Invalid choice!");
                return;
        }

        for (WebCrawler bot : bots) {
            try {
                bot.getThread1().join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


