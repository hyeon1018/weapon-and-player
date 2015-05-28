package Frame;
/**
 * Created by Lee on 2015-05-21.
 */
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

import Map.Map;
import Map.P1;
import Map.P2;
import Map.Player;
import Soldier.Soldier;

//View 구현
public class SelectSoldierFrame extends JFrame implements Viewer, MouseListener{
	
	//Component
	//Component to global variable;
    private JPanel contentPane;
    private JPanel continuePanel;
    private JPanel mainPanel;
    private MapPanel filedPanel;
    private JPanel infoPanel;
    private JLabel maxRes;
    private JLabel curRes;
    private JLabel infoWeapon;
    private JLabel infoHp;
    private JLabel infoMove;
    private JLabel infoAttack;
    private JLabel infoDefend;
    private JLabel infoSight;
    private JLabel infoRange;
    private JPanel selectSoldierPanel;
    //Make Button to Array
    private JButton [] soldierBtn = new JButton[5];
    private JPanel unberPanel;
    private JButton continueBtn;
    private JPanel heroInfoPanel;
    private JLabel myHeroLabel;
    private JLabel vsLabel;
    private JLabel oppHeroLabel;
    
    //Fields <variables>
    //Observer 추가;
    private boolean selected;
    private Observer ob;
    private Map map;
    Player player;
    Soldier [] solList = new Soldier[5];
    private int mouseOverSoldier;
    private int selectedSoldier;
    
    
    
    /** Create the frame. **/
    public SelectSoldierFrame(Map map, Player player) {
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
        filedPanel = new MapPanel(map, player);
        mainPanel.add(filedPanel, BorderLayout.CENTER);
        filedPanel.setView(this);
        filedPanel.updateSight();
        
        infoPanel = new JPanel();
        mainPanel.add(infoPanel, BorderLayout.WEST);
        GridBagLayout gbl_infoPanel = new GridBagLayout();
        gbl_infoPanel.columnWidths = new int[] {100};
        gbl_infoPanel.rowHeights = new int[] {30, 30, 189, 30, 30, 30, 30, 30, 30, 30, 0};
        gbl_infoPanel.columnWeights = new double[]{0.0};
        gbl_infoPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        infoPanel.setLayout(gbl_infoPanel);

        maxRes = new JLabel("필요 자원 : 0");
        maxRes.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_maxRes = new GridBagConstraints();
        gbc_maxRes.insets = new Insets(0, 0, 5, 0);
        gbc_maxRes.gridx = 0;
        gbc_maxRes.gridy = 0;
        infoPanel.add(maxRes, gbc_maxRes);

        curRes = new JLabel("최대 자원 : " + Integer.toString(player.getMaxRes()));
        curRes.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_curRes = new GridBagConstraints();
        gbc_curRes.insets = new Insets(0, 0, 5, 0);
        gbc_curRes.gridx = 0;
        gbc_curRes.gridy = 1;
        infoPanel.add(curRes, gbc_curRes);

        infoWeapon = new JLabel("검병");
        infoWeapon.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoWeapon = new GridBagConstraints();
        gbc_infoWeapon.insets = new Insets(0, 0, 5, 0);
        gbc_infoWeapon.gridx = 0;
        gbc_infoWeapon.gridy = 3;
        infoPanel.add(infoWeapon, gbc_infoWeapon);

        infoHp = new JLabel("HP : 100");
        GridBagConstraints gbc_infoHp = new GridBagConstraints();
        gbc_infoHp.insets = new Insets(0, 0, 5, 0);
        gbc_infoHp.gridx = 0;
        gbc_infoHp.gridy = 4;
        infoPanel.add(infoHp, gbc_infoHp);

        infoMove = new JLabel("Move : 2");
        GridBagConstraints gbc_infoMove = new GridBagConstraints();
        gbc_infoMove.insets = new Insets(0, 0, 5, 0);
        gbc_infoMove.gridx = 0;
        gbc_infoMove.gridy = 5;
        infoPanel.add(infoMove, gbc_infoMove);

        infoAttack = new JLabel("공격력 : 40");
        infoAttack.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoAttack = new GridBagConstraints();
        gbc_infoAttack.insets = new Insets(0, 0, 5, 0);
        gbc_infoAttack.gridx = 0;
        gbc_infoAttack.gridy = 6;
        infoPanel.add(infoAttack, gbc_infoAttack);

        infoDefend = new JLabel("방어력 : 0");
        infoDefend.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoDefend = new GridBagConstraints();
        gbc_infoDefend.insets = new Insets(0, 0, 5, 0);
        gbc_infoDefend.gridx = 0;
        gbc_infoDefend.gridy = 7;
        infoPanel.add(infoDefend, gbc_infoDefend);

        infoSight = new JLabel("시야거리 : 3");
        infoSight.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoSight = new GridBagConstraints();
        gbc_infoSight.insets = new Insets(0, 0, 5, 0);
        gbc_infoSight.gridx = 0;
        gbc_infoSight.gridy = 8;
        infoPanel.add(infoSight, gbc_infoSight);

        infoRange = new JLabel("사정거리 : 1");
        infoRange.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        GridBagConstraints gbc_infoRange = new GridBagConstraints();
        gbc_infoRange.gridx = 0;
        gbc_infoRange.gridy = 9;
        infoPanel.add(infoRange, gbc_infoRange);


        selectSoldierPanel = new JPanel();
        mainPanel.add(selectSoldierPanel, BorderLayout.SOUTH);

        
        solList[0] = new Soldier(1, 1);
        solList[1] = new Soldier(2, 1);
        solList[2] = new Soldier(3, 1);
        solList[3] = new Soldier(4, 1);
        solList[4] = new Soldier(5, 1);
        
        
        
        soldierBtn[0] = new JButton("검병");
        soldierBtn[0].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[0].addMouseListener(this);
        selectSoldierPanel.add(soldierBtn[0]);

        soldierBtn[1] = new JButton("창병");
        soldierBtn[1].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[1].addMouseListener(this);
        selectSoldierPanel.add(soldierBtn[1]);

        soldierBtn[2] = new JButton("궁병");
        soldierBtn[2].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[2].addMouseListener(this);
        selectSoldierPanel.add(soldierBtn[2]);

        soldierBtn[3] = new JButton("기마병");
        soldierBtn[3].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[3].addMouseListener(this);
        selectSoldierPanel.add(soldierBtn[3]);

        soldierBtn[4] = new JButton("정찰병");
        soldierBtn[4].setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        soldierBtn[4].addMouseListener(this);
        selectSoldierPanel.add(soldierBtn[4]);

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

        myHeroLabel = new JLabel("내 영웅 : " + player.getHero().getName());
        myHeroLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        heroInfoPanel.add(myHeroLabel);

        vsLabel = new JLabel("vs");
        heroInfoPanel.add(vsLabel);

        oppHeroLabel = new JLabel("적 영웅 : " );
        oppHeroLabel.setFont(new Font("Malgun Gothic", Font.PLAIN, 13));
        heroInfoPanel.add(oppHeroLabel);
        if(player.getClass() == P2.class){
			oppHeroLabel.setText("적 영웅 : " + map.getP1().getHero().getName());
		}
        else if(player.getClass() == P1.class){
			oppHeroLabel.setText("적 영웅 : " + map.getP2().getHero().getName());
		}
        
        
        this.setVisible(true);
    }

	@Override
	public void update() {
		infoWeapon.setText(solList[mouseOverSoldier].getName());
		infoHp.setText("HP : " + Integer.toString(solList[mouseOverSoldier].getMaxHP()));
		infoMove.setText("MP : " + Integer.toString(solList[mouseOverSoldier].getMaxMP()));
		infoAttack.setText("공격력 : " + Integer.toString(solList[mouseOverSoldier].getWeapon().getDamage()));
		infoDefend.setText("방어력 : " + Integer.toString(solList[mouseOverSoldier].getDefense()));
		infoSight.setText("시야거리 : " + Integer.toString(solList[mouseOverSoldier].getWeapon().getSight()));
		infoRange.setText("사거리 : " + Integer.toString(solList[mouseOverSoldier].getWeapon().getRange()));
		
		// TODO refresh cur_Res -> disable continue Button;
		
		
		
		filedPanel.update();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < soldierBtn.length ; i++){
			if(e.getSource() == soldierBtn[i]){
				selectedSoldier = i;
				// TODO make selected button in other color;
				
				
				update();
			}
		}
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO For문 구조를 사용하지 않도록 수정.		
		for(int i = 0 ; i < soldierBtn.length ; i++){
			if(e.getSource() == soldierBtn[i]){
				mouseOverSoldier = i;
				
				update();
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
