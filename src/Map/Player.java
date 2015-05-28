package Map; /**
 * Created by Lee on 2015-05-22.
 */
import Hero.Hero;
import Soldier.Soldier;

import java.util.ArrayList;

public class Player {
    private ArrayList<Soldier> soldiers;
    private Hero hero;
    private int maxRes = 1000;
    
    public Player(){
        this.soldiers = new ArrayList<Soldier>();
        hero = null;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setSoldiers(ArrayList<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    public Hero getHero(){
        return hero;
    }
    public ArrayList<Soldier> getSoldiers(){
        return soldiers;
    }
    public void addSoldier(Soldier sol){
    	this.soldiers.add(sol);
    }
    public void removeSoldier(Soldier sol){
    	this.soldiers.remove(sol);
    }
    
    public void setMaxRes(int i){
    	this.maxRes = i;
    }
    public int getMaxRes(){
    	return this.maxRes;
    }
    
    public int getCurRes(){
    	
    	int sum = 0;
    	for(int i = 0 ; i < soldiers.size() ; i++){
    		sum += soldiers.get(i).getCost();
    	}
    	
    	return sum;
    }
}
