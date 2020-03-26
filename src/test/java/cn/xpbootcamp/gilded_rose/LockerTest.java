package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoVacancyException;
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
        Assertions.assertThrows(NoVacancyException.class, () -> locker.save(myPackage));
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

    @Test
    void should_throw_exception_when_double_fetch_given_valid_ticket() {
        //given
        MyPackage myPackage = new MyPackage();
        Locker locker = new Locker(2, 2);
        MyTicket myTicket = locker.save(myPackage);
        locker.fetch(myTicket);

        //then
        Assertions.assertThrows(InValidTicketException.class, () -> locker.fetch(myTicket));
    }

    @Test
    void should_throw_exception_when_fetch_given_invalid_ticket() {
        //given
        MyPackage myPackage = new MyPackage();
        Locker locker = new Locker(2, 2);
        locker.save(myPackage);

        //then
        Assertions.assertThrows(InValidTicketException.class, () -> locker.fetch(new MyTicket()));
    }

    @Test
    void should_ticket_and_throw_exception_when_save_2_package_given_1vacancy_locker() {
        //given
        MyPackage myPackage = new MyPackage();
        Locker locker = new Locker(2, 1);
        locker.save(myPackage);

        //then
        Assertions.assertThrows(NoVacancyException.class, () -> locker.save(new MyPackage()));
    }

    @Test
    void should_ticket_when_save_package_given_0_vacancy_locker() {
        //given
        MyPackage myPackage = new MyPackage();
        Locker locker = new Locker(2, 1);
        MyTicket myTicket = locker.save(myPackage);
        locker.fetch(myTicket);
        MyTicket result = locker.save(new MyPackage());

        //then
        Assertions.assertNotNull(result);
    }
}
