package Hero;

import Map.Player;
import Soldier.Soldier;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Gyebaek extends Hero {
    public Gyebaek(){
        name = "계백";
        image = new ImageIcon("res\\계백.jpg").getImage();

        explan1 = "결사대 : 병사들의 체력이 줄어들 수록 공격력이 강해진다.";
        explan2 = "기마병 영웅";
        explan3 = "체력 *2 , 공격력 *1.5";

        soldier = new Soldier(Hero.Gyebaek, player, name);
    }


    @Override
    public void initSpeciality(Player player) {

    }

    @Override
    public void startSpeciality(ArrayList<Soldier> soldiers) {

    }

    @Override
    public void inGameSpeciality(ArrayList<Soldier> soldiers) {
        double multipleValue = 0;
        double HP = 0;
        double maxHP = 0;
        double originDamage = 0;
        for(int i = 0; i < soldiers.size(); i++){
            HP = (double)(soldiers.get(i).getHP());
            maxHP = (double)(soldiers.get(i).getMaxHP());
            originDamage = (double)(soldiers.get(i).getWeapon().getOriginDamage());

            multipleValue = 1.0 - ((maxHP - HP) / (2 * maxHP));
            soldiers.get(i).getWeapon().setDamage(multipleValue * originDamage);
        }
    }

}
