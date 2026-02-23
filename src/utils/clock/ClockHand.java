package utils.clock;

public class ClockHand {

    private int atualValue;
    private int valueLimit;

    public ClockHand(int limit) {
        this.atualValue = 0;
        this.valueLimit = limit;
    }

    public void advance() {
        this.atualValue++;

        if (this.atualValue == this.valueLimit) {
            this.atualValue = 0;
        }
    }

    public int getAtualValue() {
        return this.atualValue;
    }

    public void setSecondsLimit(int valueToSet) {
        this.valueLimit = valueToSet;
    }

    @Override
    public String toString() {
        if (this.atualValue < 10) {
            return "0" + this.atualValue;
        }
        return this.atualValue + "";
    }
}