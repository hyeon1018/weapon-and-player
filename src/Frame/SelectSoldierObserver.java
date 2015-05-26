package Frame;

import java.awt.BorderLayout;

import Map.*;

public class SelectSoldierObserver {
	
	private SelectSoldierFrame[] subject = new SelectSoldierFrame[2];
	
	public SelectSoldierObserver(Map map){
		
		subject[0] = new SelectSoldierFrame(map, map.getP1());
		subject[1] = new SelectSoldierFrame(map, map.getP2());
		subject[1].setLocation(1000, 100);
	}
}
