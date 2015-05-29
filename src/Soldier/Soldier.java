package Soldier;

import Hero.Hero;
import Map.*;
/**
 * Created by Lee on 2015-05-22.
 */
//2015-05-25 이선명
    //checkP1Visible, checkP2Visible, makeVisible 메소드 추가함
public class Soldier {
    private Weapon weapon;
    private String name;//이름
    private int HP;//체력
    private int maxHP;//최대 체력
    private int MP;//현재 이동력
    private int maxMP;//최대 이동력
    private int defense;//방어력
    private final int cost;//자원 소모값
    private Field currentField; //

    private Player player;//p1것인지 p2것인지

    public Soldier(int type, Player player) {
        switch(type){
            case Weapon.sword :
                maxHP = 120;
                maxMP = 2;
                cost = 100;
                createSword();
                break;
            case Weapon.lance :
                maxHP = 100;
                maxMP = 2;
                cost = 150;
                createLance();
                break;
            case Weapon.bow :
                maxHP = 80;
                maxMP = 2;
                cost = 120;
                createBow();
                break;
            case Weapon.horse :
                maxHP = 100;
                maxMP = 4;
                cost = 200;
                createHorse();
                break;
            case Weapon.scout :
                maxHP = 40;
                maxMP = 3;
                cost = 60;
                createScout();
                break;
            default :
                maxHP = 0;
                maxMP = 0;
                cost = 0;
                System.out.println("Soldier Type Error");
                break;
        }

        HP = maxHP;
        MP = maxMP;
        this.player = player;
    }

    //특수유닛 생성용
    public Soldier(int type, Player player, String name){
        switch (type){
            case Hero.Jeanne :
                maxHP = 360;
                maxMP = 2;
                defense = 0;
                weapon = new Sword(40, 2, 1);
                break;
            case Hero.Alex :
                maxHP = 150;
                maxMP = 4;
                defense = 0;
                weapon = new Horse(45, 2, 1);
                break;
            case Hero.Eulgi :
                maxHP = 40;
                maxMP = 3;
                defense = 0;
                weapon = new Scout(10, 8, 1);
                break;
            case Hero.Zhao :
                maxHP = 150;
                maxMP = 2;
                defense = 0;
                weapon = new Lance(100, 2, 1);
                break;
            case Hero.Huang :
                maxHP = 96;
                maxMP = 2;
                defense = 0;
                weapon = new Bow(40, 3, 2);
                break;
            case Hero.Oda :
                maxHP = 360;
                maxMP = 2;
                defense = 0;
                weapon = new Sword(80, 2, 1);
                break;
            case Hero.Gyebaek :
                maxHP = 240;
                maxMP = 4;
                defense = 0;
                weapon = new Horse(60, 2, 1);
                break;
            default :
                maxHP = 0;
                maxMP = 0;
                defense = 0;
                System.out.println("Hero Type Error");
                break;
        }

        HP = maxHP;
        MP = maxMP;
        this.player = player;
        cost = 0;
        this.name = name;
    }


    public void attack(Field destination){
        if(destination.getSoldier().getPlayer() == this.player){
            return;
        }

        int distance = Math.abs(destination.x - currentField.x) + Math.abs(destination.y - currentField.y);
        //사정거리안에 상대가 있을경우
        if(distance <= getWeapon().getRange()){
            weapon.attack(destination);
            MP = 0;
            //턴 없앰 추가해야함
        }
        else{
            System.out.println("공격 실패");
        }
    }
    public void healed(int heal){
        HP += heal;
        if(HP > maxHP)
            HP = maxHP;
    }
    public void damaged(int damage){
        HP -= (damage - defense);
    }
    public void Move(Field destination){
        if(destination.getSoldier() != null){
            return;
        }

        int distance = Math.abs(destination.x - currentField.x) + Math.abs(destination.y - currentField.y);
        //이동거리안에 목적지가 있을경우
        if(distance <= MP){
            //추가해야함
            currentField.setSoldier(null);
            destination.setSoldier(this);
            currentField = destination;

            MP -= distance;
        }
        else{
            System.out.println("이동 실패");
        }
    }

    public void trainMaxHP(int value) {
        maxHP += value;
    }
    public void trainMultipleMaxHP(double value){
        maxHP *= value;
    }
    public void trainMaxMP(int value){
        maxMP += value;
    }


    public void updateSight(Map map){
        Field[][] fields = map.getFields();

        int sight = weapon.getSight();
        int currentX = currentField.x;  int currentY = currentField.y;
        int distance = 0;

        for(int i = currentX - sight; i <= currentX + sight; i++){
            for(int j = currentY - sight; j <= currentY + sight; j++){
                if(player.getClass() == P1.class){
                    if(fields[i][j].isP1Visible()) {
                        continue;
                    }

                    distance = Math.abs(fields[i][j].x - currentField.x) + Math.abs(fields[i][j].y - currentField.y);
                    if(distance <= weapon.getSight()){
                        fields[i][j].setP1Visible(true);
                    }
                }

                else if(player.getClass() == P2.class){
                    if(fields[i][j].isP2Visible()) {
                        continue;
                    }

                    distance = Math.abs(fields[i][j].x - currentField.x) + Math.abs(fields[i][j].y - currentField.y);
                    if(distance <= weapon.getSight()){
                        fields[i][j].setP2Visible(true);
                    }
                }
            }
        }


    }


    public void setField(Field currentField){
        this.currentField = currentField;
    }

    public String getName(){
        return name;
    }
    public Field getCurrentField(){
        return currentField;
    }
    public Weapon getWeapon(){
        return weapon;
    }
    public int getCost(){
        return cost;
    }
    public int getHP(){
        return HP;
    }
    public int getMaxHP(){
        return maxHP;
    }
    public int getMP(){
        return MP;
    }
    public int getMaxMP(){
        return maxMP;
    }
    public int getDefense(){
        return defense;
    }
    public Player getPlayer(){
        return player;
    }

    private void createSword(){
        name = "검병";
        defense = 0;
        weapon = new Sword();
    }
    private void createLance(){
        name = "창병";
        defense = 0;
        weapon = new Lance();
    }
    private void createBow(){
        name = "궁병";
        defense = 0;
        weapon = new Bow();
    }
    private void createHorse(){
        name = "기마병";
        defense = 0;
        weapon = new Horse();
    }
    private void createScout(){
        name = "정찰병";
        defense = 0;
        weapon = new Scout();
    }


}
