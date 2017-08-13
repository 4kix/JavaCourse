package view;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JProgressBar;


public class ProgressView {

	private JProgressBar progressBar;
	private JFrame frame;
	
	public ProgressView() {
		progressBar = new JProgressBar();
		frame = new JFrame("Progress");
		frame.setLayout(new BorderLayout());
		progressBar.setStringPainted(true);
	}
	
	/**
	 * sets frame size and launches frame 
	 */
	public void launchFrame() {
		
		frame.add(progressBar, BorderLayout.CENTER);
		frame.setSize(400, 80);

		frame.setVisible(true);
	}
	
	/**
	 * method smoothly sets progress bar value and calls {@link #refresh()} method
	 * @param progress percentage of executed tasks
	 */
	public void setProgress(int progress) {
		for (int i = progressBar.getValue(); i < progress; i++) {
			progressBar.setValue(i);
			refresh();
			try {	
				Thread.sleep(45);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * refreshes frame
	 */
	public void refresh() {
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
}
