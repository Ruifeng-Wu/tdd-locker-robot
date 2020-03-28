package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoVacancyException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LockerTest {

    @Test
    void should_return_ticket_when_save_given_package_and_capacity_not_full() {
        //given
        Package aPackage = new Package();
        Locker locker = new Locker( 2);
        //when
        Ticket ticket = locker.save(aPackage);

        //then
        Assertions.assertNotNull(ticket);
    }

    @Test
    void should_throw_exception_when_save_given_package_and_vacancy_is_0() {
        //given
        Package aPackage = new Package();
        Locker locker = new Locker(0);

        //then
        Assertions.assertThrows(NoVacancyException.class, () -> locker.save(aPackage));
    }

    @Test
    void should_package_when_fetch_given_valid_ticket() {
        //given
        Package aPackage = new Package();
        Locker locker = new Locker(2);
        Ticket ticket = locker.save(aPackage);

        //when
        Package result = locker.fetch(ticket);

        //then
        Assertions.assertSame(aPackage, result);
    }

    @Test
    void should_throw_exception_when_double_fetch_given_valid_ticket() {
        //given
        Package aPackage = new Package();
        Locker locker = new Locker( 2);
        Ticket ticket = locker.save(aPackage);
        locker.fetch(ticket);

        //then
        Assertions.assertThrows(InValidTicketException.class, () -> locker.fetch(ticket));
    }

    @Test
    void should_throw_exception_when_fetch_given_invalid_ticket() {
        //given
        Package aPackage = new Package();
        Locker locker = new Locker( 2);
        locker.save(aPackage);

        //then
        Assertions.assertThrows(InValidTicketException.class, () -> locker.fetch(new Ticket()));
    }

    @Test
    void should_ticket_and_throw_exception_when_save_2_package_given_1_vacancy_locker() {
        //given
        Package aPackage = new Package();
        Locker locker = new Locker(1);
        locker.save(aPackage);

        //then
        Assertions.assertThrows(NoVacancyException.class, () -> locker.save(new Package()));
    }


    @Test
    void should_ticket_when_save_package_given_0_vacancy_locker() {
        //given
        Package aPackage = new Package();
        Locker locker = new Locker( 1);
        Ticket ticket = locker.save(aPackage);
        locker.fetch(ticket);
        Ticket result = locker.save(new Package());
        //then
        Assertions.assertNotNull(result);
    }
}
