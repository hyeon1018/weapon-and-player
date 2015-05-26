package Frame;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Map.*;


public class MapPanel extends JPanel implements MouseListener, Viewer{
	//나중에 수정하던지 하세요.
	private MapButton [][] fieldBtn = new MapButton[10][10];
	private int selectedX, selectedY;
	private int mouseOverX, mouseOverY;
	private Viewer view;
	private Player player;
	private Map map;

	public MapPanel(Map map, Player player){
		this.player = player;
		this.map = map;
		
		
		for(int i = 0 ; i < 10 ; i ++){
			for(int j = 0 ; j < 10 ; j++){
				fieldBtn[i][j] = new MapButton(map.getField(i, j));
				fieldBtn[i][j].addMouseListener(this);
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

	public int getMouseOverX(){
		return this.mouseOverX;
	}

	public int getMouseOverY(){
		return this.mouseOverY;
	}

	public int getSelectedX(){
		return this.selectedX;
	}

	public int getSelectedY(){
		return this.selectedY;
	}

	public void setView(Viewer view) {
		this.view = view;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0 ; i < 10 ; i++){
			for(int j = 0 ; j < 10 ; j++){
				if(e.getSource() == fieldBtn[i][j]){
					this.selectedX = i;
					this.selectedY = j;
				}
			}
		}
		//Test//System.out.println(selectedX + ", " + selectedY );
		view.update();
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		for(int i = 0 ; i < 10 ; i++){
			for(int j = 0 ; j < 10 ; j++){
				if(e.getSource() == fieldBtn[i][j]){
					this.mouseOverX = i;
					this.mouseOverY = j;
				}
			}
		}
		//Test//System.out.println(mouseOverX + ", " + mouseOverY );
		view.update();
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void update() {
		this.updateSight();
	}
	
	

}
