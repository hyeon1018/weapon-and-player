package Hero;

import Soldier.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public class Alex extends Hero {
    public Alex(){
        name = "알렉산드로스";
        image = new ImageIcon("알렉산드로스 대왕.jpg").getImage();

        explan1 = "정복왕 : 기마병의 이동력과 공격력이 증가한다.";
        explan2 = "기마병 영웅";
        explan3 = "체력 * 1.5";
    }

    @Override
    void initSpeciality(ArrayList<Soldier> soldiers) {
        for(int i = 0; i < soldiers.size(); i++){
            if(soldiers.get(i).getWeapon().getType() == Weapon.horse){
                soldiers.get(i).getWeapon().multipleDamage(1.5);
                soldiers.get(i).trainMaxMP(1);
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
