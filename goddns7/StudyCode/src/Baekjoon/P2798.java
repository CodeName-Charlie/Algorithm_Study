package day0213;

import java.util.Scanner;

public class P2798 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 3���� ���� �̰�, �� ������ �� ���� ���� ��,
		// ������ ���� �ȿ� �ش� �Ǵ� �͵� �� ���� ū ���� ã�������Ѵ�.

		// ī���� ����
		int card = sc.nextInt();
		// ������ �ȵǴ� ��
		int limit = sc.nextInt();

		// ī���� ���� ���� �迭
		int[] arr = new int[card];

		// �迭�� ī�� �� ����
		for (int i = 0; i < card; i++) {
			arr[i] = sc.nextInt();
		}

		// 3���� ���� �յ��� ��� ���� �迭
		int[] sum = new int[1000000];

		// sum�� �迭���� ���� �ٸ� �� ������ �̾� ���� ���� sum �迭�� ���ҷ� �ִ´�.
		int s = 0;
		// ��� ���� �� �ϳ��� ��
		for (int i = 0; i < card; i++) {
			// ��� ���� �� �ϳ��� ��
			for (int j = 0; j < card; j++) {
				// i�� �ٸ� ���Ҹ� ���ߴٸ�
				if (j != i) {
					// ��� ���� �� �ϳ��� �� ��
					for (int k = 0; k < card; k++) {
						// i�� j�� �ٸ� ���Ҹ� ���ߴٸ�
						if (k != i && k != j) {
							// ���� �ٸ� ���Ҹ� ���ϰ� �� ���� ���� sum�� �迭�� ������ ������ �ִ´�.
							sum[s++] = arr[i] + arr[j] + arr[k];
						}
					}
				}
			}
		}

		// M�� ���� �ʴ� ���� ��� �ִ밪�� ã�´�.
		int max = 0;
		for (int q = 0; q < 1000000; q++) {
			// M�� ���� �ʴ� ���̰�
			if (sum[q] <= limit) {
				// max���� ũ�ٸ�
				if (sum[q] > max) {
					// �� ���� max�� ���� �ȴ�.
					max = sum[q];
				}
			}
		}

		System.out.println(max);

		sc.close();
	}
}



