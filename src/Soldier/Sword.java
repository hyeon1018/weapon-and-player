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

        originDamage = damage;

        image = new ImageIcon("res\\Sword.png");
    }
    public Sword(int damage, int sight, int range){
        type = Weapon.sword;
        this.damage = damage;
        this.sight = sight;
        this.range = range;

        originDamage = damage;

        setImageIconHero();
    }

    @Override
    public void setImageIconHero() {
        image = new ImageIcon("res\\Sword_Hero.png");
    }
}
