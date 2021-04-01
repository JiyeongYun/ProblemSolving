package boj;

/**
 * 2021-04-02
 * BOJ 1991 - 트리 순회
 * Memory: 11,840KB
 * Execution Time: 80ms
 */

import java.util.*;
import java.io.*;

class Node {
	char data;
	Node left;
	Node right;

	Node(char data) {
		this.data = data;
	}
}

class Tree {
	Node root;

	public void createNode(char data, char leftData, char rightData) {
		if (root == null) {
			root = new Node(data);

			if (leftData != '.') // 왼쪽에 node가 있는 경우에만 객체 생성 후 값 넣기
				root.left = new Node(leftData);
			if (rightData != '.') // 오른쪽에 node가 있는 경우에만 객체 생성 후 값 넣기
				root.right = new Node(rightData);
		} else { // 위치 찾기
			searchNode(root, data, leftData, rightData);
		}
	}

	public void searchNode(Node root, char data, char leftData, char rightData) {
		if (root == null) {
			return;
		} else if (root.data == data) {
			if (leftData != '.') // 왼쪽에 node가 있는 경우에만 객체 생성 후 값 넣기
				root.left = new Node(leftData);
			if (rightData != '.') // 오른쪽에 node가 있는 경우에만 객체 생성 후 값 넣기
				root.right = new Node(rightData);
		} else {
			searchNode(root.left, data, leftData, rightData); // 왼쪽으로 다시 찾기
			searchNode(root.right, data, leftData, rightData); // 오른쪽으로 다시 찾기
		}
	}

	public void preorder(Node root) {
		BOJ1991.sb.append(root.data);
		if (root.left != null) preorder(root.left);
		if (root.right != null) preorder(root.right);
	}

	public void inorder(Node root) {
		if (root.left != null) inorder(root.left);
		BOJ1991.sb.append(root.data);
		if (root.right != null) inorder(root.right);
	}

	public void postorder(Node root) {
		if (root.left != null) postorder(root.left);
		if (root.right != null) postorder(root.right);
		BOJ1991.sb.append(root.data);
	}

}

public class BOJ1991 {
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(in.readLine());
		Tree tree = new Tree();
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			tree.createNode(st.nextToken().charAt(0), st.nextToken().charAt(0), st.nextToken().charAt(0));
		}
		
		tree.preorder(tree.root);
		sb.append("\n");
		tree.inorder(tree.root);
		sb.append("\n");
		tree.postorder(tree.root);
		
		out.write(sb.toString());
		out.close();
		in.close();
	}

}
