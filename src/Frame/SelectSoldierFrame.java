package Frame;
/**
 * Created by Lee on 2015-05-21.
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import Map.*;
import Soldier.Soldier;
import Soldier.Weapon;

//View 구현
public class SelectSoldierFrame extends JFrame implements Viewer, MouseListener{
	
	
	//Component
	//Component to global variable;
    private JPanel contentPane;
    private JPanel continuePanel;
    private JPanel mainPanel;
    
    private MapPanel fieldPanel;
    //InfoPanel
    private JPanel infoPanel;
    private JLabel [] resLables = new JLabel[2];
    private JLabel [] infoLables= new JLabel[7];
    //Select Soldier Button Panel;
    private JPanel selectSoldierPanel;
    private SoldierButton [] soldierBtn = new SoldierButton[6];
    
    private JPanel unberPanel;
    private JButton continueBtn;
    //영웅 정보 패널
    private JPanel heroInfoPanel;
    private JLabel [] heroLables = new JLabel[3];
    
    //Fields <variables>
    //Observer 추가;
    private boolean selected;
    private Observer ob;
    private Map map;
    Player player;
    private Soldier selectedSoldier;
    
    
    /** Create the frame. **/
    public SelectSoldierFrame(Map map, Player player) {
    	this.player = player;
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        mainPanel = new JPanel();
        contentPane.add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new BorderLayout(0, 0));

        //MapPanel 로 외부 의존; 2015-05-25
        fieldPanel = new MapPanel(map, player);
        mainPanel.add(fieldPanel, BorderLayout.CENTER);
        fieldPanel.setView(this);
        fieldPanel.updateFieldButtons();
        
        infoPanel = new JPanel();
        mainPanel.add(infoPanel, BorderLayout.WEST);
        GridBagLayout gbl_infoPanel = new GridBagLayout();
        gbl_infoPanel.columnWidths = new int[] {100};
        gbl_infoPanel.rowHeights = new int[] {30, 30, 189, 30, 30, 30, 30, 30, 30, 30, 0};
        gbl_infoPanel.columnWeights = new double[]{0.0};
        gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        infoPanel.setLayout(gbl_infoPanel);

        resLables[0] = new JLabel("필요 자원 : 0");
        resLables[0].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_maxRes = new GridBagConstraints();
        gbc_maxRes.insets = new Insets(0, 0, 5, 0);
        gbc_maxRes.gridx = 0;
        gbc_maxRes.gridy = 0;
        infoPanel.add(resLables[0], gbc_maxRes);

        resLables[1] = new JLabel("최대 자원 : " + Integer.toString(player.getMaxRes()));
        resLables[1].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_curRes = new GridBagConstraints();
        gbc_curRes.insets = new Insets(0, 0, 5, 0);
        gbc_curRes.gridx = 0;
        gbc_curRes.gridy = 1;
        infoPanel.add(resLables[1], gbc_curRes);

        infoLables[0] = new JLabel("이름");
        infoLables[0].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoWeapon = new GridBagConstraints();
        gbc_infoWeapon.insets = new Insets(0, 0, 5, 0);
        gbc_infoWeapon.gridx = 0;
        gbc_infoWeapon.gridy = 3;
        infoPanel.add(infoLables[0], gbc_infoWeapon);

        infoLables[1] = new JLabel("HP : ");
        GridBagConstraints gbc_infoHp = new GridBagConstraints();
        gbc_infoHp.insets = new Insets(0, 0, 5, 0);
        gbc_infoHp.gridx = 0;
        gbc_infoHp.gridy = 4;
        infoPanel.add(infoLables[1], gbc_infoHp);

        infoLables[2] = new JLabel("Move : ");
        GridBagConstraints gbc_infoMove = new GridBagConstraints();
        gbc_infoMove.insets = new Insets(0, 0, 5, 0);
        gbc_infoMove.gridx = 0;
        gbc_infoMove.gridy = 5;
        infoPanel.add(infoLables[2], gbc_infoMove);

        infoLables[3] = new JLabel("공격력 : ");
        infoLables[3].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoAttack = new GridBagConstraints();
        gbc_infoAttack.insets = new Insets(0, 0, 5, 0);
        gbc_infoAttack.gridx = 0;
        gbc_infoAttack.gridy = 6;
        infoPanel.add(infoLables[3], gbc_infoAttack);

        infoLables[4] = new JLabel("방어력 : ");
        infoLables[4].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoDefend = new GridBagConstraints();
        gbc_infoDefend.insets = new Insets(0, 0, 5, 0);
        gbc_infoDefend.gridx = 0;
        gbc_infoDefend.gridy = 7;
        infoPanel.add(infoLables[4], gbc_infoDefend);

        infoLables[5] = new JLabel("시야거리 : ");
        infoLables[5].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoSight = new GridBagConstraints();
        gbc_infoSight.insets = new Insets(0, 0, 5, 0);
        gbc_infoSight.gridx = 0;
        gbc_infoSight.gridy = 8;
        infoPanel.add(infoLables[5], gbc_infoSight);

        infoLables[6] = new JLabel("사정거리 : ");
        infoLables[6].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoRange = new GridBagConstraints();
        gbc_infoRange.gridx = 0;
        gbc_infoRange.gridy = 9;
        infoPanel.add(infoLables[6], gbc_infoRange);


        selectSoldierPanel = new JPanel();
        mainPanel.add(selectSoldierPanel, BorderLayout.SOUTH);

        
        soldierBtn[0] = new SoldierButton("검병");
        soldierBtn[0].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[0].addMouseListener(this);
        soldierBtn[0].setSoldier(new Soldier(Weapon.sword, null));
        selectSoldierPanel.add(soldierBtn[0]);

        soldierBtn[1] = new SoldierButton("창병");
        soldierBtn[1].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[1].addMouseListener(this);
        soldierBtn[1].setSoldier(new Soldier(Weapon.lance, null));
        selectSoldierPanel.add(soldierBtn[1]);

        soldierBtn[2] = new SoldierButton("궁병");
        soldierBtn[2].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[2].addMouseListener(this);
        soldierBtn[2].setSoldier(new Soldier(Weapon.bow, null));
        selectSoldierPanel.add(soldierBtn[2]);

        soldierBtn[3] = new SoldierButton("기마병");
        soldierBtn[3].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[3].addMouseListener(this);
        soldierBtn[3].setSoldier(new Soldier(Weapon.horse, null));
        selectSoldierPanel.add(soldierBtn[3]);

        soldierBtn[4] = new SoldierButton("정찰병");
        soldierBtn[4].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[4].addMouseListener(this);
        soldierBtn[4].setSoldier(new Soldier(Weapon.scout, null));
        selectSoldierPanel.add(soldierBtn[4]);
        
        soldierBtn[5] = new SoldierButton("취소");
        soldierBtn[5].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[5].addMouseListener(this);
        soldierBtn[5].setSoldier(null);
        selectSoldierPanel.add(soldierBtn[5]);
        
        
        selectedSoldier = null;

        unberPanel = new JPanel();
        contentPane.add(unberPanel, BorderLayout.SOUTH);
        unberPanel.setLayout(new BorderLayout(0, 0));

        continuePanel = new JPanel();
        FlowLayout fl_continuePanel = (FlowLayout) continuePanel.getLayout();
        fl_continuePanel.setAlignment(FlowLayout.RIGHT);
        unberPanel.add(continuePanel, BorderLayout.EAST);

        continueBtn = new JButton("준비 완료.");
        continuePanel.add(continueBtn);
        continueBtn.setHorizontalAlignment(SwingConstants.LEFT);

        heroInfoPanel = new JPanel();
        unberPanel.add(heroInfoPanel, BorderLayout.CENTER);

        heroLables[0] = new JLabel("내 영웅 : " + player.getHero().getName());
        heroLables[0].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        heroInfoPanel.add(heroLables[0]);

        heroLables[1] = new JLabel("vs");
        heroInfoPanel.add(heroLables[1]);

        heroLables[2] = new JLabel("적 영웅 : " );
        heroLables[2].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        heroInfoPanel.add(heroLables[2]);
        if(player.getClass() == P2.class){
			heroLables[2].setText("적 영웅 : " + map.getP1().getHero().getName());
		}
        else if(player.getClass() == P1.class){
			heroLables[2].setText("적 영웅 : " + map.getP2().getHero().getName());
		}
        
        this.setVisible(true);
    }


	public void updateInfoLable(){
		if(selectedSoldier == null){
			infoLables[0].setText("이름");
			infoLables[1].setText("HP : ");
			infoLables[2].setText("MP : ");
			infoLables[3].setText("공격력 : ");
			infoLables[4].setText("방어력 : ");
			infoLables[5].setText("시야거리 : ");
			infoLables[6].setText("사거리 : ");
		}
		else{
			infoLables[0].setText(selectedSoldier.getName());
			infoLables[1].setText("HP : " + Integer.toString(selectedSoldier.getMaxHP()));
			infoLables[2].setText("MP : " + Integer.toString(selectedSoldier.getMaxMP()));
			infoLables[3].setText("공격력 : " + Integer.toString(selectedSoldier.getWeapon().getDamage()));
			infoLables[4].setText("방어력 : " + Integer.toString(selectedSoldier.getDefense()));
			infoLables[5].setText("시야거리 : " + Integer.toString(selectedSoldier.getWeapon().getSight()));
			infoLables[6].setText("사거리 : " + Integer.toString(selectedSoldier.getWeapon().getRange()));
		}
	}
	
	public void editSoldier(){
		//Remove if Soldier is already;
		if(fieldPanel.getSelectedButton().getField().getSoldier() != null){
			player.removeSoldier(fieldPanel.getSelectedButton().getField().getSoldier());
			fieldPanel.getSelectedButton().getField().setSoldier(null);
		}
		
		//Add if Selected Soldier is not null;
		if(selectedSoldier != null){
			Soldier newsol = new Soldier(selectedSoldier.getWeapon().getType(), player);
			fieldPanel.getSelectedButton().getField().setSoldier(newsol);
			player.addSoldier(newsol);
		}
		
		selectedSoldier = null;
		fieldPanel.setSelectedButton(null);
		
		
		
	}
	
	public void updateResLabel(){
		resLables[0].setText("필요 자원 : " + Integer.toString(player.getCurRes()));
	}
	
	public void updateFieldPanel(){
		fieldPanel.update();
	}
	
	@Override
	public void update() {
		updateInfoLable();
		updateResLabel();
		updateFieldPanel();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		selectedSoldier = ((SoldierButton)(e.getSource())).getSoldier();
		
		if(fieldPanel.getSelectedButton() != null){
			editSoldier();
		}
		
		update();
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}

	
	
	class SoldierButton extends JButton{
		Soldier soldier;
		int SoldierNumber;
		public SoldierButton(String string) {
			super(string);
		}
		void setSoldier(Soldier sol){
			this.soldier = sol;
		}
		Soldier getSoldier(){
			return this.soldier;
		}
	}
}
