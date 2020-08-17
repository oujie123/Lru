package com.gac.icv;

import javax.print.attribute.Size2DSyntax;

public class LruLinkedList<T> extends LinkedList<T> {

	int memSize;
	static final int DEFAULT_SIZE = 5;

	public LruLinkedList() {
		this(DEFAULT_SIZE);
	}

	public LruLinkedList(int memSize) {
		this.memSize = memSize;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LruLinkedList<Integer> linkedList = new LruLinkedList<>(5);
		for (int i = 0; i < 4; i++) {
			linkedList.lruPut(i);
		}
		linkedList.toString();
		System.out.println();
		System.out.println(linkedList.lruGet(3));
		linkedList.toString();
		
		//增加一个节点充满缓冲区
		System.out.println();
		linkedList.lruPut(55);
		linkedList.toString();
		
		//增加超出节点数
		System.out.println();
		linkedList.lruPut(11);
		linkedList.toString();
	}

	/**
	 * 使用lru算法添加节点
	 * 
	 * @param data
	 */
	public void lruPut(T data) {
		put(data);
		if (size > memSize) {
			removeLast();
		}
	}
	
	/**
	 * 删除没有使用的节点
	 * 
	 * @return
	 */
	public T lruRemove() {
		return removeLast();
	}
	
	/**
	 * Lru
	 * 
	 * @return
	 */
	public T lruGet(int index) {
		checkPosition(index);
		Node pre = list;
		Node cur = list;
		for (int i = 0; i < index; i++) {
			pre = cur;
			cur = cur.next;
		}
		T data = cur.data;
		//将访问的节点移到表头
		pre.next = cur.next;
		//使用头插法插入取出的节点
		//Node head = list;
		cur.next = list;
		list = cur;
		return data;
	}
}
