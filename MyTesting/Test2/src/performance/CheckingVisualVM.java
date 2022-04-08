package performance;

public class CheckingVisualVM {
    public static void main(String[] args) throws InterruptedException {
        
        Thread[] arr = new Thread[100];
        for (int i = 0 ; i < arr.length ; i++) {
            arr[i] = create();
            arr[i].start();
        }
        
        for (int i = 0 ; i < arr.length ; i++) {
            arr[i].join();
        }
    }
    
    public static Thread create() {
        Thread thread = new Thread(() -> {
            int cnt = 0;
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println("In: " + cnt);
                cnt++;
            }
        });
        return thread;
    }
}
