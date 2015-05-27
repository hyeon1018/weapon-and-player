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
        
        //Test
        fields[0][0].setSoldier(new Soldier(Weapon.sword, 0));
        fields[1][0].setSoldier(new Soldier(Weapon.lance, 0));
        fields[2][0].setSoldier(new Soldier(Weapon.horse, 0));
        fields[3][0].setSoldier(new Soldier(Weapon.bow, 0));
        fields[4][0].setSoldier(new Soldier(Weapon.scout, 0));
        fields[5][0].setSoldier(new Soldier(Hero.Jeanne, 0, ""));
        fields[6][0].setSoldier(new Soldier(Hero.Zhao, 0, ""));
        fields[7][0].setSoldier(new Soldier(Hero.Gyebaek, 0, ""));
        fields[8][0].setSoldier(new Soldier(Hero.Huang, 0, ""));
        fields[9][0].setSoldier(new Soldier(Hero.Eulgi, 0, ""));
        
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
