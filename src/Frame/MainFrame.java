package Frame;
/**
 * Created by Lee on 2015-05-21.
 */import java.awt.BorderLayout;
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

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame frame = new MainFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /** Create the frame. **/
    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnStartgame = new JButton("StartGame");
        btnStartgame.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnStartgame.setBounds(170, 120, 160, 50);
        btnStartgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SelectHeroObserver();
                dispose();
            }
        });
        contentPane.add(btnStartgame);

        JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 15));
        button.setBounds(200, 190, 100, 50);
        contentPane.add(button);

        JLabel lblGameName = new JLabel("Heroes of The World");
        lblGameName.setHorizontalAlignment(SwingConstants.CENTER);
        lblGameName.setFont(new Font("Tahoma", Font.PLAIN, 35));
        lblGameName.setBounds(50, 20, 400, 100);
        contentPane.add(lblGameName);
    }
}

