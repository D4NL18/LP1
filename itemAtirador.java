package racobafoda.lp1;


public class itemAtirador extends Item{

   
    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
    
    private int range = 1;
    
    @Override
    public void equipar(Personagem per){
        per.setItem(true);
        per.setRange(per.getRange() + this.getRange());
    }



    public itemAtirador(){
        this.setNome("Lentes telescópicas");
    }
    


    
}
