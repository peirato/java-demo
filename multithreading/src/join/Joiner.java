package join;

class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            JoinDemoMain.print("Interrupted");
        }
        JoinDemoMain.print(getName() + " join completed");
    }
}