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



    abstract void initSpeciality(ArrayList<Soldier> soldiers);
    abstract void inGameSpeciality(ArrayList<Soldier> soldiers);
    abstract Soldier appear();

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
}
