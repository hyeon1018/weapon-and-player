package Hero;

import Soldier.Soldier;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Jeanne extends Hero {
    public Jeanne(){
        name = "잔 다르크";
        image = new ImageIcon("잔 다르크.jpg").getImage();

        explan1 = "신앙 : 턴마다 병사들의 체력 회복이 회복된다.";
        explan2 = "검병 영웅";
        explan3 = "체력 *3";
    }

    @Override
    void initSpeciality(ArrayList<Soldier> soldiers) {

    }

    @Override
    void inGameSpeciality(ArrayList<Soldier> soldiers) {
        for(int i = 0; i < soldiers.size(); i++){
            soldiers.get(i).healed(10);
        }
    }

    @Override
    Soldier appear() {
        return null;
    }
}
