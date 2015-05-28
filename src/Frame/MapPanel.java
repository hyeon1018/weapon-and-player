package Frame;
import Map.Field;
import Map.Map;
import Map.P1;
import Map.P2;
import Map.Player;

import javax.swing.*;

import java.awt.*;


public class MapPanel extends JPanel implements Viewer{
	//나중에 수정하던지 하세요.
	private MapButton [][] fieldBtn = new MapButton[10][10];
	private MapButton selectedButton, mouseOverButton;
	private Viewer view;
	private Player player;
	private Map map;

	public MapPanel(Map map, Player player){
		this.player = player;
		this.map = map;
		selectedButton = null;
		mouseOverButton = null;
		
		
		for(int i = 0 ; i < 10 ; i ++){
			for(int j = 0 ; j < 10 ; j++){
				fieldBtn[i][j] = new MapButton(map.getField(i, j), this);
			}
		}

		this.setLayout(new GridLayout(10, 10));
		if(player.getClass() == P1.class){
			for(int i = 0 ; i < 10 ; i++){
				for(int j = 0 ; j < 10 ; j++){
					this.add(fieldBtn[i][j]);
				}
			}
		}
		else if(player.getClass() == P2.class){
			for(int i = 0 ; i  < 10 ; i++){
				for(int j = 9 ; j >= 0 ; j--){
					this.add(fieldBtn[i][j]);
					
				}
			}
		}




	}
	
	public void updateFieldButtons(){
		for(int i = 0 ; i < 10 ; i++){
			for(int j = 0 ; j < 10 ; j++){
				fieldBtn[i][j].updateBtn(player);
			}
		}
	}

    public void setSelectedButton(MapButton btn){
        this.selectedButton = btn;
    }
    public void setMouseOverButton(MapButton btn){
        this.mouseOverButton = btn;
    }

	public MapButton getMouseOverButton(){
		return this.mouseOverButton;
	}
	public MapButton getSelectedButton(){
		return this.selectedButton;
	}

	public void setView(Viewer view) {
		this.view = view;
	}

    public Viewer getView(){
        return view;
    }


	@Override
	public void update() {
		this.updateFieldButtons();
		if(selectedButton != null){
			selectedButton.setBackground(Color.YELLOW);
		}
		
		
	}
	
	

}
