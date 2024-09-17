package teacuptechsystems.com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FanTest {

	private Fan fan;

	@BeforeEach
	public void setUp() {
		this.fan = new Fan();
	}

	@Test
	public void testInitialFanState() {
		assertEquals(0, this.fan.getSpeed()); // Initial speed is off (0)
		assertEquals(Fan.CLOCKWISE, this.fan.getDirection()); // Initial direction is clockwise
	}

	@Test
	void testPullSpeedCord() {
		this.fan.pullSpeedCord();
		assertEquals(1, this.fan.getSpeed());

		this.fan.pullSpeedCord();
		assertEquals(2, this.fan.getSpeed());

		this.fan.pullSpeedCord();
		assertEquals(3, this.fan.getSpeed());

		this.fan.pullSpeedCord(); // Should cycle back to 0
		assertEquals(0, this.fan.getSpeed());
	}

	@Test
	void testPullDirectionCord() {
		this.fan.pullDirectionCord();
		assertEquals(Fan.COUNTER_CLOCKWISE, this.fan.getDirection());

		this.fan.pullDirectionCord(); // Reverse again
		assertEquals(Fan.CLOCKWISE, this.fan.getDirection());
	}

	@Test
	public void testSpeedAndDirection() {
		// Set speed to 2 and reverse direction
		this.fan.pullSpeedCord(); // Speed 1
		this.fan.pullSpeedCord(); // Speed 2
		this.fan.pullDirectionCord(); // Reverse direction

		assertEquals(2, this.fan.getSpeed());
		assertEquals(Fan.COUNTER_CLOCKWISE, this.fan.getDirection());

		// Change speed to 3 and check direction
		this.fan.pullSpeedCord(); // Speed 3
		assertEquals(3, this.fan.getSpeed());
		assertEquals(Fan.COUNTER_CLOCKWISE, this.fan.getDirection());

		// Turn fan off and check direction
		this.fan.pullSpeedCord(); // Speed 0 (off)
		assertEquals(0, this.fan.getSpeed());
		assertEquals(Fan.COUNTER_CLOCKWISE, this.fan.getDirection());
	}
}