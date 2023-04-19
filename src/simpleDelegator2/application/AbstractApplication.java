package simpleDelegator2.application;

import javax.swing.JFrame;

import org.omg.PortableInterceptor.DISCARDING;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import simpleDelegator2.frame.AbstractViewContainerFrame;

public abstract class AbstractApplication implements Application{
	private static final Logger logger = LoggerFactory.getLogger(AbstractApplication.class);
	JFrame frame;
	//Application
	@Override
	public void close() {
		logger.info("close called");
		frame.dispose();
	    System.exit(0);
	}
	//Application
	@Override
	public void setVisible(boolean visible) {
		logger.info("set_visible_called:"+visible);
		JFrame frame = this.getRootView();
		
		if (frame != null){
			if (visible){
				frame.setVisible(visible);
				frame.repaint();
			} else {
				frame.setVisible(visible);
			}
		}else {
			logger.info("frame_is_null");
		}
	}
	
	//Application
	@Override
	public void setRootView(AbstractViewContainerFrame rootView) {
		logger.info("set_root_view_called");
		frame = rootView.getFrame();
		
		setVisible(true);
	
		
	}
	
	public JFrame getRootView() {		
		return this.frame;
	}
	public AbstractApplication(){
	
	}
}
