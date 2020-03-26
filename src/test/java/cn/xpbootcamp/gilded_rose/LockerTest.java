package cn.xpbootcamp.gilded_rose;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTest {

    @Test
    void should_return_ticket_when_save_given_package_and_capacity_not_full() {
        //given
        MyPackage myPackage = new MyPackage();
        Locker locker = new Locker(2, 2);
        //when
        MyTicket ticket = locker.save(myPackage);

        //then
        Assertions.assertNotNull(ticket);
    }
}
