package se.bahram.tdd.junitinaction.jumpstart;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int delayedJob() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
