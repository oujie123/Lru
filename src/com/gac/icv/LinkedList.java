package com.gac.icv;

public class LinkedList<T> {

	Node list;
    int size;
	
	public static void main(String[] args) throws InterruptedException {
		LinkedList<String> linkedList = new LinkedList<>(); 
		linkedList.put("String");
		linkedList.put("Jackou");
		linkedList.put("Jackou1");
		linkedList.put("Jackou2");
		//linkedList.put(2,"Jackou11111111111");
		//linkedList.remove();
		//linkedList.remove(1);
		System.out.println(linkedList.removeLast());
		int length = linkedList.getSize();
		LinkedList<String>.Node node = linkedList.getNode();
		for (int i = 0; i < length; i++) {
			System.out.println(node.data);
			node = node.next;
		}
	}
	
	/**
	 * 在头部加一个节点
	 * 
	 * @param data
	 */
	public void put(T data) {
		Node curNode = new Node(data, list);
		list = curNode;
		size++;
	}
	
	/**
	 * 在指定位置添加节点
	 * 
	 * @param index
	 * @param data
	 */
	public void put(int index, T data) {
		checkPosition(index);
		Node head = list;
		Node cur = list;
		for (int i = 0; i < index; i++) {
			head = cur;
			cur = cur.next;
		}
		Node node = new Node(data, cur);
		head.next = node;
		size++;
	}
	
	
	/**
	 * 删除头部节点
	 * 
	 * @return
	 */
	public T remove() {
		if (list != null) {
			Node node = list;
			list = list.next;
			node.next = null; 
			size--;
			return node.data;
		}
		return null;
	}
	
	/**
	 * 删除指定位置的元素
	 * 
	 * @param index
	 * @return
	 */
	public T remove(int index) {
		checkPosition(index);
		Node node = list;
		Node cur = list;
		for (int i = 0; i < index; i++) {
			node = cur;
			cur = cur.next;
		}
		node.next = cur.next;
		cur.next = null;
		size--;
		return cur.data;
	}
	
	/**
	 * 删除最后一个节点
	 * 
	 * @return
	 */
	public T removeLast() {
		if(list == null) {
			return null;
		}
		Node node = list;
		Node cur = list;
		while (cur.next != null) {
			node = cur;
			cur = cur.next;
		}
		node.next = null;
		size--;
		return cur.data;
	}
	
	/**
	 * 修改一个节点
	 * 
	 */
	public void set(int index,T data) {
		checkPosition(index);
		Node cur = list;
		for (int i = 0; i < index; i++) {
			cur = cur.next;
		}
		cur.data = data;
	}
	
	/**
	 * 查询头部节点
	 */
	public T get() {
		Node node = list;
		if (node != null) {
			return node.data;
		}
		return null;
	}
	
	/**
	 * 查询指定位置节点
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		checkPosition(index);
		Node cur = list;
		for (int i = 0;i < index; i++) {
			cur = cur.next;
		}
		return cur.data;
	}
	
	public int getSize() {
		return size;
	}
	
	private Node getNode() {
		return list;
	}
	
	/**
	 * 检查是否越界
	 * 
	 * @param index
	 */
	public void checkPosition(int index) {
		if(!(index < size && index >= 0)) {
			throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
		}
	}
	
	
	
	@Override
	public String toString() {
		Node node = list;
		for (int i = 0; i < size; i++) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		return super.toString();
	}



	class Node {
		T data;
		Node next;
		
		public Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
