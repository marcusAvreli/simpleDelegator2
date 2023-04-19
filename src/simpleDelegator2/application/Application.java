package simpleDelegator2.application;

import simpleDelegator2.frame.AbstractViewContainerFrame;

public interface Application {
public void close();
public void setVisible(boolean visible);
public abstract void setRootView(AbstractViewContainerFrame rootView);
}
