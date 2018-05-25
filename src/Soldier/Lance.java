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

        originDamage = damage;

        image = new ImageIcon("res\\Lance.png");
    }
    public Lance(int damage, int sight, int range){
        type = Weapon.lance;
        this.damage = damage;
        this.sight = sight;
        this.range = range;

        originDamage = damage;

        setImageIconHero();
    }

    @Override
    public void setImageIconHero() {
        image = new ImageIcon("res\\Lance_Hero.png");
    }
}
