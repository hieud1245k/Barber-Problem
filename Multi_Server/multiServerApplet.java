package Multi_Server;

import java.awt.*;
import java.applet.*;

public class multiServerApplet extends Applet {
	protected TextArea txt_;
	protected simulationQueue q_;
	protected server s_[] = new server[3];
	protected arrival a_;

	public multiServerApplet() {
		txt_ = new TextArea(40, 40);
		q_ = new simulationQueue();
		s_[0] = new server(q_, txt_, 6500.0, 0);
		s_[1] = new server(q_, txt_, 6500.0, 1);
		s_[2] = new server(q_, txt_, 6500.0, 2);
		a_ = new arrival(q_, txt_, 1000.0);
	}

	public void init() {
		add(txt_); // add text area to applet display
	}

	public void start() {
		new Thread(s_[0]).start();
		new Thread(s_[1]).start();
		new Thread(s_[2]).start();
		new Thread(a_).start();
	}
}