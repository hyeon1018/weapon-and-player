package Hero;

import Map.Player;
import Soldier.Soldier;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Eulgi extends Hero {
    public Eulgi(){
        name = "을지문덕";
        image = new ImageIcon("res\\을지문덕.jpg").getImage();

        explan1 = "전략가 : 병사들의 이동력과 시야가 증가한다.";
        explan2 = "정찰병 영웅";
        explan3 = "시야 *3";

        soldier = new Soldier(Hero.Eulgi, player, name);
    }


    @Override
    public void initSpeciality(Player player) {

    }

    @Override
    public void startSpeciality(ArrayList<Soldier> soldiers) {
        for(int i = 0; i < soldiers.size(); i++) {
            soldiers.get(i).trainMaxMP(1);
            soldiers.get(i).getWeapon().increaseSight(1);
        }
    }

    @Override
    public void inGameSpeciality(ArrayList<Soldier> soldiers) {

    }

}
