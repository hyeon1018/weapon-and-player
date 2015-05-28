package Frame;


import Map.*;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapButton extends JButton implements MouseListener {
	
	private Field field;
    private MapPanel mapPanel;
	
	public MapButton(Field field, MapPanel mapPanel){
		this.field = field;
		this.setButtonIcon();
        addMouseListener(this);

        this.mapPanel = mapPanel;
	}
	
	public void setButtonIcon(){
		if(field.getSoldier() != null){
			this.setIcon(field.getSoldier().getWeapon().getImage());
			this.setText("");
		}else{
			this.setIcon(null);
			this.setText(field.toString());
		}
	}
	
	public void setButtonVisible(Player player) {
		if(player.getClass() == P1.class){
			if(field.isP1Visible()){
				this.setVisible(true);
			}
			else{
				//this.setVisible(false);
				this.setEnabled(false);
			}
		}
		else if(player.getClass() == P2.class){
			if(field.isP2Visible()){
				this.setVisible(true);
			}
			else{
				//this.setVisible(false);
				this.setEnabled(false);
			}
		}
	}

	public void setButtonColor(Player player) {
		try{
			if(field.getSoldier().getPlayer().getClass() == player.getClass()){
				this.setBackground(Color.GREEN);
			}
			else{
				this.setBackground(Color.RED);
			}
		}catch(Exception e){
			this.setBackground(Color.WHITE);
		}
		
	}
	
	public Field getField(){
		return this.field;
	}
	
	public void updateBtn(Player player){
		setButtonIcon();
		setButtonColor(player);
		setButtonVisible(player);
	}

	@Override
    public void mouseClicked(MouseEvent e) {
		
		if(e.getSource() == mapPanel.getSelectedButton()){
			//mapPanel.setSelectedButton(null);
		}
		else{
			mapPanel.setSelectedButton(((MapButton)(e.getSource())));
		}
        
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
        mapPanel.setMouseOverButton(((MapButton)(e.getSource())));

        mapPanel.getView().update();
    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
