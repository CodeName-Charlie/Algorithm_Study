package day0213;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P11866 {
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		//N��  �Է¹���
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		//int�� queue ����
		Queue<Integer> queue = new LinkedList<Integer>();
		//�����¿�
		Queue<Integer> result = new LinkedList<Integer>();
		//1���� N������ ���� �ϳ��� �߰���
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		
		//N=1�� ��� �������� �ʱ� ������ �״�� ���
		if(queue.size()==1) {
			result = queue;
		//N=1�� �ƴ� ���
		}else {
			//ť�� ���� ������ 1�� �ƴ϶�� 1�� �ɶ����� ����
			while(!queue.isEmpty()) {
				//K������ ����
				for(int n = 1; n < K; n++) {
				queue.offer(queue.poll());
				}
				//K�� result�� �߰�
				result.offer(queue.poll());
			}
			
		}
		System.out.print("<");
		//�߰��� �͵� �ϳ��� ���
		for(int	i=1; i<N; i++) {
			System.out.print(result.poll()+", ");	
		}
		System.out.print(result.poll());
		System.out.print(">");
	}
}