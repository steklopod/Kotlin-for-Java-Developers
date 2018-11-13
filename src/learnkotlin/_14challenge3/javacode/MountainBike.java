package learnkotlin._14challenge3.javacode;

public class MountainBike extends Bicycle {

    private int seatHeight;

    public MountainBike(int seatHeight,
                        int cadence,
                        int speed,
                        int gear) {
        super(cadence, speed, gear);
        this.seatHeight = seatHeight;
    }

    public int getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(int seatHeight) {
        this.seatHeight = seatHeight;
    }

    @Override
    public void printDescription() {
        super.printDescription();
        System.out.println("The mountainbike has a seat height of " + seatHeight + ".");
    }
}
