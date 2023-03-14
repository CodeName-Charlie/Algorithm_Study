package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2606 {
    
    static int[][] Node;
    // ��忡 �湮�ߴ��� üũ�ϴ� �迭
    static boolean[] isVisited; 
    // �̾��� �ִ� ����� ���� ���� ���� ����
    static int cnt = 0;
    // ����� ����
    static int com;
    // ������ ����
    static int pair;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // ����� ���� �Է¹ޱ�
        com = Integer.parseInt(br.readLine());
        // ������ ���� �Է¹ޱ�
        pair = Integer.parseInt(br.readLine());
        // ������ ������ �迭 ����
        Node = new int[com+1][com+1];
        // ��忡 �湮�߾������� ������ �迭 ����
        isVisited = new boolean[com+1];
        // ������ �� ��ŭ �ݺ��ϱ�
        for (int i = 0; i < pair; i++) {
             StringTokenizer st = new StringTokenizer(br.readLine(), " ");
             // ������ ���� �Է¹ޱ�
             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             // ���⼺�� ���⶧���� ��Ī���� �ص� �ȴ�
             Node[a][b] = 1;
             Node[b][a] = 1;
             
        }
        // 1������ DFS ����
        dfs(1);
        // �ڱ� �ڽ��� �����ϰ�
        System.out.println(cnt-1);

    }


    public static void dfs(int root) {
        // 1�� �湮(����)
        isVisited[root] = true;    
        // �湮�� ��� �� ����
        cnt++;    
        // ��� ������ŭ �ݺ�
        for (int i = 0; i <= com; i++) {  
            //node[root][i] == 1 : 1���� ����� �����     
            //!isVisited[i] : i�� ��忡 �湮�� �� ������
            if (Node[root][i] == 1 && !isVisited[i]) {    
                // i�� ��� �湮ó��
                dfs(i);           
            }
        }
    }

}