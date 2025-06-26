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

        /* StringTokenizer는 공백 기준으로 숫자를 나누는 데 사용됨.*/
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /* 이 부분의 목적은 각 열에서 가장 아래쪽에 있는 값들만 수집하는 것으로
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


