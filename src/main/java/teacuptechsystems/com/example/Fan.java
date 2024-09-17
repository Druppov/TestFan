package teacuptechsystems.com.example;


public class Fan {

	public static final String CLOCKWISE = "Clockwise";
	public static final String COUNTER_CLOCKWISE = "CounterClockwise";

	private int speed;
	private boolean isClockwise;

	public Fan() {
		this.speed = 0; // Initial speed is "off"
		this.isClockwise = true; // Initial direction is clockwise
	}

	// Pull cord for increasing speed
	public void pullSpeedCord() {
		this.speed = (speed + 1) % 4; // Cycle through speeds (0, 1, 2, 3, 0)
	}

	// Pull cord for reversing direction
	public void pullDirectionCord() {
		this.isClockwise = !this.isClockwise; // Reverse direction
	}

	public int getSpeed() {
		return this.speed;
	}

	public String getDirection() {
		return this.isClockwise ? CLOCKWISE : COUNTER_CLOCKWISE;
	}

	@Override
	public String toString() {
		return "Fan [speed=" + getSpeed() + ", direction=" + getDirection() + "]";
	}
}
