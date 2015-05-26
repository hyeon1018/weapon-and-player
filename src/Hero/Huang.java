package Hero;

import Soldier.*;

import javax.swing.ImageIcon;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Huang extends Hero{
    public Huang(){
        name = "황충";
        image = new ImageIcon("황충.jpg").getImage();

        explan1 = "신궁 : 궁병의 사거리와 시야가 증가한다.";
        explan2 = "궁병 영웅";
        explan3 = "체력 1.2배";
    }



    @Override
    void initSpeciality(ArrayList<Soldier> soldiers) {
        for(int i = 0; i < soldiers.size(); i++){
            if(soldiers.get(i).getWeapon().getType() == Weapon.bow){
                soldiers.get(i).getWeapon().increaseSight(1);
                soldiers.get(i).getWeapon().increaseRange(1);
            }
        }
    }

    @Override
    void inGameSpeciality(ArrayList<Soldier> soldiers) {

    }

    @Override
    Soldier appear() {
        return null;
    }
}
