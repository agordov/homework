package homework;

enum TrafficLight {
    YELLOW {
        @Override
        public void light() {
            System.out.println("Wait a minute!");
        }

    },
    GREEN {
        @Override
        public void light() {
            System.out.println("Catch up!");
        }
    },
    RED {

        @Override
        public void light() {
            System.out.println("Stop!");
        }
    };
    public abstract void light();
}
