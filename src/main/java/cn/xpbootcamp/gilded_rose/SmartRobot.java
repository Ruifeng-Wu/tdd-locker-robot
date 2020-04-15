package cn.xpbootcamp.gilded_rose;

import java.util.Comparator;

public class SmartRobot extends Robot {
    public SmartRobot(int... capacities) {
        super(capacities);
    }

    @Override
    public Ticket save(Package aPackage) {

        return lockers.stream()
                .sorted(Comparator.comparing(Locker::getCapacity).reversed())
                .findFirst()
                .orElse(null)
                .save(aPackage);
    }
}
