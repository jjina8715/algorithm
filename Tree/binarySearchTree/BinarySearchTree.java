package binarySearchTree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {
	private Node root;

	public BinarySearchTree() {
		root = null;
	}

	public void add(int val) {
		Node cur = root;
		Node pre = null;
		while(cur!=null) {
			if(cur.val == val) 
				return;
			pre = cur;
			if(cur.val < val)
				cur = cur.right;
			else 
				cur = cur.left;
		}
		Node node = new Node(val);
		if(root==null){
			root = node;
		}else if(pre.val<val)
			pre.right = node;
		else
			pre.left = node;
	}

	public Boolean search(int val) {
		Node cur = root;
		while(cur!=null) {
			if(cur.val == val) 
				return true;
			if(cur.val < val)
				cur = cur.right;
			else 
				cur = cur.left;
		}
		return false;
	}

	public Boolean remove(int val) {
		Node cur = root;
		Node pre = null;
		while(cur!=null) {
			pre = cur;
			if(cur.val == val) {
				if(cur.left==null&&cur.right==null) {
					if(pre.left == cur)
						pre.left = null;
					else
						pre.right = null;
				}else if(cur.left==null||cur.right==null) {
					if(pre.left == cur){
						pre.left = (cur.left==null?cur.right:cur.left);
					}else {
						pre.right = (cur.left==null?cur.right:cur.left);
					}
				}else {
					Node chg = cur.right;
					Node preChg = null;
					while(chg.left!=null) {
						preChg = chg;
						chg = chg.left;
					}
					if(preChg.left == chg)
						preChg.left = chg.right;
					else
						preChg.right = chg.right;
					cur.val = chg.val;
					
				}
				return true;
			}
			if(cur.val < val)
				cur = cur.right;
			else 
				cur = cur.left;
		}
		return false;
	}

	private int getkMinVal() {
		Node cur = root;
		while(cur.left!=null) 
			cur = cur.left;
		return cur.val;
	}

	private int getkMaxVal() {
		Node cur = root;
		while(cur.right!=null)
			cur = cur.right;
		return cur.val;
	}

	public void printTree() {
		System.out.print("[Print tree]");
		System.out.printf("\nMin value: %d", getkMinVal());
		System.out.printf("\nMax value: %d", getkMaxVal());
	/*	System.out.print("\nIn-order : ");
		printInOrder(this.root);
		System.out.print("\nPre-order : ");
		printPreOrder(this.root);
		System.out.print("\nPost-order : ");
		printPostOrder(this.root);
		System.out.print("\nLevel-order : ");
		printLevelOrder(this.root);*/
	}

	private void printInOrder(Node current) {
		//(5)번 구현
	}

	private void printPreOrder(Node current) {
		//(5)번 구현
	}

	private void printPostOrder(Node current) {
		//(5)번 구현
	}

	private void printLevelOrder(Node current) {
		//(5)번 구현
	}
}
