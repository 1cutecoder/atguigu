package leetcode.datastruct;

/**
 * 类描述
 *
 * @author zcl
 * @Description 跳表实现
 * @Date 2022/6/27 10:10
 */
public class Skiplist {
    /**
     * 最大层数
     */
    private static int DEFAULT_MAX_LEVEL = 32;

    /**
     * 随机层数概率，也就是随机出的层数，在 第1层以上(不包括第一层)的概率，层数不超过maxLevel，层数的起始号为1
     */
    private static double DEFAULT_P_FACTOR = 0.25;
    Node head = new Node(null, DEFAULT_MAX_LEVEL);
    /**
     * 表示当前nodes的实际层数，从1开始
     */
    int currentLevel = 1;


    public Skiplist() {

    }

    public boolean search(int target) {
        Node searchNode = head;
        for (int i = currentLevel - 1; i >= 0; i--) {
            searchNode = findClosest(searchNode, currentLevel, target);
            if (target == searchNode.next[i].value) {
                return true;
            }
        }
        return false;

    }

    public void add(int num) {
        int level = randomLevel();
        Node updateNode = head;
        Node newNode = new Node(num, level);
        // 计算出当前num 索引的实际层数，从该层开始添加索引
        for (int i = currentLevel - 1; i >= 0; i--) {
            //找到本层最近离num最近的list
            updateNode = findClosest(updateNode, i, num);
            if (i < level) {
                if (updateNode.next[i] == null) {
                    updateNode.next[i] = newNode;
                } else {
                    Node temp = updateNode.next[i];
                    updateNode.next[i] = newNode;
                    newNode.next[i] = temp;
                }
            }
        }
        //如果随机出来的层数比当前的层数还大，那么超过currentLevel的head 直接指向newNode
        if (level > currentLevel) {
            for (int i = currentLevel; i < level; i++) {
                head.next[i] = newNode;
            }
            currentLevel = level;
        }
    }

    public boolean erase(int num) {
        Node searchNode = head;
        boolean isErased = false;
        for (int i = currentLevel - 1; i >= 0; i--) {
            Node node = findClosest(searchNode, i, num);
            if (num == node.next[i].value) {
                node.next[i] = node.next[i].next[i];
                isErased = true;
            }
        }
        return isErased;
    }

    private Node findClosest(Node node, int levelIndex, int value) {
        while ((node.next[levelIndex]) != null && value > node.next[levelIndex].value) {
            node = node.next[levelIndex];
        }
        return node;
    }

    int randomLevel() {
        int level = 1;
        while (Math.random() < DEFAULT_P_FACTOR && level < DEFAULT_MAX_LEVEL) {
            level++;
        }
        return level;
    }

    class Node {
        Integer value; //节点值
        Node[] next; // 节点在不同层的下一个节点

        public Node(Integer value, int size) { // 用size表示当前节点在跳表中索引几层
            this.value = value;
            this.next = new Node[size];
        }
    }

    public static void main(String[] args) {
        Skiplist skiplist = new Skiplist();
        skiplist.add(1);
        skiplist.add(2);
        skiplist.add(3);
        // 返回 false
        System.out.println(skiplist.search(0));
        skiplist.add(4);
        // 返回 true
        System.out.println(skiplist.search(1));
        // 返回 false，0 不在跳表中
        System.out.println(skiplist.erase(0));
        // 返回 true
        System.out.println(skiplist.erase(1));
        // 返回 false，1 已被擦除
        System.out.println(skiplist.search(1));
    }
}
