package task1;

public class UnloadingThread implements Runnable {
	private Port port;
	private Ship ship;

	public UnloadingThread(Port port, Ship ship) {
		super();
		this.port = port;
		this.ship = ship;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < ship.getCargo().length; i++) {
			if(port.getDocks()[0].getSwitcher()==1){
				port.getDocks()[1].setCargo(ship.getCargo()[i]);
				ship.setCargo(null,i);
				port.getDocks()[1].setBusy(false);
			}else{
				port.getDocks()[0].setCargo(ship.getCargo()[i]);
				ship.setCargo(null,i);
				port.getDocks()[0].setBusy(false);
			}
		}
		
	}
}
