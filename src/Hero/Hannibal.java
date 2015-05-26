package Hero;

import Soldier.Soldier;

import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Hannibal extends Hero{
    public Hannibal(){
        name = "한니발 바르카";
        image = new ImageIcon("한니발 바르카.jpg").getImage();

        explan1 = "효율 지휘 : 초기에 주어지는 자원이 좀 더 많다.";
        explan2 = "등장하지 않음";
        explan3 = "자원 1400";
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
