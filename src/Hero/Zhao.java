package Hero;

import Soldier.Soldier;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Zhao extends Hero{
    public Zhao(){
        name = "조운";
        image = new ImageIcon("res\\조운.jpg").getImage();

        explan1 = "투지 : 병사들의 숫자가 줄어들 수록 공격력이 강해진다.";
        explan2 = "창병 영웅";
        explan3 = "체력 *1.5, 공격력 *2";

        soldier = new Soldier(Hero.Zhao, whose, name);
    }


    @Override
    public void initSpeciality(ArrayList<Soldier> soldiers) {

    }

    @Override
    public void inGameSpeciality(ArrayList<Soldier> soldiers) {

    }

    @Override
    public Soldier appear() {
        return soldier;
    }
}
