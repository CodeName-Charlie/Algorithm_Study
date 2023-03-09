package BOJ;

import java.util.Scanner;

public class P1932 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
				
		// �ﰢ���� ������ �� ���� ���� �Է¹ޱ�
		int N = sc.nextInt();
        // �ﰢ���� ���ڵ��� ������ �迭 ����
		int[][] tri = new int[N][N];
		// ���ڵ� �Է¹ޱ�
		for(int i=0;i<N;i++) {
			for(int j=0;j<i+1;j++) {
				tri[i][j] = sc.nextInt();
			}
		}
			
	    // 1�� �����
		for(int i=1;i<N;i++) {
			for(int j=0;j<i+1;j++) {
		      	// j-1���� 0 �̻��̸�, ���� ���� �ڽŰ� ������(������ �밢��), ���� ��(���� �밢��) �� ū ���� �����ش�.
				if(j-1>=0)
					tri[i][j]+=Math.max(tri[i-1][j], tri[i-1][j-1]);
		            // �������� �ʴ� ��,�� ������ �ڽŰ� ������(���� �Ǵ� ������ �밢��)�� ���� ������ �� �ۿ� ����.    
				else
					tri[i][j]+=tri[i-1][j];
			}			
		}
		// �ִ밪�� ���ؾ��ϹǷ� �ʱⰪ�� �ſ� ���� ���� ����
		int max = Integer.MIN_VALUE;
				
		// �������࿡�� ���� �� �ִ� �ִ��� ���Ѵ�.
		for(int i=0;i<N;i++) {
			if(max<tri[N-1][i]) 
				max = tri[N-1][i];
		}
				
		System.out.println(max);		
	}
}

