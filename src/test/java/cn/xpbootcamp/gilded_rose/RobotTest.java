package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RobotTest {

    @Test
    void should_return_ticket_when_save_given_robot_has_two_lockers_with_capacity_of_2_2() {
        Robot robot = new Robot(2, 2);
        Package aPackage = new Package();

        Ticket ticket = robot.save(aPackage);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_exception_when_save_given_robot_has_two_lockers_with_capacity_of_0_0() {
        Robot robot = new Robot(0, 0);
        Package aPackage = new Package();

        Assertions.assertThrows(NoCapacityException.class, () -> robot.save(aPackage));
    }
}
