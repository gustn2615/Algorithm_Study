package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// ȸ�� ��
		int N = Integer.parseInt(br.readLine());
		
		// �ð� ���� �迭
		int[][] time = new int[N][2];
		
		int cnt = 0;
		
		int endTime = 0;
		
		// ȸ�� ���� �� �ð� �Է¹ޱ�
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			time[i][0] = Integer.parseInt(st.nextToken());
			time[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// ȸ�� ������ �ð� ������ ����
		Arrays.sort(time, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				// ȸ�� ������ �ð��� ������ ���۽ð��� ���� ���� ����
				if(o1[1] == o2[1])
					return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		});
		
		// ȸ�ǽð� �ϳ��� ��� ��
		for(int i=0;i<N;i++) {
			// ȸ�� ������ �ð��� ���� ȸ�� ���۽ð����� ������
			if(endTime <= time[i][0]) {
				// ȸ�� ������ �ð� �����ϰ� cnt+1
				endTime = time[i][1];
				cnt++;
			}
		}
		
		// ���
		System.out.println(cnt);
		
	}
}