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
	private Field selectedField;
	private Field mouseOverField;
	private Viewer view;
	private Player player;
	private Map map;

	public MapPanel(Map map, Player player){
		this.player = player;
		this.map = map;
		selectedField = map.getField(0, 0);
		mouseOverField = map.getField(0, 0);
		
		
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
	
	public void updateSight(){
		if(player.getClass() == P1.class){
			for(int i = 0 ; i < 10 ; i++){
				for(int j = 0 ; j < 10 ; j++){
					fieldBtn[i][j].setVisible(fieldBtn[i][j].getField().isP1Visible());
				}
			}
		}
		else if(player.getClass() == P2.class){
			for(int i = 0 ; i < 10 ; i++){
				for(int j = 0 ; j < 10 ; j++){
					fieldBtn[i][j].setVisible(fieldBtn[i][j].getField().isP2Visible());
				}
			}
		}
	}
	

	public void setEnableOppSide(boolean enable){
		if(player.getClass() == P1.class){
			for(int i = 0; i < 10 ; i++){
				for(int j = 2 ; j < 10 ; j++){
					fieldBtn[i][j].setEnabled(enable);
				}
			}
		}
		
		else if(player.getClass() == P2.class){
			for(int i = 0; i < 10 ; i++){
				for(int j = 7 ; j >= 0 ; j--){
					fieldBtn[i][j].setEnabled(enable);
				}
			}
		}
	}

    public void setSelectedField(Field f){
        this.selectedField = f;
    }
    public void setMouseOverField(Field f){
        this.mouseOverField = f;
    }

	public Field getMouseOverField(){
		return this.mouseOverField;
	}
	public Field getSelectedField(){
		return this.selectedField;
	}

	public void setView(Viewer view) {
		this.view = view;
	}

    public Viewer getView(){
        return view;
    }


	@Override
	public void update() {
		this.updateSight();
	}
	
	

}
