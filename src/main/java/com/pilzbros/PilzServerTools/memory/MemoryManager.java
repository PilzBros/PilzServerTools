package com.pilzbros.PilzServerTools.memory;

public class MemoryManager {
    private boolean memoryOverNotif = false;
    private boolean ignoreNotif = false;
    private int memoryNotif = 0;

    private void checkNotif() {
        if (this.getMemoryUsage() > (double)this.memoryNotif) {
            this.memoryOverNotif = false;
        }

    }

    public void ignoreNotif() {
        this.ignoreNotif = true;
    }

    public long getProcessors() {
        return (long)Runtime.getRuntime().availableProcessors();
    }

    public long getFreeMemory() {
        return Runtime.getRuntime().freeMemory() / 1024L / 1024L;
    }

    public long getTotalMemory() {
        return Runtime.getRuntime().maxMemory() / 1024L / 1024L;
    }

    public double getMemoryUsage() {
        Long total = new Long(this.getTotalMemory());
        Long free = new Long(this.getFreeMemory());
        double nt = total.doubleValue();
        double nf = free.doubleValue();
        double inuse = nt - nf;
        double per = Math.ceil(inuse / nt * 100.0D);
        return per;
    }

    public double getMemoryRemaining() {
        return 100.0D - this.getMemoryUsage();
    }
}
