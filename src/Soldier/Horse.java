package Soldier;

import javax.swing.ImageIcon;

/**
 * Created by Lee on 2015-05-22.
 */
public class Horse extends Weapon{

    public Horse(){
        type = Weapon.horse;
        damage = 45;
        sight = 2;
        range = 1;

        image = new ImageIcon("Horse.png");
    }
    public Horse(int damage, int sight, int range){
        type = Weapon.horse;
        this.damage = damage;
        this.sight = sight;
        this.range = range;

        image = new ImageIcon("Horse_Hero.png");
    }
}
