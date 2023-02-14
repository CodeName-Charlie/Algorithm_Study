package day0213;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2164 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		//N��  �Է¹���
		int N = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		//1���� N������ ���� �ϳ��� �߰���
		for(int i=1; i<=N; i++) {
			queue.add(i);
		}
		
		//�����
		int result =0;
		
		//N=1�� ��� �������� �ʱ� ������ �״�� ���
		if(queue.size()==1) {
			result = 1;
		//N=1�� �ƴ� ���
		}else {
			//ť�� ���� ������ 1�� �ƴ϶�� 1�� �ɶ����� ����
			while(queue.size()!=1) {
				//���� ���� �� ���� ����
				queue.poll();
				//�� ���� ���� num�� ����
				int num =queue.peek();
				//�� ���� ���� ����
				queue.poll();
				//num�� ���� �ٽ� ����
				queue.add(num);
		}
			//���� �Ѱ����� �̾Ƽ� Ȯ��
			result = queue.peek();
		}
		
		System.out.println(result);
	}
}
