package Soldier;

import javax.swing.ImageIcon;

/**
 * Created by Lee on 2015-05-22.
 */
public class Scout extends Weapon{

    public Scout(){
        type = Weapon.scout;
        damage = 40;
        sight = 4;
        range = 1;

        image = new ImageIcon("Scout.png");
    }
    public Scout(int damage, int sight, int range){
        type = Weapon.scout;
        this.damage = damage;
        this.sight = sight;
        this.range = range;

        image = new ImageIcon("Scout_Hero.png");
    }
}
