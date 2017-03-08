package task1;

public class Box {
private double weight;
private String cargo;
private int number;
public Box(double weight, String cargo, int number) {
	super();
	this.weight = weight;
	this.cargo = cargo;
	this.number=number;
}

public Box(int number) {
	super();
	this.number = number;
}

public Box() {
	super();
}
public double getWeight() {
	return weight;
}
public void setWeight(double weight) {
	this.weight = weight;
}
public String getCargo() {
	return cargo;
}
public void setCargo(String cargo) {
	this.cargo = cargo;
}

public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
@Override
public String toString() {
	return "Box "+number;
}

}
