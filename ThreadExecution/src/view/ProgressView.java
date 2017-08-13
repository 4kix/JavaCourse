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
	
	public void launchFrame() {
		
		frame.add(progressBar, BorderLayout.CENTER);
		frame.setSize(400, 80);

		frame.setVisible(true);
	}
	
	
	public void setProgress(int progress) {
		for (int i = progressBar.getValue(); i < progress; i++) {
			progressBar.setValue(i);
			try {
				Thread.sleep(45);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void refresh() {
		frame.invalidate();
		frame.validate();
		frame.repaint();
	}
	
}
