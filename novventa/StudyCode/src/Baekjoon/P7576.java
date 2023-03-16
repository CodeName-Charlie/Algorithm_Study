package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// �丶�� ���� �迭�� ����� �丶�� ���¸� �Է¹��� ��
// BFS�� �Ἥ 4��Ž���ϸ鼭 �丶�並 ������.
// ���߿� ���� ���� �丶�䰡 ���� �� �����Ƿ�
// �ϳ��� ���鼭 Ȯ���Ѵ�.
// ��� �ʹ� ��¥�� ����Ѵ�.


public class P7576 {
	// �丶�� ���� ���� ���� ����
    static int N, M;
    // �丶�� ���� 2���� �迭
    static int[][] box;
    // �湮�ߴ��� Ȯ���ϴ� �迭
    static boolean[][] isVisited;
    // �� �� �� �� ��Ÿ�迭
    static int[] dRow = {0, 0, -1, 1};
    static int[] dCol = {-1, 1, 0, 0};

    public static void main(String[] args) {
    	// ��ĳ�� ����
        Scanner sc = new Scanner(System.in);
        // ������ ���� ����
        M = sc.nextInt(); 
        // ������ ���� ����
        N = sc.nextInt();
        // �丶�� ���� ����
        box = new int[N][M];
        // �湮�ߴ��� Ȯ���ϱ� ���� �迭 ����
        isVisited = new boolean[N][M];
        // ���� ���� �Է� �ޱ�
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                box[r][c] = sc.nextInt();
            }
        }

        // BFS ����
        int days = bfs();
        
        // ��� ���
        if (isRipe()) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }
    
    // BFS �޼���
    public static int bfs() {
    	// ���� ��¥�� �����ϴ� ����
        int days = 0;
        // 
        Queue<int[]> q = new LinkedList<>();

        // ���� �丶����� ť�� �ֱ�
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 1) {
                    q.offer(new int[]{r, c});
                    isVisited[r][c] = true;
                }
            }
        }

        // BFS ����
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];

                // ������ �� ���� �丶�並 ť�� �߰�
                for (int j = 0; j < 4; j++) {
                    int nRow = r + dRow[j];
                    int nCol = c + dCol[j];

                    // ��� ����
                    if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue;
                    // �湮�߰ų� ���� �ʾ����� 1�� �ٲ��ְ� �湮ó��
                    if (box[nRow][nCol] == 0 && !isVisited[nRow][nCol]) {
                        box[nRow][nCol] = 1;
                        isVisited[nRow][nCol] = true;
                        q.offer(new int[]{nRow, nCol});
                    }
                }
            }
         // ���� �丶�䰡 ������ days �������� ����
            if (!q.isEmpty()) days++; 
        }

        return days;
    }

    // �丶�䰡 ��� �;����� Ȯ���ϴ� �Լ�
    public static boolean isRipe() {
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (box[r][c] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
