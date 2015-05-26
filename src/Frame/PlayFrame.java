package Frame;
/**
 * Created by Lee on 2015-05-21.
 */ import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Map.Map;
import Map.P1;
import Map.P2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Add viewer to update;
public class PlayFrame extends JFrame implements Viewer{

    private JPanel contentPane;
    //Replace to MapPanel
    MapPanel mapPanel = new MapPanel(new Map(), new P1());
    private JLabel lblSoldierClass = new JLabel("X : null, Y : null");
    JLabel lblHp = new JLabel("X : null, Y : null");
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PlayFrame frame = new PlayFrame();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /** Create the frame. **/
    public PlayFrame() {
        super("PlayFrame");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        
        contentPane.add(mapPanel, BorderLayout.CENTER);
        mapPanel.setView(this);


        JPanel panel_2 = new JPanel();
        contentPane.add(panel_2, BorderLayout.SOUTH);

        JButton btnNewButton_3 = new JButton("Move");
        panel_2.add(btnNewButton_3);

        JButton btnNewButton_2 = new JButton("Attack");
        panel_2.add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("Wait");
        panel_2.add(btnNewButton_1);

        JButton btnNewButton = new JButton("End Turn");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel_2.add(btnNewButton);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.WEST);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[] {100};
        gbl_panel_1.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 0};
        gbl_panel_1.columnWeights = new double[]{0.0};
        gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        
        GridBagConstraints gbc_lblSoldierClass = new GridBagConstraints();
        gbc_lblSoldierClass.insets = new Insets(0, 0, 5, 0);
        gbc_lblSoldierClass.gridx = 0;
        gbc_lblSoldierClass.gridy = 0;
        panel_1.add(lblSoldierClass, gbc_lblSoldierClass);

        
        GridBagConstraints gbc_lblHp = new GridBagConstraints();
        gbc_lblHp.insets = new Insets(0, 0, 5, 0);
        gbc_lblHp.gridx = 0;
        gbc_lblHp.gridy = 1;
        panel_1.add(lblHp, gbc_lblHp);

        JLabel lblMove = new JLabel("Move : 2/2");
        GridBagConstraints gbc_lblMove = new GridBagConstraints();
        gbc_lblMove.insets = new Insets(0, 0, 5, 0);
        gbc_lblMove.gridx = 0;
        gbc_lblMove.gridy = 2;
        panel_1.add(lblMove, gbc_lblMove);

        JLabel lblNewLabel_2 = new JLabel("공격력 : 40");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 6;
        panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("방어력 : 0");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 7;
        panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("시야거리 : 3");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 8;
        panel_1.add(lblNewLabel, gbc_lblNewLabel);

        JLabel label = new JLabel("사정거리 : 1");
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.gridx = 0;
        gbc_label.gridy = 9;
        panel_1.add(label, gbc_label);

        setVisible(true);
    }
   

	@Override
	public void update() {
		this.lblSoldierClass.setText("X : " + Integer.toString(mapPanel.getSelectedX()) + ", Y : " + Integer.toString(mapPanel.getSelectedY()));
		this.lblHp.setText("X : " + Integer.toString(mapPanel.getMouseOverX()) + ", Y : " + Integer.toString(mapPanel.getMouseOverY()));
	}

}
