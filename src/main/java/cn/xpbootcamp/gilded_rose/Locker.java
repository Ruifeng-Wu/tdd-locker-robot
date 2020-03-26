package cn.xpbootcamp.gilded_rose;


import cn.xpbootcamp.gilded_rose.exception.InValidTicketException;
import cn.xpbootcamp.gilded_rose.exception.NoVacancyException;

import java.util.HashMap;
import java.util.Map;

public class Locker {
    private int capacity;
    private int vacancy;
    private Map<MyTicket, MyPackage> myPackageList = new HashMap<>();

    public Locker() {
    }

    public Locker(int capacity, int vacancy) {
        this.capacity = capacity;
        this.vacancy = vacancy;
    }

    public MyTicket save(MyPackage myPackage) {
        if (vacancy <= 0) {
            throw new NoVacancyException();
        }
        MyTicket myTicket = new MyTicket();
        myPackageList.put(myTicket, myPackage);
        vacancy--;
        return myTicket;
    }

    public MyPackage fetch(MyTicket myTicket) {
        if (!myPackageList.containsKey(myTicket)) {
            throw new InValidTicketException();
        }
        MyPackage myPackage = myPackageList.remove(myTicket);
        vacancy++;
        return myPackage;
    }
}
