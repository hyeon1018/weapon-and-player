package Frame;

import Map.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapButton extends JButton implements MouseListener {
	//Object Variables
	private Field field;
    private MapPanel mapPanel;

    //Constructor
	public MapButton(Field field, MapPanel mapPanel){
		this.field = field;
		this.setButtonIcon();
        addMouseListener(this);

        this.mapPanel = mapPanel;
	}

    //Getter & Setter;
    public Field getField(){
        return this.field;
    }

    //Button update;
	public void setButtonIcon() {
        //버튼의 병사로부터 아이콘을 얻어 설정한다.
		if (field.getSoldier() != null) {
			this.setIcon(field.getSoldier().getWeapon().getImage());
		} else {
            //해당 위치에 병사가 없다면, 해당 위치의 좌표를 표시한다 (TEST)
            this.setIcon(null);
		}
	}
	public void setButtonVisible(Player player) {
		//플레이어에 따라서 시야 역활을 하는 버튼의 가기성을 수정한다.
		if(player.getClass() == P1.class){
			if(field.isP1Visible()){
				this.setVisible(true);
			}
			else{
				this.setVisible(false);
				//this.setEnabled(false);
			}
		}
		else if(player.getClass() == P2.class){
			if(field.isP2Visible()){
				this.setVisible(true);
			}
			else{
				this.setVisible(false);
				//this.setEnabled(false);
			}
		}
	}
	public void setButtonColor(Player player) {
		//상황에 따라서 버튼의 색을 변경한다.
		try {
			if (field.getSoldier().getPlayer().getClass() == player.getClass()) {
				this.setBackground(Color.GREEN);
			} else {
				this.setBackground(Color.RED);
			}
		} catch (Exception e) {
			//NullPoint Error -> set Color White;
			this.setBackground(Color.WHITE);
		}
	}
	public void updateBtn(Player player){
		setButtonIcon();
		setButtonColor(player);
		setButtonVisible(player);
	}

	//MouseListener implements methods
	@Override
    public void mouseClicked(MouseEvent e) {
		if(e.isMetaDown()){
			if (e.getSource() == mapPanel.getMetaClickedButton()) {
				mapPanel.setMetaClickedButton(null);
			}
			else {
				mapPanel.setMetaClickedButton(((MapButton) (e.getSource())));
			}
		}else {
			if (e.getSource() == mapPanel.getSelectedButton()) {
				mapPanel.setSelectedButton(null);
			}
			else {
				mapPanel.setSelectedButton(((MapButton) (e.getSource())));
			}
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
		mapPanel.setMouseOverButton(null);
		mapPanel.getView().update();
    }
}
