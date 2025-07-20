public class Philosopher extends Thread {
    private final int id;
    private final Chopstick left;
    private final Chopstick right;
    private final Controller controller;
    private final int NUM_OF_PHILOSOPHER = 5;

    public Philosopher(int id, Chopstick left, Chopstick right, Controller controller) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.controller = controller;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                eat();
            }
        } catch (InterruptedException e) {
            System.out.println("Philosopher " + id + " was interrupted.");
        }
    }

    private void think() throws InterruptedException {
        controller.setThinking(id);
        Thread.sleep((long) (Math.random() * 3000));
    }

    private void eat() throws InterruptedException {
        Chopstick first = id < (id + 1) % NUM_OF_PHILOSOPHER ? left : right;
        Chopstick second = id < (id + 1) % NUM_OF_PHILOSOPHER ? right : left;

        synchronized (first) {
            first.take();
            synchronized (second) {
                second.take();

                controller.setEating(id);
                Thread.sleep((long) (Math.random() * 3000));

                second.putDown();
            }
            first.putDown();
        }
    }
}
