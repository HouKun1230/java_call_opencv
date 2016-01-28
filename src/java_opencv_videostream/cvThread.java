package java_opencv_videostream;

public class cvThread implements Runnable {

	public void run() {
        for (;;){
        	mainFrame m = new mainFrame();
            m.repaint();
            try { Thread.sleep(30);
            } catch (InterruptedException e) {    }
        }  
    } 
}
