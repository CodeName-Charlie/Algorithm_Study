package day0213;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		//�Ʒ�ó�� ����Ǳ� ������ �� ������ ���ϴ� ȣ������ �� ������� �Ѵ�.
//		0�� - 1 2 3 
//		1�� - 1 3(1+2) 6(1+2+3)
//		2�� - 1 4(1+3) 10(1+3+6)
//		3�� - 1 5(1+4) 15(1+4+10)
		Scanner sc = new Scanner(System.in);

		// �׽�Ʈ���̽�
		int testCase = sc.nextInt();

		for (int t = 0; t < testCase; t++) {
			// k��
			int k = sc.nextInt();
			// nȣ
			int n = sc.nextInt();

			// 0������ k������, 1ȣ���� nȣ����
			int[][] arr = new int[k + 1][n];
			
			//0���� ��� 1, 2, 3...���� �����ϹǷ� �Ʒ��� �� ����
			for (int i = 0; i < n; i++) {
				arr[0][i] = i + 1;
			}

			// �� ���� 1ȣ���� ��������� ȣ������ ��� ���ֹ��� ���� ���ϸ� ���� ���� ���� ȣ���� �����ϴ� ����� �ο�

			// 1�� �̻��� ���

			//f: ��, j: f�������� ȣ��, i: f-1�������� ȣ��
			for(int f = 1; f<=k; f++) {
				for (int j = 0; j < n; j++) {
					for (int i = 0; i <= j; i++) {
						//f-1�������� 0���� j������ ȣ�� �ο��� ��� ���Ѵ� = > f������ jȣ���� �ο�
						arr[f][j] += arr[f - 1][i];
					}
				}
			}
			//ȣ���� ��� 1ȣ���� �����ϱ� ������ nȣ���� n-1�� ȣ���� �����ؾ��Ѵ�
			System.out.println(arr[k][n - 1]);
		}
		sc.close();

	}
}













