package Soldier;

import Map.Field;

import javax.swing.ImageIcon;
/**
 * Created by Lee on 2015-05-22.
 */
public abstract class Weapon {
    public static final int sword = 1;
    public static final int lance = 2;
    public static final int bow = 3;
    public static final int horse = 4;
    public static final int scout = 5;
    protected int type;

    protected ImageIcon image;
    //Change button file name, *.jpg -> *.png

    private static final double[][] synastry = {
            {1, 1.2, 1, 1, 1},
            {1, 1, 1, 1.2, 1},
            {1, 1, 1, 1, 1},
            {1.2, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
    };
    //행이 공격하는쪽, 열이 공격받는쪽
    /*
                검   창   활   말   정찰
          검   1     1.2  1    1    1
          창   1     1    1    1.2  1
          활   1     1    1    1    1
          말   1.2   1    1    1    1
          정찰 1     1    1    1    1
     */

    int damage;
    int sight;
    int range;

    public void attack(Field field){
        if(field.isSoldier()){
            field.getSoldier().damaged(
                    (int)(synastry[type][field.getSoldier().getWeapon().type] * damage)
            );}
        else{
            System.out.println("Invalid");
        }
    }

    public int getDamage(){
        return damage;
    }
    public int getType(){
        return type;
    }
    public int getRange(){
        return range;
    }
    public int getSight(){
        return sight;
    }
    public ImageIcon getImage(){
        return image;
    }

    public void increaseDamage(int value){
        damage += value;
    }
    public void increaseSight(int value){
        sight += value;
    }
    public void increaseRange(int value){
        range += value;
    }

    public void decreaseDamage(int value){
        damage -= value;
    }
    public void decreaseSight(int value){
        sight -= value;
    }
    public void decreaseRange(int value){
        range -= value;
    }

    public void multipleDamage(double value){
        damage *= value;
    }
    public void divideDamage(double value){
        damage /= value;
    }
}
