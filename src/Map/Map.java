package Map;

import Hero.Hero;
import Soldier.Soldier;
import Soldier.Weapon;

/**
 * Created by Lee on 2015-05-22.
 */
public class Map {
    P1 p1;
    P2 p2;
    Field[][] fields = new Field[10][10];
    
    public Map(){
        for(int i = 0 ; i < fields.length; i++){
            for(int j = 0; j < fields[0].length; j++){
                fields[i][j] = new Field(i, j, 1);
                fields[i][j].setP1Visible(false);
                fields[i][j].setP2Visible(false);
            }
        }

        
        for(int i = 0 ; i < fields.length; i++){
        	for(int j = 0 ; j < 2 ; j++){
        		fields[i][j].setP1Visible(true);
        	}
        }
        
        for(int i = 0 ; i < 10 ; i++){
        	for(int j = 9 ; j >= fields[0].length -2 ; j--){
        		fields[i][j].setP2Visible(true);
        	}
        }
        
    }
    
    public Map(P1 p1, P2 p2){
    	this();
    	this.p1 = p1;
    	this.p2 = p2;
    }

    public Field[][] getFields(){
        return fields;
    }
    //2015-05-26 13:18 김건휘 추가
    public Field getField(int x, int y){
    	return fields[x][y];
    }
    public Player getP1(){
    	return this.p1;
    }
    
    public Player getP2(){
    	return this.p2;
    }
}
