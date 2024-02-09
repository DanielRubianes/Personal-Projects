
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame; 


public class Application extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static final String title = "Platformer";
	
	public Application() {

        initUI();
    }

    private void initUI() {
    	
        add(new Game());
        
        setResizable(true);
        setSize(1200, 800);

        setTitle(title);
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
