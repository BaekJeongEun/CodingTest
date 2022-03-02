package SWExpertAcademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWExpertAcademy1873 {
	static int x_index = 0, y_index = 0;
	static int h, w;
	static String arr[][];
	// �� �� �� ��
	static int dr[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int dir[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		StringTokenizer h_w;
		String row[];

		for (int tc = 0; tc < TC; tc++) {
			h_w = new StringTokenizer(br.readLine());
			h = Integer.parseInt(h_w.nextToken());
			w = Integer.parseInt(h_w.nextToken());
			arr = new String[h][w];
			// �迭�� �� ����
			for (int h1 = 0; h1 < h; h1++) {
				row = br.readLine().split("");
				for (int w1 = 0; w1 < w; w1++) {
					arr[h1][w1] = row[w1];
					if (row[w1].equals("<") || row[w1].equals(">") || row[w1].equals("^") || row[w1].equals("v")) {
						x_index = h1;
						y_index = w1;
						if (row[w1].equals("^"))
							dir = dr[0];
						else if (row[w1].equals("v"))
							dir = dr[1];
						else if (row[w1].equals("<"))
							dir = dr[2];
						else if (row[w1].equals(">"))
							dir = dr[3];
					}
				}
			}

			// ����ڰ� ���� �Է� ����
			int N = Integer.parseInt(br.readLine());
			String command[] = br.readLine().split("");
			// ��ɾ� ����
			for (int i = 0; i < command.length; i++) {
				// ���������� ������ ������ ��쿡�� �̵� ����, ������ �ƴ϶�� ������ ���⸸ ���� ��, ��ġ�� ���� X
				if (command[i].equals("U")) {
					// ���� ���� ���
					arr[x_index][y_index] = "^";
					dir = dr[0];
					move(arr[x_index][y_index], dir);
				} else if (command[i].equals("D")) {
					// �Ʒ��� ���� ���
					arr[x_index][y_index] = "v";
					dir = dr[1];
					move(arr[x_index][y_index], dir);
				} else if (command[i].equals("L")) {
					// �������� ���� ���
					arr[x_index][y_index] = "<";
					dir = dr[2];
					move(arr[x_index][y_index], dir);
				} else if (command[i].equals("R")) {
					// ���������� ���� ���
					arr[x_index][y_index] = ">";
					dir = dr[3];
					move(arr[x_index][y_index], dir);
				} else if (command[i].equals("S")) {
					// ���� ���
					shoot(x_index, y_index);
				}

			}
			System.out.print("#"+(tc+1)+" ");
			for (int h1 = 0; h1 < h; h1++) {
				for (int w1 = 0; w1 < w; w1++) {
					System.out.print(arr[h1][w1]);
				}
				System.out.println();
			}
		}
	}

	// ������ �޼ҵ�
	static public void move(String command, int dir[]) {
		// �������� �� ������ ���
		if ((x_index + dir[0]) < h && (y_index + dir[1]) < w
				&& (x_index + dir[0]) >= 0 
				&& (y_index + dir[1]) >= 0 
				&& arr[x_index + dir[0]][y_index + dir[1]].equals(".")
				) {
			arr[x_index][y_index] = ".";
			arr[x_index + dir[0]][y_index + dir[1]] = command;
			x_index += dir[0];
			y_index += dir[1];
		}
	}

	static public void shoot(int x, int y) {
		boolean exit = false;
		int i = x + dir[0];
		int j = y + dir[1];

		while (true) {
			if (i >= 0 && i < h && j >= 0 && j < w) {
				if (arr[i][j].equals(".") || arr[i][j].equals("-")) {
					i = i + dir[0];
					j = j + dir[1];
					continue;
				}
				if (arr[i][j].equals("*")) {
					arr[i][j] = ".";
					exit = true;
					break;
				} else {
					exit = true;
					break;
				}

			}
			else break;
		}

	}
}
