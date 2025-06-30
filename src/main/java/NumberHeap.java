import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class NumberHeap {
    public static void main(String[] args) throws IOException {
        /* 빠른 표준 입력을 위해 BufferedReader 사용
        *  첫 줄 입력 값 N은 N*N 행렬의 크기 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /* 입력된 행렬을 int[][] table에 저장 */
        int[][] table = new int[N][N];

        /* StringTokenizer는 공백 기준으로 숫자를 나누는 데 사용됨.
        * 2차원 배열에 값 채우기*/
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 모든 값을 candidates 리스트에 저장
        *  현재 Math.max(0, N-N)은 결국 0이므로 i = 0 ~ N-1까지 다 순회하여 전부 다 넣고 있는 상황*/
        List<Integer> candidates = new ArrayList<>();

        for (int j = 0; j < N; j++) {
            for (int i = Math.max(0, N-N); i < N; i++) {
                candidates.add(table[i][j]);
            }
        }

        /* 내림차순 정렬 */
        Collections.sort(candidates, Collections.reverseOrder());

        /* 정렬된 리스트에서 N-1 인덱스 값을 반환하면 전체에서 N번째 큰 수가 된다.*/
        System.out.println(candidates.get(N - 1));
    }
}

//public class NumberHeap {
//    public static void main(String[] args) throws IOException {
//        // 입력 처리
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//
//        // Min-Heap 사용 (기본 PriorityQueue는 오름차순)
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//'
//        // N x N 행렬의 숫자들을 처리
//        for (int i = 0; i < N; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                int num = Integer.parseInt(st.nextToken());
//                pq.offer(num); // 우선순위 큐에 넣고
//                if (pq.size() > N) {
//                    pq.poll(); // 가장 작은 수 제거 → 큐의 크기를 N으로 유지
//                }
//            }
//        }
//
//        // N번째로 큰 수 출력 (최종적으로 pq에 남은 것 중 가장 작은 값)
//        System.out.println(pq.peek());
//    }
//}
