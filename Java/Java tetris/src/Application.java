import java.awt.EventQueue;

import javax.swing.JFrame; 


public class Application extends JFrame {
	private static final long serialVersionUID = 1L;

	public Application() {

        initUI();
    }

    private void initUI() {
        add(new Game());

        
        setResizable(false);
        setSize(415, 847);

        setTitle("Java Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Application ex = new Application();
            ex.setVisible(true);
        });
    }
}
