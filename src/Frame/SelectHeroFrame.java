package Frame;
/**
 * Created by Lee on 2015-05-21.
 */

import Hero.*;
import Map.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SelectHeroFrame extends JFrame implements KeyListener{


	//Field
	private final Hero[] heroes = new Hero[8];
	//Component
	//김건휘 2015 - 05 - 25
	private JPanel contentPane;
	private JPanel heroInfo;
	private JLabel heroNamelbl;
	private JPanel heroImagepnl;
	private JLabel heroInfolbl1;
	private JLabel heroInfolbl2;
	private JLabel heroInfolbl3;
	private JButton buttonLeft;
	private JButton buttonRight;
	private JButton btnSelect;
	//  0 = 잔 다르크   1 = 알렉산드로스......
	private Player player;
	private Observer ob;
	private int currentHero;
	private boolean selected = false;



	/**
	 * Launch the application.
	 */
	public SelectHeroFrame(final Player player) {
		super("SelectHero");
        SetFont.setUIFont(new javax.swing.plaf.FontUIResource("Malgun Gothic",Font.PLAIN,13));
		currentHero = 0;

		heroes[0] = new Jeanne();
		heroes[1] = new Alex();
		heroes[2] = new Eulgi();
		heroes[3] = new Zhao();
		heroes[4] = new Huang();
		heroes[5] = new Oda();
		heroes[6] = new Hannibal();
		heroes[7] = new Gyebaek();
		this.player = player;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		heroInfo = new JPanel();
		contentPane.add(heroInfo, BorderLayout.CENTER);
		heroInfo.setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		heroInfo.add(panel_1);
		panel_1.setLayout(null);


		heroNamelbl = new JLabel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				setText(heroes[currentHero].getName());
			}
		};
		heroNamelbl.setHorizontalAlignment(SwingConstants.CENTER);
		heroNamelbl.setBounds(34, 5, 324, 25);
		heroNamelbl.setFont(new Font("휴먼고딕", Font.PLAIN, 20));
		panel_1.add(heroNamelbl);



		heroImagepnl = new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				Image image = heroes[currentHero].getImage();
				g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), 0,0, image.getWidth(null), image.getHeight(null), null);
			}
		};
		heroImagepnl.setBackground(Color.WHITE);
		heroImagepnl.setBounds(34, 38, 164, 177);
		panel_1.add(heroImagepnl);


		heroInfolbl1 = new JLabel("영웅 설명 1"){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setText(heroes[currentHero].getExplan1());
            }
        };
		heroInfolbl1.setBounds(34, 216, 324, 25);
		panel_1.add(heroInfolbl1);

		heroInfolbl2 = new JLabel("영웅 설명 2"){
            @Override
            protected void paintComponent(Graphics g) {
               super.paintComponent(g);
               setText(heroes[currentHero].getExplan2());
           }
       };
		heroInfolbl2.setBounds(34, 242, 324, 25);
		panel_1.add(heroInfolbl2);

		heroInfolbl3 = new JLabel("영웅 설명 3"){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setText(heroes[currentHero].getExplan3());
            }
        };
		heroInfolbl3.setBounds(34, 269, 324, 25);
		panel_1.add(heroInfolbl3);

		buttonLeft = new JButton("<");
        buttonLeft.addKeyListener(this);
		buttonLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goLeft();
			}
		});
		contentPane.add(buttonLeft, BorderLayout.WEST);

		buttonRight = new JButton(">");
        buttonRight.addKeyListener(this);
		buttonRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				goRight();
			}
		});
		contentPane.add(buttonRight, BorderLayout.EAST);

		btnSelect = new JButton("Select");
        btnSelect.addKeyListener(this);
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
                ready();
			}
		});
		contentPane.add(btnSelect, BorderLayout.SOUTH);


		setVisible(true);
	}

    private void goLeft(){
        if(selected){
            return;
        }
        if(currentHero > 0){
            currentHero--;
            contentPane.repaint();
        }
    }
    private void goRight(){
        if(selected){
            return;
        }
        if(currentHero < 7){
            currentHero++;
            contentPane.repaint();
        }
    }
    private void ready(){
        if(!selected){
            player.setHero(heroes[currentHero]);
            if(heroes[currentHero].getSoldier() != null){
                player.addSoldier(player.getHero().getSoldier());
            }
            player.getHero().setPlayer(player);

            selected = true;
            buttonLeft.setEnabled(false);
            buttonRight.setEnabled(false);
            btnSelect.setText("Cancel");
            ob.updateViewers();
        }
        else{
            player.setHero(null);
            player.removeSoldier(player.getHero().getSoldier());
            selected = false;
            buttonLeft.setEnabled(true);
            buttonRight.setEnabled(true);
            btnSelect.setText("Select");
        ob.updateViewers();
        }

        //김건휘 2015 05 25
        //Disable Test Code//System.out.println(player.getHero().getName());
        }

    //getter.
    public boolean isSelected(){
        return selected;
    }
    public void setObserver(Observer ob){
        this.ob = ob;
    }


    //KeyListener 구현
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            goLeft();
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            goRight();
        }

        if(e.getKeyCode() == KeyEvent.VK_F5){
            ready();
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
