package Soldier;

import javax.swing.ImageIcon;

/**
 * Created by Lee on 2015-05-22.
 */
public class Sword extends Weapon{

    public Sword(){
        type = Weapon.sword;
        damage = 40;
        sight = 2;
        range = 1;

        image = new ImageIcon("Sword.png");
    }
    public Sword(int damage, int sight, int range){
        type = Weapon.sword;
        this.damage = damage;
        this.sight = sight;
        this.range = range;

        image = new ImageIcon("Sword_Hero.png");
    }
}
