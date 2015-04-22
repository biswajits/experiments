package net.test;

public class ConcurrentThreads {

	public static void main(String[] args) {
		Runnable t1 = new Runnable() {
			public void run() {
				for (int i = 10; i > 0; i--) {
					System.out.println("thread t1");
					print();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Runnable t2 = new Runnable() {
			public void run() {
				for (int i = 10; i > 0; i--) {
					System.out.println("thread t2");
					print();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		Runnable t3 = new Runnable() {
			public void run() {
				for (int i = 10; i > 0; i--) {
					System.out.println("thread t3");
					print();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};

		System.out.println("11111");
		new Thread(t1).start();
		System.out.println("22222");
		new Thread(t2).start();
		System.out.println("33333");
		new Thread(t3).start();
		System.out.println("44444");
	}

	public static void print() {
		System.out.println("print....");
	}

}
