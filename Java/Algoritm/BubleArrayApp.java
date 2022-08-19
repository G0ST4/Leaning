class BubleArray {
    private long[] arr;
    private int nElems;

    BubleArray(int max){
        arr = new long[max];
        nElems = 0;
    }

    public void sort(){
        int counter = nElems;
        long tmp;
        while (counter > 0){
            for (int i = 0; i < counter - 1; i++) {
                if (arr[i] > arr[i+1]){
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    display();
                }

            }
            counter--;
        }
    }

    public void insert(long value){
        arr[nElems] = value;
        nElems++;
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println("");
    }
}
public class BubleArrayApp {
    public static void main(String[] arrs){
        BubleArray buble = new BubleArray(10);
        buble.insert(12);
        buble.insert(35);
        buble.insert(27);
        buble.insert(54);
        buble.insert(46);
        buble.insert(87);
        buble.insert(44);
        buble.insert(76);
        buble.insert(78);
        buble.insert(33);
        buble.display();
        buble.sort();
        buble.display();
    }
}