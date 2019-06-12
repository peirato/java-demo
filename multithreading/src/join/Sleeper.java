package join;

class Sleeper extends Thread{
        private int duration;

        public Sleeper(String name, int sleepTime) {
            super(name);
            duration = sleepTime;
            start();
        }

        @Override
        public void run() {
            try {
                sleep(duration);
            } catch (InterruptedException e) {
                JoinDemoMain.print(getName()+" was interrupted. isInterrupted(): "+isInterrupted());
                return;
            }
            JoinDemoMain.print(getName() + " has awakened");
        }
    }