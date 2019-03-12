public class StockExchange {

    private RepurchaseModule repurchaseModule;

    private StockExchange(){
        repurchaseModule = new RepurchaseModule();
    }

    public static class LazyStockExchange{
        static final StockExchange _instance = new StockExchange();
    }

    public static StockExchange getInstance(){
        return LazyStockExchange._instance;

    }

    public void getRepos(){
        repurchaseModule.getAllEntitiesFromFile("/Users/cuteandsassy/Desktop/", "galatea.txt");
        repurchaseModule.display();
        repurchaseModule.test();
    }
}
