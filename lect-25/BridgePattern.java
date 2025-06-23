
interface Engine {
    void Start();

}

class PetrolEngine implements Engine{
    @Override
   public void Start(){
        System.out.println("car is running using petrol engine");
    }
}

class DieselEngine implements Engine{
    @Override
    public void Start(){
        System.out.println("car is running using DIESEL engine");
    }
}

class CngEngine implements Engine{
    @Override
    public void Start(){
        System.out.println("engine is running using cng");
    }
}


abstract class car{
    protected Engine e;

    public car(Engine e){
        this.e=e;
    }
    public abstract void drive();
}

class suv extends car{

    public suv(Engine e){
        super(e);
    }

    @Override
    public void drive(){
        e.Start();
        System.out.println("driving suv ");
    }
} 

class alto extends car{
    public alto(Engine e){
        super(e);
    }
    public void drive(){
        e.Start();
        System.out.println("driving alto");
    }
}

public class BridgePattern{
    public static void main(String[] args) {
        Engine petrol=new PetrolEngine();
        Engine diesel=new DieselEngine();

        car suv=new suv(diesel);
        car alto=new alto(petrol);

        suv.drive();
        alto.drive();
        
    }
}