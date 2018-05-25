package Soldier;

import javax.swing.ImageIcon;

/**
 * Created by Lee on 2015-05-22.
 */
public class Bow extends Weapon{

    public Bow(){
        type = Weapon.bow;
        damage = 40;
        sight = 2;
        range = 2;

        originDamage = damage;

        image = new ImageIcon("res\\Bow.png");
    }
    public Bow(int damage, int sight, int range){
        type = Weapon.bow;
        this.damage = damage;
        this.sight = sight;
        this.range = range;

        originDamage = damage;
        
        setImageIconHero();
    }

    @Override
    public void setImageIconHero() {
        image = new ImageIcon("res\\Bow_Hero.png");
    }
}
