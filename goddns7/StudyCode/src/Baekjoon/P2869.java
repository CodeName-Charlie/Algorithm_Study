package day0213;

import java.util.Scanner;

public class P2869 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			// �ö󰡴� A
			int a = sc.nextInt();
			// �������� B
			int b = sc.nextInt();
			// ����
			int v = sc.nextInt();

			//�ɸ��� ��
			int count = 0;
			
			//�������� ���� ���� �ٷ� ���
			if((v-b)%(a-b)==0) {
				count = (v-b)/(a-b);
			//�������� ������ �� �ö󰡾� �ϱ� ������ +1�� ���ش�
			}else {
				count = ((v-b)/(a-b))+1;
			}
			
			System.out.println(count);
			sc.close();
		
	}
}
