public abstract class CoffeeDecorator implements Coffee{

    protected final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee c){
        this.decoratedCoffee = c;
    }
    @Override
    public double getPrice(){
        return decoratedCoffee.getPrice();
    }
    @Override
    public String getDescription(){
        return decoratedCoffee.getDescription();
    }
}