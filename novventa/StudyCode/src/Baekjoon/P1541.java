package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1541 {
	// �� ������ Ǯ�� ���ؼ���
	// ������ ���ϸ��� ����ϰ� ������ ������ ����ؾ� �Ѵ�.
	// ���� ������ �������� ������
	// ��Ʈ���� ���� �� ������ ����Ѵ�.
	
	
	public static void main(String[] args) throws IOException {

		// ���۵帮�� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// �ּڰ� ����
		int min = Integer.MAX_VALUE;
		// ���ڿ� �迭�� �Է¹ް� ���⸦ �������� ������
		String[] arr = br.readLine().split("-");

		// ���ڿ� ���̸�ŭ �ݺ�
		for (int i = 0; i < arr.length; i++) {
			// �ӽ� �� ����
			int tmp = 0;
			// ���⸦ �������� ���� ��Ʈ���� �� ������ �������� ������
			String[] add = arr[i].split("\\+");

			// �ӽð��� �����ش�.
			for (int j = 0; j < add.length; j++) {
				tmp += Integer.parseInt(add[j]);
			}

			// ó�� ���� �� �����ϱ� ����
			if (min == Integer.MAX_VALUE)
				min = tmp;
			// �ι�°���ʹ� ���ش�.
			else
				min -= tmp;

		}

		// ���
		System.out.println(min);
	}

}
