package cn.xpbootcamp.gilded_rose;


public class Locker {
    private int capacity;
    private int vacancy;
    public Locker() {
    }

    public Locker(int capacity, int vacancy) {
        this.capacity = capacity;
        this.vacancy = vacancy;
    }

    public MyTicket save(MyPackage myPackage) {
        return new MyTicket();
    }
}
