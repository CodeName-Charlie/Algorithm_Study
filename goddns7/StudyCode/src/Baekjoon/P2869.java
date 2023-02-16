package day0213;

import java.util.LinkedList;
import java.util.Queue;

import java.util.Scanner;

public class P2869 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// N�� �Է¹���
		int N = sc.nextInt();
		int K = sc.nextInt();

		// int�� queue ����
		Queue<Integer> queue = new LinkedList<Integer>();
		// �����¿�
		Queue<Integer> result = new LinkedList<Integer>();
		// 1���� N������ ���� �ϳ��� �߰���
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}

		// N=1�� ��� �������� �ʱ� ������ �״�� ���
		if (queue.size() == 1) {
			result = queue;
			// N=1�� �ƴ� ���

			// �ö󰡴� A
			int a = sc.nextInt();
			// �������� B
			int b = sc.nextInt();
			// ����
			int v = sc.nextInt();

			// �ɸ��� ��
			int count = 0;

			// ����: �������� b�� �ö󰡴� a���� ������ �Ϸ� �� ���� �����
			// a*�ɸ��� �� - b*(�ɸ��³� -1) >= v�� �����ϸ鼭
			// �������� ���ٸ� �״��,
			// �������� �ִٸ� +1�� �����ָ� �ɸ��� ���� ���� �� �ִ�.
			if ((v - b) % (a - b) == 0) {
				count = (v - b) / (a - b);
			} else {
				// ť�� ���� ������ 1�� �ƴ϶�� 1�� �ɶ����� ����
				while (!queue.isEmpty()) {
					// K������ ����
					for (int n = 1; n < K; n++) {
						queue.offer(queue.poll());
					}
					// K�� result�� �߰�
					result.offer(queue.poll());
				}

				count = ((v - b) / (a - b)) + 1;
			}
			System.out.print("<");
			// �߰��� �͵� �ϳ��� ���
			for (int i = 1; i < N; i++) {
				System.out.print(result.poll() + ", ");
			}
			System.out.print(result.poll());
			System.out.print(">");

			System.out.println(count);
			sc.close();
		}
	}
}