/* Отсортированный массив */
class OrdArray {
    private long[] arr;
    private int nElems;

    public OrdArray(int size){
        arr = new long[size];
        nElems = 0;
    }
    
    public int size(){
        return nElems;
    }
    /* Автоматическое хаполнение массива */
    public void generate(int value) {
        for (int j = 0; j < value; j++) {
            long item = (long)(Math.random() * 100);
            while (find(item) != nElems) {
                item = (long)(Math.random() * 100);
            } 
            insert(item);
        }
    }
    /* Двоичный поиск по массиву */
    public int find(long searchKey){
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;
        while(true){
            curIn = (lowerBound + upperBound) / 2;
            if (arr[curIn] == searchKey) {
                return curIn; //Element find
            } else if (lowerBound > upperBound) {
                return nElems; //Element not found
            } else {
                if (arr[curIn] < searchKey) {
                    lowerBound = curIn + 1;
                } else {
                    upperBound = curIn - 1;
                }
            }
        }
    }
    /* Вставка элемента в массив */
    public void insert(long value) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (arr[j] > value) {
                break;
            }            
        }
        for (int i = nElems; i > j; i--) {
            arr[i] = arr[i - 1];
        }
        arr[j] = value;
        nElems++;
    }
    /* Удаление элемента из массива */
    public boolean delete(long value){
        int j = find(value);
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems - 1; k++) {
                arr[k] = arr[k+1];
            }
            nElems--;
            return true;
        }
    }
    /* Вывод массива на экран */
    public void display() {
        for (int i = 0; i < nElems; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
public class ArrayApp {

    public static void main(String[] args) {
        int maxSize = 20;
        OrdArray arr = new OrdArray(maxSize);

        arr.generate(20);

        arr.display();
    }
    
}
