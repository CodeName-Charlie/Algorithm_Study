package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P2667 {
    // �̷�ã��� ����� ����
    // ���� �Է¹ް�
    // �ʺ�켱Ž���� �����
    // 4��Ž���� �ϸ� ������ ���� �ִ��� Ȯ���Ѵ�.
    // �� ������ �� �������� ���� ����Ѵ�.
    //

    // �� �� �� �� ��Ÿ�迭
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};
    // ������ ������ �迭
    static int[][] map;
    // �湮 ���θ� ������ �迭
    static boolean[][] isVisited;
    static int N; // ������ ũ��
    static int cnt; // ������ ��
    static ArrayList<Integer> houses; // �� ������ �� ���� ������ ����Ʈ

    public static void main(String[] args) {
        // ��ĳ�� ����
        Scanner sc = new Scanner(System.in);
        // ���� ũ�� �Է¹ޱ�
        N = sc.nextInt();
        // ������ ������ �迭 ����
        map = new int[N][N];
        // �湮���θ� ������ �迭
        isVisited = new boolean[N][N];
        // ������ �� ������ ������ ����Ʈ
        houses = new ArrayList<>();

        // ���� �Է� �ޱ�
        for (int r = 0; r < N; r++) {
            String str = sc.next();
            for (int c = 0; c < N; c++) {
                map[r][c] = str.charAt(c) - '0';
            }
        }

        // ��� ��ǥ�� ���ؼ� DFS ����
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                // ���� �ְ�, �湮���� ���� ��쿡�� DFS ����
                if (map[r][c] == 1 && !isVisited[r][c]) {
                    // ���� ���� ���� �� �� ���
                    int houseCnt = dfs(r, c);
                    // �ش� ������ �� ���� ����Ʈ�� ����
                    houses.add(houseCnt);
                    cnt++; // ���� �� ����
                }
            }
        }

        // �������� ����
        Collections.sort(houses);

        // ��� ���
        System.out.println(cnt);
        for (int i = 0; i < houses.size(); i++) {
            System.out.println(houses.get(i));
        }
    }

    // DFS �Լ� ����
    public static int dfs(int r, int c) {
        // ���� ��ǥ �湮 ó��
        isVisited[r][c] = true;
        // ���� ���� ���� �� ����
        int houseCnt = 1;
        // 4�� Ž���ϱ�
        for (int i = 0; i < 4; i++) {
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];
            // ��� ����
            if (nRow < 0 || nCol < 0 || nRow >= N || nCol >= N)
                continue;
            // ���� �ְ�, �湮���� ���� ��쿡�� DFS ����
            if (map[nRow][nCol] == 1 && !isVisited[nRow][nCol]) {
                // ������ ���� ����ؼ� Ž���ϸ� �� �� ����
                houseCnt += dfs(nRow, nCol);
            }
        }
        // ���� ���� ���� �� ������ ��ȯ
        return houseCnt;
    }
}
