public class FencingHall {
    public static void main(String[] args) {
        //快读快写
        QReader in = new QReader();
        QWriter out = new QWriter();
        int k = in.nextInt();
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++){
            nums[i] = in.nextInt();
        }
        int i = 0;
        int j = 0;
        int length = 0;
        MaxQueue max = new MaxQueue(n);
        MinQueue min = new MinQueue(n);
        max.push(j, nums[j]);
        min.push(j, nums[j]);
        while (j < n-1){
            if(max.getFront() - min.getFront() <= k){
                if (j-i+1 > length){
                    length = j-i+1;
                }
                j++;
                max.push(j, nums[j]);
                min.push(j, nums[j]);
            }else {
                i++;
                max.pop(i);
                min.pop(i);
            }
        }
        if(max.getFront() - min.getFront() <= k) {
            if (j - i + 1 > length) {
                length = j - i + 1;
            }
        }
        out.println(length);
        out.close();
    }

    static class MaxQueue{
        Node[] n;
        int front;
        int rear;
        public MaxQueue(int k){
            n = new Node[k];
            front = 0;
            rear = 0;
        }
        void push(int j, int value){
            Node node = new Node(j, value);
            while (!isNull() && value > n[rear - 1].value){
                rear--;
            }
            n[rear] = node;
            rear ++;
        }


        void pop(int i){
            if (n[front].index < i){
                front++;
            }
        }

        boolean isNull(){
            return front == rear;
        }

        int getFront(){
            return n[front].value;
        }
    }

    static class MinQueue{
        Node[] n;
        int front;
        int rear;
        public MinQueue(int k){
            n = new Node[k];
            front = 0;
            rear = 0;
        }
        void push(int j, int value){
            Node node = new Node(j, value);
            while (!isNull() && value < n[rear - 1].value){
                rear--;
            }
            n[rear] = node;
            rear ++;
        }


        void pop(int i){
            if (n[front].index < i){
                front++;
            }
        }

        boolean isNull(){
            return front == rear;
        }

        int getFront(){
            return n[front].value;
        }
    }

    static class Node{
        int index;
        int value;
        public Node(int i, int v){
            index = i;
            value = v;
        }
    }
}
