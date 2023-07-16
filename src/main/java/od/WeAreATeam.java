package od;

import java.util.Scanner;

/**
 * 类描述
 *
 * @author zcl
 * @Description 总共有 n 个人在机房，每个人有一个标号（1<=标号<=n），他们分成了多个团队，
 * 需要你根据收到的 m 条消息判定指定的两个人是否在一个团队中，具体的：
 * 消息构成为 a b c，整数 a、b 分别代表两个人的标号，整数 c 代表指令
 * c == 0 代表 a 和 b 在一个团队内
 * c == 1 代表需要判定 a 和 b 的关系，如果 a 和 b 是一个团队，输出一行’we are a team’,
 * 如果不是，输出一行’we are not a team’
 * c 为其他值，或当前行 a 或 b 超出 1~n 的范围，输出‘da pian zi’
 * 输入5 7
 * 1 2 0
 * 4 5 0
 * 2 3 0
 * 1 2 1
 * 2 3 1
 * 4 5 1
 * 1 5 1
 * 输出
 * we are a team
 * we are not a team
 * we are a team
 * da pian zi
 * @Date 2023/7/16 11:43
 */
public class WeAreATeam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //int n = scanner.nextInt();
        int n = 5;
        //int m = scanner.nextInt();
        int m = 6;
        FindUnionSet findUnionSet = new FindUnionSet();
        findUnionSet.init(n);
        findUnionSet.join(1, 2);
        findUnionSet.join(4, 5);
        findUnionSet.join(2, 3);
        System.out.println("findUnionSet.isSame(1,2) = " + findUnionSet.isSame(1, 2));
        System.out.println("findUnionSet.isSame(2,3) = " + findUnionSet.isSame(2, 3));
        System.out.println("findUnionSet.isSame(4,5) = " + findUnionSet.isSame(4, 5));
        System.out.println("findUnionSet.isSame(1,5) = " + findUnionSet.isSame(1, 5));
    }


}

class FindUnionSet {
    int N = 1005;                //指定并查集所能包含元素的个数（由题意决定）
    int[] pre = new int[N];                        //存储每个结点的前驱结点
    //int[] rank = new int[N];                        //树的高度

    void init(int n)                    //初始化函数，对录入的 n个结点进行初始化
    {
        for (int i = 0; i < n; i++) {
            pre[i] = i;                //每个结点的上级都是自己
            //          rank[i] = 1;                //每个结点构成的树的高度为 1
        }
    }

    int find(int x)                    //改进查找算法：完成路径压缩，将 x的上级直接变为根结点，那么树的高度就会大大降低
    {
        if (pre[x] == x) return x;        //递归出口：x的上级为 x本身，即 x为根结点
        return pre[x] = find(pre[x]);   //此代码相当于先找到根结点 rootx，然后 pre[x]=rootx
    }

    boolean isSame(int x, int y)            //判断两个结点是否连通
    {
        return find(x) == find(y);    //判断两个结点的根结点（即代表元）是否相同
    }

    boolean join(int x, int y) {
        x = find(x);                        //寻找 x的代表元
        y = find(y);                        //寻找 y的代表元
        if (x == y) return false;            //如果 x和 y的代表元一致，说明他们共属同一集合，则不需要合并，返回 false，表示合并失败；否则，执行下面的逻辑
        pre[y] = x;                        //让 y的上级为 x
        return true;                        //返回 true，表示合并成功
        //优化
         /*if (rank[x] > rank[y]) pre[y] = x;        //如果 x的高度大于 y，则令 y的上级为 x
            else                                //否则
            {
                if (rank[x] == rank[y]) rank[y]++;    //如果 x的高度和 y的高度相同，则令 y的高度加1
                pre[x] = y;                        //让 x的上级为 y
            }*/
    }


}
