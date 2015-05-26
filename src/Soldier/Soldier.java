package Soldier;

import Map.Field;
import Map.Map;
/**
 * Created by Lee on 2015-05-22.
 */
//2015-05-25 이선명
    //checkP1Visible, checkP2Visible, makeVisible 메소드 추가함
public class Soldier {
    private Weapon weapon;
    private String name;//이름
    private int HP;//체력
    private final int maxHP;//최대 체력
    private int MP;//현재 이동력
    private int maxMP;//최대 이동력
    private int defense;//방어력
    private final int cost;//자원 소모값
    private int x, y; //

    private int whose;//p1것인지 p2것인지

    public Soldier(int type, int whose) {
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
        this.whose = whose;
    }


    public void attack(Field field){
        int distance = Math.abs(field.x - this.x) + Math.abs(field.y - this.y);
        //사정거리안에 상대가 있을경우
        if(distance < getWeapon().getRange()){
            weapon.attack(field);
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
    public void Move(Field field){
        int distance = Math.abs(field.x - this.x) + Math.abs(field.y - this.y);
        //이동거리안에 목적지가 있을경우
        if(distance < MP){
            //추가해야함
        }
    }

    public void trainMaxMP(int value){
        maxMP += value;
    }

    public void makeVisible(Map map){
        Field[][] fields = map.getFields();
        Field field = null;
        int distance = 0;

        //2015 05 25 이선명 수정
        //필드맵 전체를 검사
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields[0].length; j++){
                //필드와의 거리를 계산해서 sight내에 있을경우 Visible로 만든다
                field = fields[i][j];

                //Soldier가 p1것인지 p2것인지 구분해서 makeVisible
                switch (whose){
                    case 1:
                        checkP1Visible(field, distance);
                        break;
                    case 2:
                        checkP2Visible(field, distance);
                        break;
                }
            }
        }
    }


    public String getName(){
        return name;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
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

    private void checkP1Visible(Field field, int distance){
        if(distance < weapon.getSight()){
            field.setP1Visible(true);
        }
        else{
            field.setP1Visible(false);
        }
    }
    private void checkP2Visible(Field field, int distance){
        if(distance < weapon.getSight()){
            field.setP2Visible(true);
        }
        else{
            field.setP2Visible(false);
        }
    }
   
}
