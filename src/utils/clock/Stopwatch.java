package utils.clock;

public class Stopwatch {

    private ClockHand seconds;
    private ClockHand milliseconds;

    public Stopwatch() {
        this.seconds = new ClockHand(60);
        this.milliseconds = new ClockHand(100);
    }

    private void advance() {
        this.milliseconds.advance();

        if (this.milliseconds.getAtualValue() == 0) {
            this.seconds.advance();
        }
    }

    public void startStopwatch(int valueToSetSecondsLimit) {
        this.seconds.setSecondsLimit(valueToSetSecondsLimit);

        while (true) {
            this.advance();
            
            if (this.milliseconds.getAtualValue() == 0 && this.seconds.getAtualValue() == 0) {
                return;
            }
            
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                
            }
        }
    }

    @Override
    public String toString() {
        return this.seconds + " | " + this.milliseconds;
    }
}