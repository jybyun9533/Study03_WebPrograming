package servlet.controller;

public class ModelAndView {
	private String path;
	private boolean isRedirect;

	public ModelAndView() {
		super();
	}

	public ModelAndView(String path) {
		super();
		this.path = path;
	}

	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	@Override
	public String toString() {
		return "ModelAnView [path=" + path + ", isRedirect=" + isRedirect + "]";
	}

}
