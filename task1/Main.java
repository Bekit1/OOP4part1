package task1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ship one = new Ship();
		for (int i = 0; i < 10; i++) {
			one.setCargo(new Box(i), i);
			
		}
		
		Ship two = new Ship();
		for (int i = 0; i < 10; i++) {
			two.setCargo(new Box(i+10), i);
			
		}
		Ship three = new Ship();
		for (int i = 0; i < 10; i++) {
			three.setCargo(new Box(i+20), i);
			
		}
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println(three.toString());
		Dock first = new Dock("first");
		Dock second = new Dock("second");
		Port port = new Port(first, second);
		UnloadingThread thread1 = new UnloadingThread(port, one);
		UnloadingThread thread2 = new UnloadingThread(port, two);
		UnloadingThread thread3 = new UnloadingThread(port, three);
		Thread threadOne = new Thread(thread1);
		Thread threadTwo = new Thread(thread2);
		Thread threadThree = new Thread(thread3);
		try {
			threadOne.start();
			threadTwo.start();
			threadThree.start();
			threadOne.join();
			threadTwo.join();
			threadThree.join();
		} catch (InterruptedException e) {
		}
		System.out.println(one.toString());
		System.out.println(two.toString());
		System.out.println(three.toString());

	}

}
