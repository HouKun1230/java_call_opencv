package java_opencv_videostream;

import java.lang.ref.WeakReference;

public class cvThread implements Runnable {
	
	private WeakReference<mainFrame> wm;
	
	public cvThread(mainFrame m)
	{
		wm = new WeakReference<mainFrame>(m);
		
	}

	public void run() {
        for (;;){
        	//mainFrame m = new mainFrame();
            wm.get().repaint();
            try { Thread.sleep(30);
            } catch (InterruptedException e) {    }
        }  
    } 
}
