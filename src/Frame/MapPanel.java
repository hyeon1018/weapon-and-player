package Frame;

import Map.*;
import javax.swing.*;
import java.awt.*;


public class MapPanel extends JPanel implements Viewer{

    //Object Variable
	private MapButton [][] fieldBtn = new MapButton[10][10];
	private MapButton selectedButton, mouseOverButton, metaClickedButton;
	private Viewer view;
	private Player player;
	private Map map;

    //Constructor
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

    //update All MapButtons
	public void updateFieldButtons(){
		for(int i = 0 ; i < 10 ; i++){
			for(int j = 0 ; j < 10 ; j++){
				fieldBtn[i][j].updateBtn(player);
			}
		}
	}

	public MapButton getSelectedButton(){
		return this.selectedButton;
	}

    //Getter, Setter
    public void setSelectedButton(MapButton btn){
        this.selectedButton = btn;
    }

	public MapButton getMouseOverButton(){
		return this.mouseOverButton;
	}

    public void setMouseOverButton(MapButton btn){
        this.mouseOverButton = btn;
    }

	public MapButton getMetaClickedButton()
	{
		return metaClickedButton;
	}

	public void setMetaClickedButton(MapButton btn)
	{
		this.metaClickedButton = btn;
	}

    public Viewer getView(){
        return view;
    }

    public void setView(Viewer view) {
        this.view = view;
    }

	@Override
	public void update() {
		this.updateFieldButtons();

        if(metaClickedButton != null){
            metaClickedButton.setBackground(Color.CYAN);
        }

		if(selectedButton != null){
			selectedButton.setBackground(Color.YELLOW);
		}

	}
	
	

}
