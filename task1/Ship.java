package task1;

import java.util.Arrays;

public class Ship {
private Box [] cargo=new Box[10];
private String name;
public Ship(Box[] cargo, String name) {
	super();
	this.cargo = cargo;
	this.name = name;
}
public Ship() {
	super();
}
public Box[] getCargo() {
	return cargo;
}
public void setCargo(Box cargo, int i) {
	this.cargo[i] = cargo;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Ship [cargo=" + Arrays.toString(cargo);
}

}
