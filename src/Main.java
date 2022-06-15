public class Main {
    public static void main(String[] args) throws InterruptedException {
        final GameBox gameBox = new GameBox();
        System.out.println("Game started " + Thread.currentThread().getName());
        Thread AIGame = new Thread(gameBox::tuneOff);
        AIGame.start();
        Thread userGame = new Thread(gameBox::tuneOn);
        userGame.start();
        userGame.join();
        AIGame.interrupt();
        System.out.println("Game finished " + Thread.currentThread().getName());
    }
}

