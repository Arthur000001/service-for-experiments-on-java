package main.java.core.garbage_collector;

import java.util.ArrayList;
import java.util.List;

public class GcTest {
    public static void main(String[] args) throws InterruptedException {
        List<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(new byte[10_000_000]); // 10MB
            if (list.size() > 50) list.clear();
            Thread.sleep(50);
        }
    }
}



