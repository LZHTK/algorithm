package weak1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    public static void main(String[] args) throws Exception {
        /*
           입력 처리와 출력 처리를 한 번에 처리하기 위해 Buffered를 사용
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        * 연산의 개수를 나타내는 N을 첫 줄에 입력 받음
        * readLine()은 문자열로 읽으니까 Integer.parseInt()로 변환*/
        int n = Integer.parseInt(br.readLine());

        /*
        * 기본 Heap 구조인 PriorityQueue를 사용하되 기본 값이 최소힙이기에
        * Collection.reverseOrder()로 내림차순으로 바꿈 ( 가장 큰 값이 먼저 나오게 )*/
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        /* Q.for문보다는 stream이 좋은거 아닌가..?
        *  A. 해당 MaxHeap은 PriorityQueue의 상태가 지속적으로 변경되고 입력 값에 따라 다른 동작을 수행한다.
        *     그렇기에 함수형 프로그래밍의 불변성 원칙을 따르는 stream과는 어울리지 않음. */
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());

            /*
            * x = 0이 들어왔을 때 힙이 비어있으면 0을 주고,
            * 아니면 가장 큰 값을 poll()로 꺼내어 출력
            * x에 자연수가 들어오면 offer(x)로 힙에 추가*/
            if (x == 0) {
                if (maxHeap.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(maxHeap.poll() + "\n");
                }
            } else {
                maxHeap.offer(x);
            }
        }

        /*
        * 출력 버퍼 비우기 및
        * 입출력 스트림 close()로 리소스 반납*/
        bw.flush();
        bw.close();
        br.close();
    }
}
