public class WithMilk extends CoffeeDecorator {

    public WithMilk(Coffee c){
        super(c);
    }

    @Override
    public double getPrice(){
        return super.getPrice() + 0.5;
    }
    @Override
    public String getDescription(){
        return super.getDescription() + " and Milk";
    }

}
