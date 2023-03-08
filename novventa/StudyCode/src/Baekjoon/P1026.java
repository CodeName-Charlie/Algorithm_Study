package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class P1026 {
	public static void main(String[] args) {
		// �迭 2���� �־�����
		// �� �迭�� ��ҵ��� ���� ������ ��
		// �ּڰ��� ã�� ����
		// ���������� �ι�° �迭�� �������� ����� ������
		// �ּڰ��� ã���� �ǹǷ� �׳� ��������
		// ���߿� �ð��� ������ �������� �ʰ� Ǯ���
		
		// ��ĳ�� ����
		Scanner sc = new Scanner(System.in);
		// ������ ���� �Է¹ޱ�
		int N = sc.nextInt();
		// ù��° ���ڵ��� ������ �迭
		int[] firstArr = new int[N];
		// �ι�° ���ڵ��� ������ �迭
		int[] secondArr = new int[N];
		// ù��° �迭 ���ڵ� �Է¹ޱ�
		for(int i=0;i<N;i++) {
			firstArr[i] = sc.nextInt();
		}
		// �ι�° �迭 ���ڵ� �Է¹ޱ�
		for(int i=0;i<N;i++) {
			secondArr[i] = sc.nextInt();
		}		
		// �Ѵ� �����ϱ�
		Arrays.sort(firstArr);
		Arrays.sort(secondArr);
		// �ι�° �迭�� �ε����� ���� ����
		int idx=N-1;
		// ���� ���� ������ ����
		int sum = 0;
		// ù��° �迭�� ���� ������, �ι�° �迭�� ū ������ �����ָ� �ȴ�.
		for(int i=0;i<N;i++) {
			sum += firstArr[i]*secondArr[idx--];
		}
		// ���
		System.out.println(sum);
		
	}
}
