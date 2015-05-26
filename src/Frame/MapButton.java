package Frame;

import javax.swing.JButton;
import Map.*;

public class MapButton extends JButton {
	
	private Field field;
	
	public MapButton(Field field){
		this.field = field;
		this.setSoldierIcon();
	}
	
	public void setSoldierIcon(){
		
		if(field.getSoldier() != null){
			this.setIcon(field.getSoldier().getWeapon().getImage());

		}else{
			this.setIcon(null);
			this.setText(field.toString());
		}
	}
	
	public Field getField(){
		return this.field;
	}
	
	
}
