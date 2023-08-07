package qf.task.week04.day01.map_set;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week04.day01
 * @company lpc
 * date 2023/8/7 11:16
 */
public class TestTree{
    Node root = new Node(10);
    public void add(int v){
        this.root.addChild(root);
    }
    public void middleList(){
        this.root.middleList();
    }
    static class Node{
        private int value;
        private Node left;
        private Node right;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node(int value) {
            this.value = value;
        }
        public void addChild(Node node){
            if(value < this.value){
                if(this.left == null) {
                    this.left = new Node(value);
                }
                else {
                    addChild(node);
                }
            }else if(value > this.value){
                if(this.right == null) {
                    this.right = new Node(value);
                }
                else {
                    addChild(node);
                }
            }else {
                System.out.println("重复添加");
            }
        }
        private void middleList(){
            if(this.left == null) this.left.middleList();

            System.out.print(this.value + "\t");

            if(this.right == null) this.left.middleList();
        }

    }

    public static void main(String[] args) {
        TestTree t = new TestTree();
        t.add(11);
        t.add(22);
        t.add(233);
        t.add(213);
        t.middleList();
    }
}
