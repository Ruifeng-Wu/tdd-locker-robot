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

    @Test
    void should_throw_exception_when_save_given_package_and_vacancy_is_0() {
        //given
        MyPackage myPackage = new MyPackage();
        Locker locker = new Locker(2, 0);

        //then
        Assertions.assertThrows(NotVacancyException.class, () -> locker.save(myPackage));
    }

    @Test
    void should_package_when_fetch_given_valid_ticket() {
        //given
        MyPackage myPackage = new MyPackage();
        Locker locker = new Locker(2, 2);
        MyTicket myTicket = locker.save(myPackage);

        //when
        MyPackage result = locker.fetch(myTicket);

        //then
        Assertions.assertSame(myPackage, result);
    }
}
