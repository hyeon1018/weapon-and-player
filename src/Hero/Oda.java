package Hero;

import Soldier.Soldier;

import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Oda extends Hero{
    public Oda(){
        name = "오다 노부나가";
        image = new ImageIcon("오다 노부나가.jpg").getImage();

        explan1 = "다이묘 : 병사들에게 추가 능력은 없지만, 영웅이 강력하다";
        explan2 = "검병 영웅";
        explan3 = "체력 *3, 공격력*2";
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
