import java.util.ArrayList;
import java.util.List;

interface menuitems{
    public void showdetails();
    public int getprize();
};

class menuindividual implements menuitems{
    private String name;
    private int prize;
    
    public menuindividual(String name,int prize){
        this.name=name;
        this.prize=prize;
    }
    @Override
    public void showdetails(){
        System.out.println(name + "rs"+prize);
    };
    @Override
    public int getprize(){
        return prize;
    };

};

class menucomposition implements menuitems{
    private String name;
    private List<menuitems>meal=new ArrayList<>();

    public menucomposition(String name){
        this.name=name;
        //this.meal=meal;
    }

    public void additems(menuitems iteam){
        meal.add(iteam);
    }
    
    @Override
    public void showdetails(){
         System.out.println("-- " + name + " Combo --");
        for(menuitems food:meal){
            food.showdetails();
        }
        //System.out.println("Total: ₹" + getPrice());

    }

    public int getprize(){
        int total=0;
        for(menuitems item:meal){
            total+=item.getprize();
        }

        return total;
    }
}

public class menu{
    public static void main(String[] args) {
        menuindividual burger=new menuindividual("burger", 60);
        menuindividual pizza=new menuindividual("pizza", 250);
        menuindividual fries=new menuindividual("fries", 50);
        menuindividual coke=new menuindividual("coke", 90);

        burger.showdetails();
        pizza.showdetails();

        menucomposition happymeal=new menucomposition("happymeal");
        happymeal.additems(burger);
        happymeal.additems(fries);
        happymeal.additems(coke);

        happymeal.showdetails();

        
        System.out.println("prize of meal "+happymeal.getprize());
        
    }
}