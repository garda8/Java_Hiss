package uppgift5Hiss;

public class Program {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Hiss hiss = new Hiss();
		
		//Person p1 = new Person("Kalle", 0, 2, hiss);
		Thread t1 = new Thread(new Person("Kalle", 0, 2, hiss));
		Thread t2 = new Thread(new Person("Lisa", 5, 0, hiss));
		Thread t3 = new Thread(new Person("Sven", 1, 5, hiss));
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(1000);
		t3.start();
		// for (int i=0; i<2; i++){
		/*
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					hiss.moveUp(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					hiss.moveDown(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		});
		t1.start();
		Thread.sleep(	1000);
		t2.start();
		// }
*/
	}

}
