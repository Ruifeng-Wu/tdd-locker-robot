package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartRobotTest {

    @Test
    void should_return_ticket_when_save_given_robot_has_two_lockers_with_capacity_of_2_2() {
        SmartRobot smartRobot = new SmartRobot(2, 2);
        Package aPackage = new Package();

        Ticket ticket = smartRobot.save(aPackage);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_exception_when_save_given_robot_has_two_lockers_with_capacity_of_0_0() {
        SmartRobot smartRobot = new SmartRobot(0, 0);
        Package aPackage = new Package();

        Assertions.assertThrows(NoCapacityException.class, () -> smartRobot.save(aPackage));
    }

    @Test
    void should_return_ticket_when_save_given_robot_has_two_lockers_with_capacity_of_0_2() {
        SmartRobot smartRobot = new SmartRobot(0, 2);
        Package aPackage = new Package();

        Ticket ticket = smartRobot.save(aPackage);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_package_when_fetch_given_valid_ticket() {
        SmartRobot smartRobot = new SmartRobot(2, 2);
        Package expected = new Package();
        Ticket ticket = smartRobot.save(expected);

        Package result = smartRobot.fetch(ticket);


        Assertions.assertSame(expected, result);
    }

    @Test
    void should_return_exception_when_double_fetch_given_used_ticket() {
        SmartRobot smartRobot = new SmartRobot(2, 2);
        Package expected = new Package();
        Ticket ticket = smartRobot.save(expected);

        smartRobot.fetch(ticket);

        Assertions.assertThrows(InValidTicketException.class, () -> smartRobot.fetch(ticket));
    }

}
