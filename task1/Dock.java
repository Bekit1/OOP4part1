package task1;

import java.util.Arrays;

public class Dock {
	private Box[] cargo=new Box[30];
	private boolean busy = false;
	private String name;
	private int i=0;
	private int switcher=0;

	public Dock(Box... cargo) {
		super();
		this.cargo = cargo;

	}

	public Dock(String name) {
		super();
		this.name=name;
	}
	

	public Dock() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSwitcher() {
		return switcher;
	}

	public void setSwitcher(int switcher) {
		this.switcher = switcher;
	}

	public Box[] getCargo() {
		return cargo;
	}

	public synchronized void setCargo(Box cargo) {
		switcher=1;
		for (; busy == true;) {
			try {
				
				wait();
			} catch (InterruptedException e) {
			}
		}
		this.cargo[i] = cargo;
		i++;
		try {
			Thread.sleep(500);
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		busy = false;
		switcher=0;
		System.out.println("Send cargo to-> "+name +" "+Thread.currentThread().getName()+" "+ this.cargo[i-1]);
		notifyAll();
		
		
	}

	public boolean isBusy() {
		return busy;
	}

	public void setBusy(boolean busy) {
		this.busy = busy;
	}

	@Override
	public String toString() {
		return "Dock [cargo=" + Arrays.toString(cargo) + "]";
	}

}
