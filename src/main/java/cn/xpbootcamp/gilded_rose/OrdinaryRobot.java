package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;

public class OrdinaryRobot extends Robot{

    public OrdinaryRobot(int... capacities) {
        super(capacities);
    }

    @Override
    public Ticket save(Package aPackage) {
        return lockers.stream()
                .filter(Locker::hasCapacity)
                .findFirst()
                .orElseThrow(NoCapacityException::new)
                .save(aPackage);
    }
}
