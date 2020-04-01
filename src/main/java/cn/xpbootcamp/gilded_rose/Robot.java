package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Robot {
    List<Locker> lockers;

    public Robot(int... capacities) {
        lockers = new ArrayList<>();
        for (int capacity : capacities) {
            Locker locker = new Locker(capacity);
            locker.setId(String.valueOf(UUID.randomUUID()));
            lockers.add(locker);
        }
    }


    public Ticket save(Package aPackage) {
        Ticket ticket = null;
        for (Locker locker : lockers) {
            try {
                ticket = locker.save(aPackage);
                ticket.setLockerId(locker.getId());
                return ticket;
            } catch (NoCapacityException e) {
                System.out.println(e);
            }
        }
        throw new NoCapacityException();
    }

    public Package fetch(Ticket ticket) {
        for (Locker locker : lockers) {
            try {
                return locker.fetch(ticket);
            } catch (InValidTicketException e) {
                System.out.println(e);
            }
        }
        throw new InValidTicketException();
    }
}
