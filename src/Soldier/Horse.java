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

        originDamage = damage;

        image = new ImageIcon("res\\Horse.png");
    }
    public Horse(int damage, int sight, int range){
        type = Weapon.horse;
        this.damage = damage;
        this.sight = sight;
        this.range = range;

        originDamage = damage;

        setImageIconHero();
    }

    @Override
    public void setImageIconHero() {
        image = new ImageIcon("res\\Horse_Hero.png");
    }
}
