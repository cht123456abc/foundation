package cn.edu.scu.algorithms.exercises.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. 复制带随机指针的链表
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *
 * 要求返回这个链表的 深拷贝。
 *
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 *
 *
 *
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * 示例 3：
 *
 *
 *
 * 输入：head = [[3,null],[3,0],[3,null]]
 * 输出：[[3,null],[3,0],[3,null]]
 * 示例 4：
 *
 * 输入：head = []
 * 输出：[]
 * 解释：给定的链表为空（空指针），因此返回 null。
 *
 *
 * 提示：
 *
 * -10000 <= Node.val <= 10000
 * Node.random 为空（null）或指向链表中的节点。
 * 节点数目不超过 1000 。
 */
public class CopyListWithRandomPointer_138 {

    // 方法一：用哈希表
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        // 创建映射关系
        while(p != null){
            map.put(p,new Node(p.val));
            p = p.next;
        }
        // 进行节点链接
        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

    //方法二：哈希递归版
    HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;// Random可能为null
        }
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);// Random可能为自身
        }
        Node node = new Node(head.val);
        this.visitedHash.put(head, node);
        node.next = this.copyRandomList2(head.next);
        node.random = this.copyRandomList2(head.random);

        return node;
    }


    // 方法三：我的垃圾算法
    public Node copyRandomList3(Node head) {
        // 第一次遍历原链表，用HashMap1记录链表中节点位置
        Node p = head;
        Map<Node,Integer> map = new HashMap<>();
        int index = 0;
        while(p != null){
            map.put(p,index);
            index++;
            p = p.next;
        }

        // 第二次遍历原链表，用HashMap2记录链表中节点Random的位置,并复制新链表，同时生成新链表数组，但暂不管Random
        Map<Node,Integer> map2 = new HashMap<>();
        Node[] nodes = new Node[index];
        p = head;
        index = 0;
        Node newHead = new Node(0);// dummynode
        Node p2 = newHead;
        while(p != null){
            Node random = p.random;
            int i = 0;
            if(random == null) i = Integer.MIN_VALUE;// 用最小数代表null
            else i = map.get(random);
            map2.put(p,i);
            // 同时生成新链表和节点数组
            Node node = new Node(p.val);
            nodes[index++] = node;
            p2.next = node;
            p2 = p2.next;
            p = p.next;
        }

        // 根据map2 和 nodes来还原Random
        p2 = newHead.next;
        p = head;
        while(p != null){
            int random_i = map2.get(p);
            if(random_i == Integer.MIN_VALUE) p2.random = null;
            else p2.random = nodes[random_i];
            p2 = p2.next;
            p = p.next;
        }
        return newHead.next;
    }
}
