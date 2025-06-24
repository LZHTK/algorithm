import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class AbsoluteValueHeap {
    public static void main(String[] args) throws IOException {
        /* Scanner보다 빠른 BufferedReader로 읽어온다
        *  BufferedWrite로 빠르게 출력한다.*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /* 절대 값이 같은 경우에는 실제 값이 작은 것이 우선으로 나오게 하고,
        *  그렇지 않으면 절대 값이 작은 수가 나오게 하는 메서드.*/
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int absA = Math.abs(a);
            int absB = Math.abs(b);

            if (absA == absB) {
                return Integer.compare(a, b);
            }
            return Integer.compare(absA, absB);
        });

        /* 연산의 수인 N을 정수로 읽어옴*/
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            /* 각 줄의 입력 숫자를 정수로 변환하여 x에 저장*/
            int x = Integer.parseInt(br.readLine());

            /* x=0인 경우중에 큐가 비어있으면 0을 출력
            *  아니라면 우선순위가 가장 높다고 여겨지는 절댓값이 가장 작은 값을 꺼내어 출력
            *  0이 아닌 x 값들은 offer()를 통해 큐에 추가*/
            if (x == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            } else {
                pq.offer(x);
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
