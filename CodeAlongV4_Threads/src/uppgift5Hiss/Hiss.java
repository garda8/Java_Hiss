
package uppgift5Hiss;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Hiss {
	private static int level = 0;
	private static int max = 10;
	private static int min = 0;
	private static boolean goingDown = false;
	
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	
	
	
	Queue<Person> pQueue = new LinkedList<Person>();

	public void moveMe(Person p) throws InterruptedException{
		pQueue.add(p);
		move();		
	}
	/*public void moveUp(Person p) throws InterruptedException{
		pQueue.add(p);
		move();
		
	}
	
	public void moveDown(Person p) throws InterruptedException{
		pQueue.add(p);
		move();
	}*/
	
	public void move() throws InterruptedException{
		//try{
			//lock.writeLock();
			while (!pQueue.isEmpty()){
				Person p = pQueue.remove();
				if (level!=p.getStart()){
					System.out.println("Ska åka från "+level + " till våning "+p.getStart());
					Thread.sleep(3000);
				}
				System.out.println("Dörren öppnas på våning "+p.getStart()+ " för person "+p.getName() 
				+" som ska till våning "+p.getTarget());
				Thread.sleep(3000);
				System.out.println("Dörren stängs och transport till våning "+p.getTarget() +" med person "+p.getName() + " i tråd "
						+Thread.currentThread().getName() );
				Thread.sleep(3000);
				System.out.println("Dörren öppnas på våning "+p.getTarget() +" för person " +p.getName());
				level = p.getTarget();
				Thread.sleep(3000);
			}
		//}	
		/*finally{
				lock.readLock();
		}*/	
		//System.out.println("Kön är tom..");
	}
	
	
	/*public void moveUp(int levels) throws InterruptedException{
		if (level+levels>max){
			System.out.println("Kan inte åka från våning "+ level +" och upp "+levels +" våningar"
					+ "");
		}
		else{
			System.out.println("Dörren öppnas på våning:" +level);
			Thread.sleep(2000);
			level+=levels;
			System.out.println("Dörren öppnas på våning:" +level);
			//openAndShutDoor();
		}
	}
	
	public void moveDown(int levels) throws InterruptedException{
		if (level-levels<min){
			System.out.println("Kan inte åka så långt ned");
		}
		else{
			System.out.println("Dörren öppnas på våning:" +level);
			Thread.sleep(2000);
			level-=levels;
			System.out.println("Dörren öppnas på våning:" +level);
			
			//openAndShutDoor();
		}
	}
	
	public void openAndShutDoor() throws InterruptedException{
		Thread.sleep(2000);
		Thread.sleep(500);
	}
	
	public static void main(String[] args) throws InterruptedException {
		Hiss hiss = new Hiss();
		hiss.moveUp(1);
		hiss.moveUp(1);
		hiss.moveDown(1);
	}*/
	/*
	private Lock lock = new ReentrantLock(true);
	private volatile int count = 0;
	
	public void inc(){
		lock.lock();
		try{
			count +=1;
			System.out.println(count);
		}
		finally{
			lock.unlock();
		}
	}*/
}
