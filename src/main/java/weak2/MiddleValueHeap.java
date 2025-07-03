package weak2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MiddleValueHeap {

    public static void main(String[] args) throws IOException{
        /* BufferedReader - 빠른 입력 처리를 위한 표준 입력
        *  StringBuilder - 출력 문자열을 누적해서 모아 ㅎ나번에 출력할 때 사용 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        /* T는 테스트 케이스 개수이며 아래 후위 감소 연산자를 이용해 T번 반복*/
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            /* M은 현재 테스트 케이스 수열의 길이 ( 홀수로 받는다 )
             * numbers는 전체 입력 수를 담는 리스트이며 StringTokennizer로 한줄에 10개씩 들어오는 숫자들을 공백 단위로 분리해서 int로 파싱 */
            int M = Integer.parseInt(br.readLine());
            List<Integer> numbers = new ArrayList<>();
            while (numbers.size() < M) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                while (st.hasMoreTokens()) {
                    numbers.add(Integer.parseInt(st.nextToken()));
                }
            }

            /* 홀수 번째마다 구한 중앙 값들을 저장 */
            List<Integer> medians = new ArrayList<>();

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은 값들의 최대 힙
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 값들의 최소 힙


            /* 전체 수열을 순회하며 중앙 값을 계산
            *  수열을 처음부터 끝까지 순회하며 하나씩 읽는다.*/
            for (int i = 0; i < M; i++) {
                int num = numbers.get(i);

                // 힙 삽입
                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }

                // 힙 정렬 조건 유지
                if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                    int Max = maxHeap.poll();
                    int Min = minHeap.poll();
                    maxHeap.offer(Min);
                    minHeap.offer(Max);
                }

                // 홀수 번째 입력마다 중앙값 저장
                if (i % 2 == 0) {
                    medians.add(maxHeap.peek());
                }
            }

            // 출력
            output.append(medians.size()).append("\n");
            for (int i = 0; i < medians.size(); i++) {
                output.append(medians.get(i)).append(" ");
                if ((i + 1) % 10 == 0) output.append("\n");
            }
            if (medians.size() % 10 != 0) output.append("\n");
        }

        System.out.print(output);
    }

}
