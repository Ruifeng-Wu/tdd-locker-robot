package cn.xpbootcamp.gilded_rose;


import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private Map<Ticket, Package> container = new HashMap<>();

    public Locker() {
    }

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save(Package aPackage) {
        if (capacity <= 0) {
            throw new NoCapacityException();
        }
        Ticket ticket = new Ticket();
        container.put(ticket, aPackage);
        capacity--;
        return ticket;
    }

    public Package fetch(Ticket ticket) {
        if (!container.containsKey(ticket)) {
            throw new InValidTicketException();
        }
        Package aPackage = container.remove(ticket);
        capacity++;
        return aPackage;
    }
}
