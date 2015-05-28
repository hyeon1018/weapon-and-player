package Frame;

import Map.Field;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapButton extends JButton implements MouseListener {
	
	private Field field;
    private MapPanel mapPanel;
	
	public MapButton(Field field, MapPanel mapPanel){
		this.field = field;
		this.setSoldierIcon();
        addMouseListener(this);

        this.mapPanel = mapPanel;
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


    @Override
    public void mouseClicked(MouseEvent e) {

        mapPanel.setSelectedField(field);

        mapPanel.getView().update();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mapPanel.setMouseOverField(field);

        mapPanel.getView().update();
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
