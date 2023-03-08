// 문제 조건
// 설탕을 정확하게 N킬로그램을 배달해야 한다.
// 봉지는 3KG과 5KG이 있다.
// 가장 적은 봉지를 배달해보자.
// 숫자 N은 3이상 5000 이하다.

// 문제 해결 방법
// 1-1. 숫자를 입력 받고, 최솟값을 저장할 변수를 만들자.
// 1-2. 입력받은 숫자가 변하지 않도록 변수를 만들어 저장해놓자.
// 1-3. 봉지의 갯수를 셀 변수를 만들자.
// 2-1. 최소 봉지를 세기 위해
// 범위를 i는 0부터, 입력받은 숫자/5 까지 반복하는 반복문을 만든다.
// 2-2. 봉지의 갯수(cnt)에 i만큼 더한 후,
// 입력받은 숫자에서 5*i만큼 뺀 것을 X라고 하자.
// 다시 X를 3으로 나눈 몫을 cnt에 더한다.
// 이때 X를 3으로 나누었을 때 나머지가 0이 아니라면, continue한다.
// 나머지가 0이라면 최솟값과 비교하여 더 작은 숫자를 최솟값 변수에 저장하자.

package Baekjun;

import java.util.Scanner;

public class P2839 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// 숫자를 입력 받자.
		int num = sc.nextInt();

		// 최솟값을 구하기 위해 최솟값에 N의 최대 범위인 5000을 저장한다.
		int min = 5000;

		// 숫자가 바뀌지 않기 위해 숫자를 저장해 놓을 변수를 만든다.
		int newNum = num;

		// 봉지의 갯수를 셀 변수를 만든다.
		int cnt = 0;

		// 반복문의 범위는 숫자에 5를 나눈 값 까지로 한다.
		// 숫자가 23이라면, 범위는 i가 0부터 4까지 이므로
		// 5가 0개 부터 4개까지 들어갈 수 있다.
		for (int i = 0; i <= (num / 5); i++) {
			// 반복문이 한번 돌 때 마다 저장해놓은 변수를
			// num 값으로 초기화 시킨다.
			newNum = num;

			// 5가 i만큼 들어왔으니
			// 봉지의 갯수를 i만큼 늘린 후
			cnt += i;

			// 새로운 숫자는 5*i만큼 빼주자.
			newNum -= 5 * i;

			// 나머지 숫자에 3을 나눈 몫 값을
			// 봉지의 갯수에 더해주고
			cnt += newNum / 3;

			// 나머지 숫자를 3으로 나눴을 때 나머지가 0이 아니라면
			// cnt를 0으로 초기화 시키고 계속하자.
			if (newNum % 3 != 0) {
				cnt = 0;
				continue;
			}
			// 나머지 숫자를 3으로 나눴을 때 나머지가 0이라면
			// 더 작은 값을 min에 저장하자.
			else {
				min = Math.min(min, cnt);
				// 반복문이 끝날때는 cnt를 0으로 초기화 시킨다.
				cnt = 0;

			}

		}
		// 5와 3으로 만들어질 수 없는 조합이라면
		// min값에는 초기값인 5000이 저장되어 있을 것이니
		// min이 5000이라면 -1로 바꿔주자.
		if (min == 5000)
			min = -1;

		// 출력
		System.out.println(min);

	}
}