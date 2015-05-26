package Hero;

import Soldier.Soldier;

import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Gyebaek extends Hero {
    public Gyebaek(){
        name = "계백";
        image = new ImageIcon("계백.jpg").getImage();

        explan1 = "결사대 : 병사들의 체력이 줄어들 수록 공격력이 강해진다.";
        explan2 = "기마병 영웅";
        explan3 = "체력 *2 , 공격력 *1.5";
    }


    @Override
    void initSpeciality(ArrayList<Soldier> soldiers) {

    }

    @Override
    void inGameSpeciality(ArrayList<Soldier> soldiers) {

    }

    @Override
    Soldier appear() {
        return null;
    }
}
