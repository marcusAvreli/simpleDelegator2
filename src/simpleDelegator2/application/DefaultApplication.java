package simpleDelegator2.application;

import simpleDelegator2.frame.DefaultViewContainerFrame;

public class DefaultApplication extends AbstractApplication{
	public DefaultApplication(){
						
		this.setRootView(new DefaultViewContainerFrame(this));
	}
	
}
