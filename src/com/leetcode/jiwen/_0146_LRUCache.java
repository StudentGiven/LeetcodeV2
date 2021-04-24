package com.leetcode.jiwen;

import java.util.HashMap;

public class _0146_LRUCache {

    // Double linked list
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }

    class LRUCache {

        private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
        int count;
        int capacity;
        private DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.pre = null;
            tail.post = null;

            head.post = tail;
            tail.pre = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }

            moveToHead(node);

            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);

            if (node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;

                cache.put(key, newNode);
                addNode(newNode);
                count++;

                if (count > capacity) {
                    // pop the tail
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    count--;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        /**
         * Always add the new node right after head.
         */
        private void addNode(DLinkedNode node) {
            node.pre = head;
            node.post = head.post;

            head.post.pre = node;
            head.post = node;
        }

        /**
         * Remove an existing node from the linked list.
         */
        private void removeNode(DLinkedNode node) {
            DLinkedNode pre = node.pre;

            pre.post = node.post;
            node.post.pre = pre;
        }

        /**
         * Move certain node in between to the head.
         */
        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        /**
         * Pop the current tail.
         */
        private DLinkedNode popTail() {
            DLinkedNode res = tail.pre;
            removeNode(res);

            return res;
        }

    }

}
