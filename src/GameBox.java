public class GameBox {
    public final int MILLIS_USER = 3000;
    public final int TURNS = 3;
    public boolean isTuneOn = false;

    public void tuneOn() {
        System.out.println("User is ready to play " + Thread.currentThread().getName());
        for (int i = 0; i < TURNS; i++) {
            try {
                Thread.sleep(MILLIS_USER);
                if (!isTuneOn) {
                    isTuneOn = true;
                    System.out.println("Tune ON " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("User finished game " + Thread.currentThread().getName());
    }

    public void tuneOff() {
        System.out.println("AI started " + Thread.currentThread().getName());
        while (!Thread.currentThread().isInterrupted()) {
            if (isTuneOn) {
                isTuneOn = false;
                System.out.println("Tune OFF " + Thread.currentThread().getName());
            }
        }
        System.out.println("AI stopped " + Thread.currentThread().getName());
    }
}
