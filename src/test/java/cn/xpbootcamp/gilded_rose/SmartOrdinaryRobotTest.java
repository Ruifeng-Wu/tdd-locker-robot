package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SmartOrdinaryRobotTest {

    @Test
    void should_return_ticket_when_save_given_robot_has_two_lockers_with_capacity_of_2_2() {
        SmartOrdinaryRobot smartRobot = new SmartOrdinaryRobot(2, 2);
        Package aPackage = new Package();

        Ticket ticket = smartRobot.save(aPackage);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_exception_when_save_given_robot_has_two_lockers_with_capacity_of_0_0() {
        SmartOrdinaryRobot smartRobot = new SmartOrdinaryRobot(0, 0);
        Package aPackage = new Package();

        Assertions.assertThrows(NoCapacityException.class, () -> smartRobot.save(aPackage));
    }

    @Test
    void should_return_ticket_when_save_given_robot_has_two_lockers_with_capacity_of_0_2() {
        SmartOrdinaryRobot smartRobot = new SmartOrdinaryRobot(0, 2);
        Package aPackage = new Package();

        Ticket ticket = smartRobot.save(aPackage);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_package_when_fetch_given_valid_ticket() {
        SmartOrdinaryRobot smartRobot = new SmartOrdinaryRobot(2, 2);
        Package expected = new Package();
        Ticket ticket = smartRobot.save(expected);

        Package result = smartRobot.fetch(ticket);


        Assertions.assertSame(expected, result);
    }

    @Test
    void should_return_exception_when_double_fetch_given_used_ticket() {
        SmartOrdinaryRobot smartRobot = new SmartOrdinaryRobot(2, 2);
        Package expected = new Package();
        Ticket ticket = smartRobot.save(expected);

        smartRobot.fetch(ticket);

        Assertions.assertThrows(InValidTicketException.class, () -> smartRobot.fetch(ticket));
    }

    @Test
    void should_return_exception_when_fetch_given_invalid_ticket() {
        SmartOrdinaryRobot smartRobot = new SmartOrdinaryRobot(2, 2);
        Package expected = new Package();
        Ticket ticket = smartRobot.save(expected);

        Assertions.assertThrows(InValidTicketException.class, () -> smartRobot.fetch(new Ticket()));
    }

    @Test
    void should_save_two_package_in_same_locker_when_fetch_save_given_robot_has_two_lockers_with_capacity_of_1_3() {
        SmartOrdinaryRobot smartRobot = new SmartOrdinaryRobot(1, 3);
        Package aPackage = new Package();
        Ticket ticket = smartRobot.save(aPackage);

        Package otherPackage = new Package();
        Ticket result = smartRobot.save(otherPackage);

        Assertions.assertSame(ticket.getLockerId(), result.getLockerId());
    }
}
