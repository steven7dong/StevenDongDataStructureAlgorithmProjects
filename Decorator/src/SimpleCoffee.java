public class SimpleCoffee implements Coffee{

    @Override
    public double getPrice(){
        return 1;
    }

    @Override
    public String getDescription(){
        return "Coffee";
    }
}