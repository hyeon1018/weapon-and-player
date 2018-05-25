package Frame;
/**
 * Created by Lee on 2015-05-21.
 * Released 1.0 by Kim on 2015-06-01.
 */
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class MainFrame extends JFrame {


    /** Launch the application. **/
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->{
            try {
                MainFrame frame = new MainFrame();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }



    /** Create the frame. **/
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnStartGame = new JButton("StartGame");
        btnStartGame.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnStartGame.setBounds(170, 120, 160, 50);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectHeroObserver();
                dispose();
            }
        });
        contentPane.add(btnStartGame);

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnExit.setBounds(200, 190, 100, 50);
        contentPane.add(btnExit);

        JLabel lblGameName = new JLabel("Heroes of The World");
        lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblGameName.setBounds(50, 20, 400, 100);
        contentPane.add(lblGameName);
    }
}

