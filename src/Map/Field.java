package Map;

import Soldier.Soldier;
/**
 * Created by Lee on 2015-05-22.
 */
public class Field {
    private boolean p1Visible;
    private boolean p2Visible;
    private Soldier soldier;    //현재 지형에 있는 유닛
    public final int x,y; // 좌표
    public final int state;    //지형의 상태

    public Field(int x, int y, int state) {
        this.x = x;
        this.y = y;
        this.state = state;
        p1Visible = false;
        p2Visible = true;
        this.soldier = null;
        
       
    }

    public void setP1Visible(boolean p1Visible){
        this.p1Visible = p1Visible;
    }
    public void setP2Visible(boolean p2Visible){
        this.p2Visible = p2Visible;
    }

    public boolean isP1Visible(){
        return p1Visible;
    }
    public boolean isP2Visible(){
        return p2Visible;
    }
    public Soldier getSoldier(){
        return soldier;
    }
    public boolean isSoldier(){
        return (soldier != null);
    }
    
    public void setSoldier(Soldier sol){
    	this.soldier = sol;
    }
    
    public String toString(){
    	return x + ", " + y;
    }
}
