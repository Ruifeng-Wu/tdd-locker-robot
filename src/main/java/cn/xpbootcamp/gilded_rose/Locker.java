package cn.xpbootcamp.gilded_rose;


import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private String id;
    private int capacity;
    private Map<Ticket, Package> container = new HashMap<>();

    public Locker(int capacity) {
        this.capacity = capacity;
    }

    public Ticket save(Package aPackage) {
        if (capacity <= 0) {
            throw new NoCapacityException();
        }
        Ticket ticket = new Ticket();
        ticket.setLockerId(id);
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

    public int getCapacity() {
        return capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean hasCapacity() {
        return capacity > 0;
    }

    public boolean hasPackage(Ticket ticket) {
        return container.containsKey(ticket);
    }
}
