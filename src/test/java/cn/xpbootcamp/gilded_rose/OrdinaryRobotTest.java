package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrdinaryRobotTest {

    @Test
    void should_return_ticket_when_save_given_robot_has_two_lockers_with_capacity_of_2_2() {
        OrdinaryRobot ordinaryRobot = new OrdinaryRobot(2, 2);
        Package aPackage = new Package();

        Ticket ticket = ordinaryRobot.save(aPackage);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_exception_when_save_given_robot_has_two_lockers_with_capacity_of_0_0() {
        OrdinaryRobot ordinaryRobot = new OrdinaryRobot(0, 0);
        Package aPackage = new Package();

        Assertions.assertThrows(NoCapacityException.class, () -> ordinaryRobot.save(aPackage));
    }

    @Test
    void should_return_ticket_when_save_given_robot_has_two_lockers_with_capacity_of_0_2() {
        OrdinaryRobot ordinaryRobot = new OrdinaryRobot(0, 2);
        Package aPackage = new Package();

        Ticket ticket = ordinaryRobot.save(aPackage);

        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_return_package_when_fetch_given_valid_ticket() {
        OrdinaryRobot ordinaryRobot = new OrdinaryRobot(2, 2);
        Package expected = new Package();
        Ticket ticket = ordinaryRobot.save(expected);

        Package result = ordinaryRobot.fetch(ticket);


        Assertions.assertSame(expected, result);
    }

    @Test
    void should_return_exception_when_double_fetch_given_used_ticket() {
        OrdinaryRobot ordinaryRobot = new OrdinaryRobot(2, 2);
        Package expected = new Package();
        Ticket ticket = ordinaryRobot.save(expected);

        ordinaryRobot.fetch(ticket);

        Assertions.assertThrows(InValidTicketException.class, () -> ordinaryRobot.fetch(ticket));
    }

    @Test
    void should_return_exception_when_fetch_given_invalid_ticket() {
        OrdinaryRobot ordinaryRobot = new OrdinaryRobot(2, 2);
        Package expected = new Package();
        Ticket ticket = ordinaryRobot.save(expected);

        Assertions.assertThrows(InValidTicketException.class, () -> ordinaryRobot.fetch(new Ticket()));
    }

    @Test
    void should_return_package_when_fetch_save_given_robot_has_two_lockers_with_capacity_of_0_2() {
        OrdinaryRobot ordinaryRobot = new OrdinaryRobot(1, 2);
        Package expected = new Package();
        Ticket ticket = ordinaryRobot.save(expected);

        ordinaryRobot.fetch(ticket);
        Ticket result = ordinaryRobot.save(expected);

        Assertions.assertSame(ticket.getLockerId(), result.getLockerId());
    }

    @Test
    void should_return_package_when_fetch_given_robot_has_two_lockers_with_capacity_of_0_2() {
        OrdinaryRobot ordinaryRobot = new OrdinaryRobot(0, 2);
        Package expected = new Package();
        Ticket ticket = ordinaryRobot.save(expected);

        Package result = ordinaryRobot.fetch(ticket);

        Assertions.assertSame(expected, result);
    }
}
