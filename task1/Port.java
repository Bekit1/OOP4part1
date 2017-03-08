package task1;

import java.util.Arrays;

public class Port {
private Dock[] docks;

public Port(Dock ...docks) {
	super();
	this.docks = docks;
}

public Port() {
	super();
}

public Dock[] getDocks() {
	return docks;
}

public void setDocks(Dock[] docks) {
	this.docks = docks;
}

@Override
public String toString() {
	return "Port [docks=" + Arrays.toString(docks) + "]";
}

}
