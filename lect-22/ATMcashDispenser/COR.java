abstract class MoneyHandler{
    protected MoneyHandler nexthandler;

    public MoneyHandler(){
        this.nexthandler=null;
    }
    public void setHandler (MoneyHandler next){
        this.nexthandler=next;
    }
    public abstract void dispense(int amount);
};
class ThoursandHandler extends MoneyHandler{
    private int notes;

    public ThoursandHandler(int notes){
        this.notes=notes;
    }
    @Override
    public void dispense(int amount){
        int notesneeded=amount/1000;

        if(notesneeded>notes){
            notesneeded=notes;
            notes=0;
        }
        else{
            notes-=notesneeded;
        }
        if(notesneeded>0){
            System.out.println("Dispensing "+notesneeded+" thousand Rs notes");
        }

        int remnotes=amount-(notesneeded*1000);
        if(remnotes>0){
            if(nexthandler==null){
                System.out.println("remaining amount of "+remnotes+" cannot be fullfilled ");
            }
            else{
                nexthandler.dispense(remnotes);
            }
        }

    }
};

class FiveHundredHandler extends MoneyHandler{
    private int notes;

    public FiveHundredHandler(int notes){
        this.notes=notes;
    }
    @Override
    public void dispense(int amount){
        int notesneeded=amount/500;

        if(notesneeded>notes){
            notesneeded=notes;
            notes=0;
        }
        else{
            notes-=notesneeded;
        }

        if(notesneeded>0){
            System.out.println("Dispensing "+notesneeded+" FiveHundred Rs notes");
        }
        int remnotes=amount-(notesneeded*500);

        if(remnotes>0){
            if(nexthandler!=null) nexthandler.dispense(remnotes);
        }
        else{
            System.out.println("remaining amount of "+remnotes+" cannot be fullfilled ");
        }
    }
}


class TwoHundredHandler extends MoneyHandler{
    private int notes;

    public TwoHundredHandler(int notes){
        this.notes=notes;
    }
    @Override
    public void dispense(int amount){
        int notesneeded=amount/200;

        if(notesneeded>notes){
            notesneeded=notes;
            notes=0;
        }
        else{
            notes-=notesneeded;
        }

        if(notesneeded>0){
            System.out.println("Dispensing "+notesneeded+" TwoHundred Rs notes");
        }
        int remnotes=amount-(notesneeded*200);

        if(remnotes>0){
            if(nexthandler!=null) nexthandler.dispense(remnotes);
        }
        else{
            System.out.println("remaining amount of "+remnotes+" cannot be fullfilled ");
        }
    }
}

class HundredHandler extends MoneyHandler{
    private int notes;

    public HundredHandler(int notes){
        this.notes=notes;
    }
    @Override
    public void dispense(int amount){
        int notesneeded=amount/100;

        if(notesneeded>notes){
            notesneeded=notes;
            notes=0;
        }
        else{
            notes-=notesneeded;
        }

        if(notesneeded>0){
            System.out.println("Dispensing "+notesneeded+" Hundred Rs notes");
        }
        int remnotes=amount-(notesneeded*100);

        if(remnotes>0){
            if(nexthandler!=null) nexthandler.dispense(remnotes);
        }
        else{
            System.out.println("remaining amount of "+remnotes+" cannot be fullfilled ");
        }
    }
}






public class COR{
    public static void main(String[] args) {
        MoneyHandler thousand=new ThoursandHandler(10);
        MoneyHandler fivehundred=new FiveHundredHandler(10);
        MoneyHandler twohundred =new TwoHundredHandler(10);
        MoneyHandler hundred=new HundredHandler(10);

        // chain of responsibility

        thousand.setHandler(fivehundred);
        fivehundred.setHandler(twohundred);
        twohundred.setHandler(hundred);


        int paisa=6480;

        System.out.println("withdraw "+paisa+" Rs from bank");

        thousand.dispense(paisa);


        
        
    }
}