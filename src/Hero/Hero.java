package Hero;
import Soldier.*;
import java.awt.Image;
import java.util.ArrayList;

/**
 * Created by Lee on 2015-05-22.
 */
public abstract class Hero {
    protected String name;
    protected Image image;
    protected Soldier soldier;

    protected String explan1;
    protected String explan2;
    protected String explan3;

    protected int whose;

    public static final int Jeanne = 10;
    public static final int Alex = 11;
    public static final int Eulgi = 12;
    public static final int Zhao = 13;
    public static final int Huang = 14;
    public static final int Oda = 15;
    public static final int Hannibal = 16;
    public static final int Gyebaek = 17;


    public abstract void initSpeciality(ArrayList<Soldier> soldiers);
    public abstract void inGameSpeciality(ArrayList<Soldier> soldiers);
    public abstract Soldier appear();//Hero 마다 수정해야함


    public Image getImage(){
        return image;
    }
    public String getName(){
        return name;
    }

    public String getExplan1(){
        return explan1;
    }
    public String getExplan2(){
        return explan2;
    }
    public String getExplan3(){
        return explan3;
    }

    public Soldier getSoldier(){
        return soldier;
    }

    public void setWhose(int whose){
        if(whose != 1 && whose != 2){
            System.out.println("Hero setWhose parameter Error");
            return;
        }
        this.whose = whose;
    }
}
