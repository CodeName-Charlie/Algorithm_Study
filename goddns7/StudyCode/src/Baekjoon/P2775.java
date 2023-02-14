package day0213;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
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

			for (int i = 0; i < n; i++) {
				arr[0][i] = i + 1;
			}

			// �� ���� 1ȣ���� ��������� ȣ������ ��� ���ֹ��� ���� ���ϸ� ���� ���� ���� ȣ���� �����ϴ� ����� �ο�

			// 1�� �̻��� ���
			for(int f = 1; f<=k; f++) {
				for (int j = 0; j < n; j++) {
					for (int i = 0; i <= j; i++) {
						arr[f][j] += arr[f - 1][i];
					}
				}
			}

			System.out.println(arr[k][n - 1]);
		}
		sc.close();

	}
}

