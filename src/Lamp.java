public class Lamp {
    private boolean lampIsOn;

    public void printLampStatus() {
        if (lampIsOn) {
            System.out.println("Lamp is on");
        } else {
            System.out.println("Lamp is off");
        }
    }

    public void setLampIsOn(boolean lampIsOn) {
        this.lampIsOn = lampIsOn;
    }

    public boolean isLampIsOn() {
        return lampIsOn;
    }
}
