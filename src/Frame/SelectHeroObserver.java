package Frame;
import Map.Map;
import Map.*;

/**
 * Created by Lee on 2015-05-21.
 */
public class SelectHeroObserver implements Observer{
	private Player p1;
	private Player p2;
	
	private SelectHeroFrame [] subject = new SelectHeroFrame[2];
	
	public SelectHeroObserver() {
		p1 = new P1();
		p2 = new P2();
		System.out.println("P1, P2 Generated.");
		subject[0] = new SelectHeroFrame(p1);
		subject[0].setObserver(this);
		subject[1] = new SelectHeroFrame(p2);
		subject[1].setObserver(this);
		subject[1].setLocation(700, 100);
	}

	@Override
	public void updateViewers() {
			if(subject[0].isSelected() && subject[1].isSelected()){
				subject[0].setVisible(false);
				subject[1].setVisible(false);
				
				new SelectSoldierObserver(new Map((P1)p1, (P2)p2));
				System.out.println("P1 : " + p1.getHero().getName() + ", P2 : " + p2.getHero().getName());
			}else{
				System.out.println("P1 : "+ subject[0].isSelected() + ", P2 : " + subject[1].isSelected());
			}
	}
	
}
