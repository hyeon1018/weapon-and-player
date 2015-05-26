package Soldier;

import javax.swing.ImageIcon;

/**
 * Created by Lee on 2015-05-22.
 */
public class Lance extends Weapon{

    public Lance(){
        type = Weapon.lance;
        damage = 50;
        sight = 2;
        range = 1;

        image = new ImageIcon("Lance.png");
    }
    public Lance(int damage, int sight, int range){
        type = Weapon.lance;
        this.damage = damage;
        this.sight = sight;
        this.range = range;

        image = new ImageIcon("Lance_Hero.png");
    }
}
