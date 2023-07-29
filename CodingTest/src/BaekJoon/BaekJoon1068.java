package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BaekJoon1068 { // 트리(G5)
	static int answer, remove;
	static Node[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = new Node(i);
		}
		int root = 0;
		for(int i=0; i<N; i++) {
			int parent = Integer.parseInt(st.nextToken());
			if(parent == -1) {
				root = i;
				continue;
			}
			arr[parent].childs.add(arr[i]);
		}
		remove = Integer.parseInt(br.readLine());
		if(remove != root) {
			deleteNode(root);
			dfs(root);
		}
	}
	static void deleteNode(int idx) {
		for(Node child : arr[idx].childs) {
			if(child.idx == remove) {
				arr[idx].childs.remove(child);
				return;
			}
			deleteNode(child.idx);
		}
	}

	static void dfs(int idx) {
		if (arr[idx].childs.size() == 0) {
			answer++;
			return;
		}
		
		for(Node child : arr[idx].childs) {
			dfs(child.idx);
		}
	}
	static class Node {
		int idx;
		ArrayList<Node> childs = new ArrayList<>();
		public Node(int idx) {
			this.idx = idx;
		}
	}

}
