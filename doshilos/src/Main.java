public class Main {
    public static void main(String[] args) {
        Thread firstThread = new Thread(new FirstThread());
        Thread secondThread = new Thread(new SecondThread());

        firstThread.start();
        secondThread.start();
    }
}

class FirstThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Ejecución del hilo 1: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SecondThread implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Ejecución del hilo 2");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
