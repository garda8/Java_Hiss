package uppgift5Hiss;

public class Person implements Runnable{

	private String name;
	private int start;
	private int target;
	private Hiss hiss;
	
	public Person(String n, int startLevel, int targetLevel, Hiss h){
		this.name = n;
		start = startLevel;
		target = targetLevel;
		hiss = h;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(hiss) {
			try {
				hiss.moveMe(this);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

}
