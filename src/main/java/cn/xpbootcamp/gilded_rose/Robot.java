package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    List<Locker> lockers;

    public Robot(int... capacities) {
        lockers = new ArrayList<>();
        for (int capacity : capacities) {
            lockers.add(new Locker(capacity));
        }
    }


    public Ticket save(Package aPackage) {
        Ticket ticket = null;
        for (Locker locker : lockers) {
            try {
                ticket = locker.save(aPackage);
                return ticket;
            } catch (NoCapacityException e) {
                System.out.println(e);
            }
        }
        throw new NoCapacityException();
    }
}
