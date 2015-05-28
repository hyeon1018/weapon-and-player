package Hero;

import Map.Player;
import Soldier.Soldier;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Hannibal extends Hero{
    public Hannibal(){
        name = "한니발 바르카";
        image = new ImageIcon("res\\한니발 바르카.jpg").getImage();

        explan1 = "효율 지휘 : 초기에 주어지는 자원이 좀 더 많다.";
        explan2 = "등장하지 않음";
        explan3 = "자원 1400";

        soldier = null;
    }


    @Override
    public void initSpeciality(Player player) {
        player.setMaxRes(1400);
    }

    @Override
    public void startSpeciality(ArrayList<Soldier> soldiers) {

    }

    @Override
    public void inGameSpeciality(ArrayList<Soldier> soldiers) {

    }

}
