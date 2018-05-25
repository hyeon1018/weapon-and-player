package Frame;

import Map.Map;
import Map.P1;
import Map.P2;
import Map.Player;

public  class FinalObserver implements Observer {

    private Player p1;
    private Player p2;
    private FinalFrame [] subject = new FinalFrame[2];

    public FinalObserver(Map map, Player winner){
        p1 = map.getP1();
        p2 = map.getP2();

        if(p1 == winner){
            subject[0] = new FinalFrame(p1, true);
        }else{
            subject[0] = new FinalFrame(p1, false);
        }

        if(p2 == winner){
            subject[1] = new FinalFrame(p2, true);
        }else{
            subject[1] = new FinalFrame(p2, false);
        }
        subject[0].setObserver(this);
        subject[1].setObserver(this);
        subject[1].setLocation(700, 100);



    }

    public static void main(String[] args){
        P1 p1 = new P1();
        new FinalObserver(new Map(p1, new P2()), p1);

    }

    public void updateViewers() {
    	if(subject[0].ispressed() && subject[1].ispressed()){
			subject[0].setVisible(false);
			subject[1].setVisible(false);
			
			new SelectHeroObserver();
		}else{
			System.out.println("P1 : "+ subject[0].ispressed() + ", P2 : " + subject[1].ispressed());
		}

    }
}
