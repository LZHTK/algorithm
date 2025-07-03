package weak2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Numbering {
    /* 순서대로
       1. map은 지도 정보 (0,1)
       2. boolean은 방문 여부
       3. n은 지도 크기
       4. int[] dx = 방향 벡터 ( 상하좌우 )
       5. count는 단지 내 집의 숫자 */
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws IOException {
        /* 첫 줄에 지도 크기 n을 입력 받는다. */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        /* 지도 배열과 방문 배열의 크기를 n*n으로 생성 */
        map = new int[n][n];
        visited = new boolean[n][n];

        /* 각 줄의 지도 정보를 문자 단위로 읽고 0또는 1을 정수로 변환하여 저장한다. */
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        /* 단지별 집 개수를 저장할 리스트 */
        List<Integer> houseCounts = new ArrayList<>();

        /* 모든 좌표를 순회하며 1이면서 방문하지 않은 곳을 찾으면 새로운 단지로 기록
        *  본격적으로 DFS를 시작해서 단지 내의 모든 집을 탐색
        *  count는 dfs()에서 증가하며 집 개수를 센다. */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                /* 집이 있고, 아직 방문 안한 경우 */
                if (map[i][j] == 1 && !visited[i][j]) {
                    /* count = 0으로 새로운 단지를 시작하며
                    *  dfs로 연결된 집 탐색 시작
                    *  houseCounts.add로 완성된 단지 집 수 저장 */
                    count = 0;
                    dfs(i, j);
                    houseCounts.add(count);
                }
            }
        }

        /* 단지의 집 수를 오름차순으로 출력*/
        Collections.sort(houseCounts);
        System.out.println(houseCounts.size());
        for (int c : houseCounts) {
            System.out.println(c);
        }
    }

    /* visited[x][y] = true: 방문처리
    *  count++: 단지 내 집 수 증가
    *  4방향을 돌면서 연결된 집이면 계속 들어감
    *  경계를 벗어나거나, 0이거나, 이미 방문한 집은 무시*/
    static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;

            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
