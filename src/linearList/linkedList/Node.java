package linearList.linkedList;

/**
 * 每一个Node都是一个节点，每一个节点存储该节点数据（data）和下一个节点地址（next）
 * @param <T>
 */
 class Node <T>{
    T data;             //该节点数据
    Node<T> next;       //写一个节点数据

    /**
     * 用于初始化头节点，不存储该节点数据，存储该节点指针向的下一个节点地址
     * @param next
     */
    Node(Node<T> next){
        this.next = next;
    }

    /**
     * 初始化一般节点
     * @param data
     * @param next
     */
    public Node(T data,Node<T> next){
        this.data = data;
        this.next = next;
    }


    T getData(){
        return data;
    }

    Node<T> getNext(){
        return next;
    }
}

