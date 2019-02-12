public class Main {
    public static void printInfo(Coffee c){
        System.out.println("Cost: " + c.getPrice() + "; Ingredients: " + c.getDescription());
    }

    public static void main(String[] args) {
        Coffee c = new SimpleCoffee();
        printInfo(c);

        c = new WithMilk(c);
        printInfo(c);
    }


}
