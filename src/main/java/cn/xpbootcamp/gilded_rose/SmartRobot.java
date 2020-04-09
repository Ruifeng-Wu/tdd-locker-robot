package cn.xpbootcamp.gilded_rose;

import cn.xpbootcamp.gilded_rose.exception.NoCapacityException;

public class SmartRobot extends Robot {
    public SmartRobot(int... capacities) {
        super(capacities);
    }

    @Override
    public Ticket save(Package aPackage) {
        int maxCapacity = 0;
        int index = 0;
        int i = 0;
        for(Locker locker: lockers) {
            if (locker.getCapacity() > maxCapacity) {
                index = i;
                maxCapacity = locker.getCapacity();
            }
            i++;
        }
        return lockers.get(index).save(aPackage);
    }
}
