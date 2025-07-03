package weak2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Virus {
    /* 전역 변수들
    *  graph를 인접 리스트로 표현한 변수로 예를 들면 graph.get(i)는 i번 컴퓨터와 직접 연결된 컴퓨터들의 리스트
    *  visited는 DFS 탐색 중 이미 방문한 컴퓨터인지 확인하기 위한 배열로 중복 감염을 방지하기 위해 사용
    *  count는 감염된 컴퓨터 수를 세기 위한 변수*/
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* 첫 입력으로 컴퓨터 수를 정의 */
        int n = Integer.parseInt(br.readLine());

        /* 두번 째 입력으로 연결의 수를 정의 */
        int m = Integer.parseInt(br.readLine());


        /* 인덱스를 1부터 n까지 사용하기 위해 n+1로 지정하고
        *  for문을 돌려 graph에 n+1개의 빈 리스트를 추가하여 인접 리스트 구조를 만듦*/
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }


        /* 연결된 컴퓨터 쌍 (a , b)를 읽어 인접 리스트에 저장
        *  양방향 연결이기 때문에 a->b, b->a 모두 추가*/
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }


        /* 1번 컴퓨터에서 탐색을 시작하여 감염 전파를 시뮬레이션하는 로직*/
        dfs(1);

        System.out.println(count - 1);
    }

    /* DFS란?
    *  깊이 우선 탐색으로 그래프나 트리 구조에서 한방향으로 끝까지 파고들며 탐색하는 알고리즘 */

    /* DFS 함수를 정의하는 부분으로
    *  한 노드에 연결된 모든 네트워크를 깊게 탐색하면서 연결된 모든 컴퓨터를 감염시킴
    *  동작 흐름
    *  1. node를 방문 처리
    *  2. count ++
    *  3. 해당 노드에 인접한 노드들 중 아직 방문하지 않은 노드들을 재귀 호출로 탐색*/
    static void dfs(int node) {
        visited[node] = true;
        count++;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }
}
