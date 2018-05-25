package Frame;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Map.Player;


public class FinalFrame extends JFrame{
	
	private JPanel contentPane;
	private FinalObserver ob;
	private boolean result = false;  //이거 앞에서 승패 결과값을 플레이어 별로 받아와야 할거같엉
	private boolean pressrestart = false;
	
	public FinalFrame(Player player, boolean isWinner){
        this.result = isWinner;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnRestartgame = new JButton("RestartGame");
        btnRestartgame.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnRestartgame.setBounds(170, 120, 160, 50);
        btnRestartgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pressrestart = true;
                ob.updateViewers();
            }
        });
        contentPane.add(btnRestartgame);

        JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button.setBounds(200, 190, 100, 50);
        contentPane.add(button);

        if(result==true){
        JLabel lblGameName = new JLabel("Winner");
        lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblGameName.setBounds(50, 20, 400, 100);
        contentPane.add(lblGameName);
        }
        else {
        	JLabel lblGameName = new JLabel("Loser");
            lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
            lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 35));
            lblGameName.setBounds(50, 20, 400, 100);
            contentPane.add(lblGameName);
        }

        this.setVisible(true);
    }
	
	public boolean ispressed(){
    	return pressrestart;
    }

    public void setObserver(FinalObserver fb){
        this.ob = fb;
    }
}



