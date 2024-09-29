package cn.edu.scu.middle;

import java.util.Random;

class SkipListNode {
    int value;
    SkipListNode[] forward;

    public SkipListNode(int value, int level) {
        this.value = value;
        this.forward = new SkipListNode[level + 1];
    }
}

public class SkipList {
    private static final int MAX_LEVEL = 16; // 最大层数
    private int levelCount = 1; // 当前跳表的层数
    private SkipListNode head = new SkipListNode(-1, MAX_LEVEL); // 头节点
    private Random random = new Random();

    // 随机生成层数
    private int randomLevel() {
        int level = 1;
        while (random.nextDouble() < 0.5 && level < MAX_LEVEL) {
            level++;
        }
        return level;
    }

    // 插入元素
    public void insert(int value) {
        int level = randomLevel(); // 随机生成层数
        SkipListNode newNode = new SkipListNode(value, level); // 创建新节点

        // 如果新生成的层数大于当前层数，更新层数
        if (level > levelCount) {
            levelCount = level;
        }

        SkipListNode[] update = new SkipListNode[levelCount + 1]; // 用于记录每一层的前驱节点
        SkipListNode current = head;

        // 从最高层开始，找到每一层的前驱节点
        for (int i = levelCount - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        // 更新每一层的前驱节点的指针
        for (int i = 0; i < level && update[i] != null; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }


    }

    // 查找元素
    public boolean search(int value) {
        SkipListNode current = head;

        // 从最高层开始查找
        for (int i = levelCount - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
        }

        // 检查最底层的节点是否等于目标值
        if (current.forward[0] != null && current.forward[0].value == value) {
            return true;
        } else {
            return false;
        }
    }

    // 删除元素
    public void delete(int value) {
        SkipListNode[] update = new SkipListNode[levelCount + 1];
        SkipListNode current = head;

        // 从最高层开始，找到每一层的前驱节点
        for (int i = levelCount - 1; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].value < value) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        // 如果找到目标节点，更新每一层的前驱节点的指针
        if (current.forward[0] != null && current.forward[0].value == value) {
            for (int i = 0; i < levelCount; i++) {
                if (update[i].forward[i] != null && update[i].forward[i].value == value) {
                    update[i].forward[i] = update[i].forward[i].forward[i];
                }
            }
        }

        // 如果删除的节点是最高层的节点，更新层数
        while (levelCount > 1 && head.forward[levelCount - 1] == null) {
            levelCount--;
        }
    }

    // 打印跳表
    public void printSkipList() {
        for (int i = levelCount - 1; i >= 0; i--) {
            SkipListNode current = head.forward[i];
            System.out.print("Level " + i + ": ");
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.forward[i];
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        skipList.insert(17);
        skipList.insert(26);
        skipList.insert(21);
        skipList.insert(25);
        skipList.printSkipList();

        System.out.println("Search 19: " + skipList.search(19));
        System.out.println("Search 15: " + skipList.search(15));

        skipList.delete(19);
        skipList.printSkipList();

        System.out.println("Search 19: " + skipList.search(19));
    }
}