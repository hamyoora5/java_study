// public은 이 클래스를 어디서든 사용할 수 있게 해줍니다.
// class는 자바 코드를 담는 기본 단위입니다.
// ThreadStudy는 클래스 이름이며 파일 이름과 같아야 합니다.
public class ThreadStudy {
    // main 메서드는 자바 프로그램이 가장 먼저 실행하는 시작점입니다.
    public static void main(String[] args) {
        // 스레드는 프로그램 안에서 동시에 여러 작업을 처리하는 실행 흐름입니다.
        // main 메서드를 실행하는 흐름도 main 스레드라고 부릅니다.
        System.out.println("현재 실행 중인 스레드: " + Thread.currentThread().getName());

        // Thread 클래스를 상속받아 스레드를 만드는 방법입니다.
        MyThread thread1 = new MyThread();
        thread1.setName("상속받은 스레드");

        // Runnable 인터페이스를 구현해서 스레드를 만드는 방법입니다.
        Thread thread2 = new Thread(new MyRunnable(), "Runnable 스레드");

        // start()를 호출하면 새로운 스레드가 생성되어 run()이 실행됩니다.
        thread1.start();
        thread2.start();

        // run()을 직접 호출하면 새로운 스레드가 생기지 않고 main 스레드에서 그냥 메서드처럼 실행됩니다.
        MyThread directRunThread = new MyThread();
        directRunThread.setName("직접 run 호출");
        directRunThread.run();

        // sleep()은 현재 스레드를 잠시 쉬게 합니다.
        try {
            System.out.println("main 스레드가 500밀리초 동안 잠깐 쉽니다.");
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("sleep 중 인터럽트 발생");
        }

        // join()은 다른 스레드의 작업이 끝날 때까지 기다립니다.
        try {
            thread1.join();
            thread2.join();
            System.out.println("thread1과 thread2 작업이 모두 끝났습니다.");
        } catch (InterruptedException e) {
            System.out.println("join 대기 중 인터럽트 발생");
        }

        // 익명 클래스를 이용해서 간단한 스레드를 만들 수도 있습니다.
        Thread anonymousThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("익명 클래스 스레드: " + i);
                }
            }
        }, "익명 스레드");
        anonymousThread.start();

        // 람다식으로도 Runnable을 더 짧게 표현할 수 있습니다.
        Thread lambdaThread = new Thread(() -> {
            for (int i = 1; i <= 3; i++) {
                System.out.println("람다 스레드: " + i);
            }
        }, "람다 스레드");
        lambdaThread.start();

        try {
            anonymousThread.join();
            lambdaThread.join();
        } catch (InterruptedException e) {
            System.out.println("익명 스레드 대기 중 인터럽트 발생");
        }

        // 여러 스레드가 같은 데이터를 함께 사용하면 충돌이 생길 수 있습니다.
        // 아래는 공유 자원을 여러 스레드가 함께 증가시키는 예제입니다.
        Counter counter = new Counter();

        Thread counterThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        }, "카운터 스레드1");

        Thread counterThread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increase();
            }
        }, "카운터 스레드2");

        counterThread1.start();
        counterThread2.start();

        try {
            counterThread1.join();
            counterThread2.join();
        } catch (InterruptedException e) {
            System.out.println("카운터 스레드 대기 중 인터럽트 발생");
        }

        // synchronized를 사용하면 한 번에 하나의 스레드만 메서드에 들어오게 만들 수 있습니다.
        System.out.println("동기화된 카운터 결과: " + counter.getCount());

        // 스레드 상태는 상황에 따라 RUNNABLE, TIMED_WAITING, TERMINATED 등으로 변합니다.
        Thread stateThread = new Thread(() -> {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                System.out.println("stateThread 인터럽트 발생");
            }
        }, "상태 확인 스레드");

        System.out.println("시작 전 상태: " + stateThread.getState());
        stateThread.start();
        System.out.println("시작 직후 상태: " + stateThread.getState());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("main sleep 인터럽트 발생");
        }

        System.out.println("잠자는 중 상태: " + stateThread.getState());

        try {
            stateThread.join();
        } catch (InterruptedException e) {
            System.out.println("stateThread join 중 인터럽트 발생");
        }

        System.out.println("종료 후 상태: " + stateThread.getState());

        // interrupt()는 잠자고 있거나 대기 중인 스레드에 깨우라는 신호를 보낼 때 사용합니다.
        Thread interruptThread = new Thread(() -> {
            try {
                System.out.println("interruptThread가 잠듭니다.");
                Thread.sleep(3000);
                System.out.println("interruptThread가 정상적으로 깨어났습니다.");
            } catch (InterruptedException e) {
                System.out.println("interruptThread가 interrupt를 받았습니다.");
            }
        }, "인터럽트 스레드");

        interruptThread.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("main sleep 인터럽트 발생");
        }

        interruptThread.interrupt();

        try {
            interruptThread.join();
        } catch (InterruptedException e) {
            System.out.println("interruptThread join 중 인터럽트 발생");
        }

        // 데몬 스레드는 보조 작업용 스레드입니다.
        // 일반 스레드가 모두 끝나면 데몬 스레드는 자동으로 종료될 수 있습니다.
        Thread daemonThread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(200);
                    System.out.println("데몬 스레드 동작 중");
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "데몬 스레드");
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            System.out.println("데몬 확인 sleep 인터럽트 발생");
        }

        System.out.println("main 스레드 종료");
    }
}

// Thread를 상속받아 스레드를 만드는 예제 클래스입니다.
class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " 실행: " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " 인터럽트 발생");
            }
        }
    }
}

// Runnable을 구현해서 스레드를 만드는 예제 클래스입니다.
class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " 실행: " + i);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 인터럽트 발생");
            }
        }
    }
}

// 공유 자원을 안전하게 다루기 위한 예제 클래스입니다.
class Counter {
    private int count = 0;

    // synchronized를 붙이면 한 번에 하나의 스레드만 이 메서드를 실행할 수 있습니다.
    public synchronized void increase() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
