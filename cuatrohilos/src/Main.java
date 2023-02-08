public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Hilo 1 iniciado");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo 1 terminado");
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo 2 iniciado");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo 2 terminado");
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo 3 iniciado");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo 3 terminado");
        });
        Thread t4 = new Thread(() -> {
            try {
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo 4 iniciado");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hilo 4 terminado");
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
