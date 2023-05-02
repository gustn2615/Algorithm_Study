import java.util.Scanner;

/**
 * @author jihye.byun
 * BOJ 2630 ������ ����� �ǹ�2 ��������
 * 
 * ����
 * ���簢��ĭ��� �̷���� ���簢�� ����� ����
 * �� ���簢�� ĭ���� �Ͼ��or�Ķ������� ĥ���� �ִ�.
 * �־��� ���̸� ������ ��Ģ�� ���� �߶� �پ��� ũ�⸦ ���� ���簢�� �����
 * �Ͼ�� �Ǵ� �Ķ��� �����̸� ������.
 * 
 * ��ü ������ ũ�Ⱑ N*N�϶�...
 * 1. ��ü ���̰� ��� ���� ������ ĥ���� ���� ������ ���ο� ������ �߰� �κ��� �߶�
 * 		�� ���� N/2 �� N/2�����̷� ������.
 * 2. �������� ���̿� ���ؼ��� ��� ���� ������ ĥ���� ���� ������ 1���� �ݺ��Ѵ�.
 * 3. �� ������ �߶��� ���̰� ��� �Ͼ�� �Ǵ� ��� �Ķ������� ĥ���� �ְų�,
 * 		�ϳ��� ���簢�� ĭ�� �Ǿ� �� �̻� �ڸ� �� ���� ������ �ݺ��Ѵ�.
 * 
 * �߶��� �Ͼ�� �����̿� �Ķ��� �������� ������ ������.
 * 
 * ����
 * ������ ũ�� N (N=2^k), k�� 1�̻� 7������ �ڿ���
 * => N�� 2, 4, 8, 16, 32, 64, 128 �� �ϳ�
 * �Ͼ������ ĥ���� ĭ�� 0, �Ķ������� ĥ���� ĭ�� 1�� �־�����.
 * 
 * Ǯ��
 * 1. �����̸� ���μ��� ���ݾ� �����ؼ� 0�� ������ 1�� ������ ��������.
 * 1-1. 0�� ������ 1�̻��̰� 1�� ������ 1�̻��̸� �� ���ҽ�Ű��.
 * 2. ��� ĭ�� �� �����µ� �� �� �ϳ��� ������ ī��Ʈ �ƴٸ�?
 * 2-1. �� �������� ���� ���� ������ ���� ������ +1 �ϰ� ��������.
 * 3. ������ �����뼱��? start + 1 == end �� ��
 */

public class P2630 {
	
	static int N, white, blue;
	static int[][] paper;
	
	private static void checkColor(int rowStart, int rowEnd, int colStart, int colEnd) {
		// �� ���� start ~ end-1 ������ �����̰� ��� �ϳ��� ������ �̷���� �ִ��� Ȯ���ϴ� method
		
		// ������ �Ͼ��0 �� �Ķ���1�� ������ ������ ������ ������
		int curWhite = 0;
		int curBlue = 0;
		
		for (int row = rowStart; row < rowEnd; row++) {
			for (int col = colStart; col < colEnd; col++) {
				// ���� ĭ�� 0�̸� �Ͼ�� ������ �����ְ�
				if (paper[row][col] == 0)
					curWhite++;
				// ���� ĭ�� 1�̸� �Ķ��� ������ ��������
				else
					curBlue++;
				
				// ���� ������ ������ �Ͼ���� �Ķ����� �����ִٸ�?
				// ������ �� ������ �۷���!
				// 4����ϰ� �� Ȯ���� �ʿ� ������ ��ȯ���ѹ�����
				if (curWhite > 0 && curBlue > 0) {
					divide(rowStart, rowEnd, colStart, colEnd);
					return;
				}
			}
		}
		
		// �������� ��� ĭ�� Ȯ���ߴµ� �ϳ��� �����θ� �̷���� �ִٸ�?
		// �� �����̴� �� �̻� �ɰ��� �ʾƵ� �ȴ�!
		// ������ ���� 1 ī��Ʈ������
		if (curWhite > 0)
			white++;
		else
			blue++;
		
		return;
	}
	
	private static void divide(int rowStart, int rowEnd, int colStart, int colEnd) {
		// ���� ������ ������ ��� ���� ������ �̷������ ���� ��� �����̸� �� ���� �������� �и���Ű�� method
		
		// ��������
		// start + 1 == end ���? �� �̻� �ɰ� �� ����
		if (rowStart + 1 == rowEnd && colStart + 1 == colEnd) {
			// �� ĭ�� ���� ���� �����ְ� ��ȯ��Ű��
			if (paper[rowStart][colStart] == 0)
				white++;
			else
				blue++;
			return;
		}
		
		// �� �ɰ� �� �ִ� ũ��� 1/4�� �ɰ��� ������ ���� ������ Ȯ������
		int rowMid = (rowStart + rowEnd) / 2;
		int colMid = (colStart + colEnd) / 2;
		
		checkColor(rowStart, rowMid, colStart, colMid);
		checkColor(rowStart, rowMid, colMid, colEnd);
		checkColor(rowMid, rowEnd, colStart, colMid);
		checkColor(rowMid, rowEnd, colMid, colEnd);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt(); // ������ ũ�� �Է¹ޱ�
		
		paper = new int[N][N]; // �Ͼ���� �Ķ������� �̷���� ��ü ������ ����
		
		// ������ ���� �Է¹ޱ�
		sc.nextLine();
		for (int row = 0; row < N; row++) {
			String[] line = sc.nextLine().split(" ");
			for (int col = 0; col < N; col++) {
				paper[row][col] = Integer.parseInt(line[col]);
			}
		}
		
		// �����̸� �����ؼ� Ȯ���غ��� ���� �ϴ� �ʱ� �Ͼ��, �Ķ��� ������ ���� 0���� �ʱ�ȭ
		white = blue = 0;
		
		// ���� �����̰� ��� ���� ������ Ȯ���غ���
		checkColor(0, N, 0, N);
		
		// ������ ������ �� ���� �����ؼ� Ȯ���� ���� �Ͼ�� ���� ����, �Ķ��� ���� ������ �������
		System.out.println(white);
		System.out.println(blue);
	}

}
