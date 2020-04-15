package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Robot {
    List<Locker> lockers;

    public Robot(int... capacities) {
        lockers = new ArrayList<>();
        for (int capacity : capacities) {
            Locker locker = new Locker(capacity);
            locker.setId(String.valueOf(UUID.randomUUID()));
            lockers.add(locker);
        }
    }

    public Package fetch(Ticket ticket) {
        return lockers.stream()
                .filter(locker -> locker.hasPackage(ticket))
                .findFirst()
                .orElseThrow(InValidTicketException::new)
                .fetch(ticket);
    }

    public abstract Ticket save(Package aPackage);
}
