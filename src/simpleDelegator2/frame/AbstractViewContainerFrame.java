package simpleDelegator2.frame;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleDelegator2.application.Application;

public abstract class AbstractViewContainerFrame 
{
	private static final Logger logger = LoggerFactory.getLogger(AbstractViewContainerFrame.class);
	private JFrame frame;
	private Application 							application;
	public Application getApplication() {
		return application;
	}




	public void setApplication(Application application) {
		this.application = application;
	}




	/**
	 * 
	 */
	public AbstractViewContainerFrame(Application app){
		this.application=app;
	}


	

	/* (non-Javadoc)
	 * @see org.viewaframework.view.ViewContainerFrame#getFrame()
	 */
	public JFrame getFrame() {
		logger.info("get_frame_called");
		if (this.frame == null){
			logger.info("get_frame_init");
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();     
			GraphicsDevice 		gd = ge.getDefaultScreenDevice();
			this.frame = new JFrame("FRAME");
			//TODO
			this.frame.getContentPane().setLayout(new BorderLayout());
			
			this.frame.setName("FRAME");
			this.frame.addWindowListener(new WindowAdapter(){
				@Override
				public void windowClosing(WindowEvent arg0) {				
					getApplication().close();
				}
			});
			this.frame.setBounds(gd.getDefaultConfiguration().getBounds());		
			this.frame.setLocationByPlatform(true);
		
			
			
		}
		return this.frame;
	}

	
	
}