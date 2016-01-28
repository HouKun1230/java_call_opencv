package java_opencv_videostream;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class mainFrame extends JFrame {
	private JPanel container;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	mainFrame frame = new mainFrame();
                	//WeakReference<mainFrame> f = new WeakReference<mainFrame>(frame);            
                    frame.setVisible(true);
                    
                    ExecutorService pool = getThreadPool();
                    //WeakReference <cvThread> cvt = new cvThread();
                    
                    pool.submit(new cvThread(frame));
                    pool.shutdown();
              
                   // new cvThread().start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

	}
	
	public mainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 490);
        container = new JPanel();
        container.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(container);
        container.setLayout(null);
        
       
    }
	
	private static ExecutorService getThreadPool() {

        return Executors.newCachedThreadPool(new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });
        // return Executors.newCachedThreadPool();
        // return Executors.newFixedThreadPool(2);
        // return Executors.newSingleThreadExecutor();
    }

	
	public void paint(Graphics g){
        g = container.getGraphics();
        video v = new video();
        g.drawImage(v.getOneFrame(), 0, 0, this);
    }

}
