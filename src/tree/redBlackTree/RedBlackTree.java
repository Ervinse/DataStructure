package tree.redBlackTree;

import linearList.sequenceQueue.SequenceQueue;

import java.util.ArrayList;

public class RedBlackTree <Key extends Comparable<Key>, Value>{

    //根节点
    private Node root;
    //记录树中元素的个数
    private int size;
    //红色链接
    private static final boolean RED = true;
    //黑色链接
    private static final boolean BLACK = false;

    //结点类
    private class Node {
        //存储键
        public Key key;
        //存储值
        private Value value;
        //记录左子结点
        public Node left;
        //记录右子结点
        public Node right;
        //由其父结点指向当前链接的颜色
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }


    /**
     * 向树中添加元素key-value
     * @param key 要添加的元素的key
     * @param value 要添加的元素的value
     */
    public void put(Key key,Value value){
        root = put(root, key, value);
        root.color = RED;
    }


    /**
     * 使用递归方法，向指定的树node中添加key-value,并返回添加元素后新的节点
     * @param node 需要比较的节点
     * @param key 要添加的元素的key
     * @param value 要添加的元素的value
     * @return 完成添加或修改操作之后的新节点
     */
    private Node put(Node node,Key key,Value value){

        /*
            如果是叶子节点,直接插入一个红链的节点
         */

        //判断指定节点是否为空
        if (node == null){
            //节点数量+1
            size++;
            //创建一个红链新节点,并插入数据,将这个新节点返回,挂在到上一层的节点上
            return new Node(key, value, null, null, RED);
        }

        /*
            如果不是叶子节点,选择下一轮递归时进入的节点
         */


        //如果node子树不为空,比较node结点的键和key的大小：
        int compare = key.compareTo(node.key);
        if (compare > 0){
            //如果key大于node结点的键，则继续找node结点的右子树
            node.right = put(node.right,key,value);

        }else if(compare < 0){
            //如果key小于node结点的键，则继续找node结点的左子树
            node.left = put(node.left,key,value);
        }else{
            //如果key等于x结点的键，则替换x结点的值为value即可
            node.value = value;
        }

        /*
            完成插入或修改后,通过左旋,右旋或者颜色反转,使得红黑树继续有序
         */

        //如果当前节点左子节点为黑,右子节点为红,需要左旋
        if (isRed(node.right) && !isRed(node.left)){
            node = rotateLeft(node);
        }

        //如果当前节点的左子节点和左子节点的左子节点都为红,需要右旋
        if (isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }

        //如果当前节点的左子节点和右子节点都为红色时,需要颜色反转
        if (isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }

        return node;
    }


    /**
     * 对指定节点进行左旋
     * @param node 指定节点
     * @return 左旋完成后代替原节点位置的新节点(即原节点的右子节点)
     */
    private Node rotateLeft(Node node){
        //找到当前节点的右子节点
        Node rightChildNode = node.right;
        //将右子节点的左子节点成为当前节点的右子节点
        node.right = rightChildNode.left;
        //让当前节点成为右子节点的左子节点
        rightChildNode.left = node;
        //将右子节点的color属性变为当前节点的color属性
        rightChildNode.color = node.color;
        //将当前节点的color属性变为RED
        node.color = RED;

        //返回右子节点,代替当前节点位置
        return rightChildNode;
    }

    /**
     * 对指定节点进行右旋
     * @param node 指定节点
     * @return 右旋完成后代替原节点位置的新节点(即原节点的左子节点)
     */
    private Node rotateRight(Node node){
        //找到当前节点的左子节点
        Node leftChildNode = node.left;
        //让左子节点的右子节点成为当前节点的左子节点
        node.left = leftChildNode.right;
        //让当前节点成为左子节点的右子节点
        leftChildNode.right = node;
        //让左子节点的color属性变为当前节点的color属性
        leftChildNode.color = node.color;
        //将当前节点的color属性变为RED
        node.color = RED;

        //返回左子节点,代替当前节点位置
        return leftChildNode;

    }


    /**
     * 反转指定节点颜色,即拆分当前节点和左右子节点结合的4-节点
     * @param node
     */
    private void flipColors(Node node){
        //当前节点颜色变红
        node.color = RED;
        //左子节点和右子节点颜色变黑
        node.left.color = BLACK;
        node.right.color = BLACK;
    }


    /**
     * 获取树中元素的个数
     * @return 树中元素的个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断指向当前节点的链接颜色是否为红色
     * @param node 指定节点
     * @return 链接颜色为红则返回true,颜色为黑返回false
     */
    private  boolean isRed(Node node){
        if (node == null){
            return false;
        }
        return node.color == RED;
    }


    /**
     * 查询树中指定key对应的value
     * @param key 要查询值的节点对应的key
     * @return 要查询的值
     */
    public Value get(Key key) {
        return get(root,key);
    }

    /**
     * 从指定的树node中，查找key对应的值
     * @param node 指定节点
     * @param key 指定节点对应的key
     * @return 指定节点对应的key
     */
    public Value get(Node node, Key key) {
        //node节点为null
        if (node==null){
            return null;
        }

        //node节点不为null，比较key和node结点的键的大小
        int cmp = key.compareTo(node.key);
        if (cmp>0){
            //如果key大于node结点的键，则继续找node结点的右子树
            return get(node.right,key);

        }else if(cmp<0){
            //如果key小于node结点的键，则继续找node结点的左子树
            return get(node.left,key);
        }else{
            //如果key等于node结点的键，就找到了键为key的结点，只需要返回node结点的值即可
            return node.value;
        }
    }


    /**
     * 删除树中key对应的value
     * @param key 要删除节点的key
     */
    public void delete(Key key) {
        delete(root, key);
    }

    //删除指定树x中的key对应的value，并返回删除后的新树
    public Node delete(Node node, Key key) {
        //node节点为null
        if (node==null){
            return null;
        }

        //node节点不为null,比较key和node结点的键的大小
        int cmp = key.compareTo(node.key);
        //如果key大于node结点的键，则继续找node结点的右子树
        if (cmp>0){
            node.right = delete(node.right,key);
            //如果key小于node结点的键，则继续找node结点的左子树
        }else if(cmp<0){
            node.left = delete(node.left,key);
            //如果key等于node结点的键，完成真正的删除结点动作，要删除的结点就是node；
        }else{

            //让元素个数-1
            size--;
            //如果右子数为空，返回左子树
            if (node.right==null){
                return node.left;
            }
            //如果左子树为空,返回右子树
            if (node.left==null){
                return node.right;
            }

            /*
                获取node右子树中的最小值
             */
            //将node的右子节点预设为最小节点
            Node minNode = node.right;
            //循环查询右子节点中的左子节点,最下层的左子节点是子树的最小值
            while(minNode.left!=null){
                minNode = minNode.left;
            }

            /*
                删除右子树中最小的结点
             */
            //提取要删除的节点的右子节点
            Node minParent = node.right;
            while(minParent.left!=null){
                //循环查询直到minParent节点为最小节点的父节点
                if (minParent.left.left==null){
                    //如果最小子节点有右子节点
                    if (minParent.left.right != null){
                        //将最小节点的右子节点提到最小节点上,完成删除
                        minParent.left = minParent.left.right;
                        //如果最小节点没有右子节点,直接删除最小节点
                    }else {
                        minParent.left = null;
                    }
                }else{
                    //变换n结点即可
                    minParent = minParent.left;
                }
            }

            //让要删除的结点(node)的左子树成为minNode的左子树
            minNode.left = node.left;
            //让要删除的结点(node)的右子树成为minNode的右子树
            minNode.right = node.right;
            //让要删除的结点(node)的父结点指向minNode
            node = minNode;
        }
        return node;
    }

    /**
     * 查找整个树中最小的键
     * @return 最小键的key
     */
    public Key min(){
        if (root == null){
            System.out.println("树中没有元素,无法查找最小值");
            return null;
        }else {
            return min(root).key;
        }
    }


    /**
     * 查找指定节点子树中最小的键
     * @param node 指定的节点
     * @return 指定节点子树中最小键的节点
     */
    private Node min(Node node){

        //需要判断node还有没有左子结点，如果有，则继续向左找，如果没有，则node就是最小键所在的结点
        if (node.left!=null){
            return min(node.left);
        }else{
            return node;
        }
    }

    /**
     * 查找整个树中最大的键
     * @return 最大的key
     */
    public Key max(){
        if (root == null){
            System.out.println("树中没有元素,无法查找最大值");
            return null;
        }else {
            return max(root).key;
        }
    }

    /**
     * 查找指定节点子树中最大的键
     * @param node 指定的节点
     * @return 指定节点子树中最大键的节点
     */
    public Node max(Node node){
        //判断node还有没有右子结点，如果有，则继续向右查找，如果没有，则node就是最大键所在的结点
        if (node.right!=null){
            return max(node.right);
        }else{
            return node;
        }
    }

    /**
     * 对整个树进行前序遍历,将整个树所有的键添加到ArrayList中
     * @return 装有整个树所有key的集合
     */
    public ArrayList<Key> preErgodic(){
        ArrayList<Key> keys = new ArrayList<>();
        //对根节点遍历
        preErgodic(root,keys);
        return keys;
    }

    /**
     * 对指定节点进行前序遍历,将子树所有的键添加到ArrayList中
     * @param node 指定的节点
     * @param keys 遍历到本节点时,装有目前所有key的集合
     */
    private void preErgodic(Node node, ArrayList<Key> keys){
        //当本层节点为null,说明上一层节点为叶子节点,结束本侧遍历
        if (node == null){
            return;
        }

        //将该节点中的key添加到集合中
        keys.add(node.key);

        //对该节点的左侧子树进行遍历
        preErgodic(node.left, keys);
        //对该节点的右侧子树进行遍历
        preErgodic(node.right, keys);
    }

    /**
     * 对整个树进行中序遍历,将整个树所有的键添加到ArrayList中
     * @return 装有整个树所有key的集合
     */
    public ArrayList<Key> midErgodic(){
        ArrayList<Key> keys = new ArrayList<>();
        //对根节点遍历
        midErgodic(root,keys);
        return keys;
    }

    /**
     * 对指定节点进行中序遍历,将子树所有的键添加到ArrayList中
     * @param node 指定的节点
     * @param keys 遍历到本节点时,装有目前所有key的集合
     */
    private void midErgodic(Node node, ArrayList<Key> keys){
        //当本层节点为null,说明上一层节点为叶子节点,结束本侧遍历
        if (node == null){
            return;
        }
        //对该节点的左侧子树进行遍历
        midErgodic(node.left, keys);

        //将该节点中的key添加到集合中
        keys.add(node.key);

        //对该节点的右侧子树进行遍历
        midErgodic(node.right, keys);
    }


    /**
     * 对整个树进行后序遍历,将整个树所有的键添加到ArrayList中
     * @return 装有整个树所有key的集合
     */
    public ArrayList<Key> afterErgodic(){
        ArrayList<Key> keys = new ArrayList<>();
        //对根节点遍历
        afterErgodic(root,keys);
        return keys;
    }

    /**
     * 对指定节点进行后序遍历,将子树所有的键添加到ArrayList中
     * @param node 指定的节点
     * @param keys 遍历到本节点时,装有目前所有key的集合
     */
    private void afterErgodic(Node node, ArrayList<Key> keys){
        //当本层节点为null,说明上一层节点为叶子节点,结束本侧遍历
        if (node == null){
            return;
        }
        //对该节点的左侧子树进行遍历
        afterErgodic(node.left, keys);

        //对该节点的右侧子树进行遍历
        afterErgodic(node.right, keys);

        //将该节点中的key添加到集合中
        keys.add(node.key);
    }


    /**
     * 对整个树进行层序遍历,将整个树所有的键添加到队列中
     * @return 包含树中所有key的队列
     */
    public SequenceQueue<Key> layerErgodic(){

        //定义两个队列,分别存储树中的键和节点
        SequenceQueue<Key> keyQueue = new SequenceQueue<>();
        SequenceQueue<Node> nodeQueue = new SequenceQueue<>();

        //向队列存入根节点
        nodeQueue.enQueue(root);

        while (!nodeQueue.isEmpty()){

            //从节点队列中弹出一个节点,将该节点对应的key放入key队列中
            Node node = nodeQueue.deQueue();
            keyQueue.enQueue(node.key);

            //判断当前节点有没有左子节点,如果有,则放入节点队列中
            if (node.left != null){
                nodeQueue.enQueue(node.left);
            }
            //判断当前节点有没有右子节点,如果有,则放入节点队列中
            if (node.right != null){
                nodeQueue.enQueue(node.right);
            }
        }
        return keyQueue;
    }


    /**
     * 获取整棵树的最大深度
     * @return 整棵树的最大深度
     */
    public int maxDepth(){
        return maxDepth(root);
    }


    /**
     * 获取节点node子树的最大深度
     * @param node 指定节点
     * @return 节点node子树的最大深度
     */
    private int maxDepth(Node node){
        if (node == null){
            return 0;
        }

        //node节点子树的最大深度
        int max;
        //node节点左子树的最大深度
        int maxLeft = 0;
        //node节点右子树的最大深度
        int maxRight = 0;

        //计算node节点左子树的最大深度
        if (node.left != null){
            maxLeft = maxDepth(node.left);
        }
        //计算node节点右子树的最大深度
        if(node.right != null){
            maxRight = maxDepth(node.right);
        }

        //比较node节点左右子树的最大深度,取较大值+1
        max = maxLeft > maxRight ? maxLeft+1 : maxRight+1;

        return max;
    }
}
