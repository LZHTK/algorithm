package weak1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                if (minHeap.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(minHeap.poll() + "\n");
                }
            } else {
                minHeap.offer(x);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
