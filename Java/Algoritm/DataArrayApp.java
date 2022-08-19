
/* Класс person */
class Person{
    private String firstName;
    private String lastName;
    private int age;


    /* Конструктор */
    public Person(String last, String first, int a) {
        lastName = last;
        firstName = first;
        age = a;
    }
    /* Вывод полей класса */
    public void displayPerson() {
        System.out.print(" Last name: " + lastName);
        System.out.print(", First name: " + firstName);
        System.out.println(", Age: " + age);
    }
    /* Метод get для поля lastName */
    public String getLast(){
        return lastName;
    }
}

class DataArray{
    private Person[] arr;
    private int nElems;

    public DataArray(int size){
        arr = new Person[size];
        nElems = 0;
    }

    public Person find(String searchName){
        int j;
        for (j = 0; j < nElems; j++) {
            if(arr[j].getLast().equals(searchName)){
                break;
            }            
        }
        if (j == nElems) {
            return null;
        } else {
            return arr[j];
        }
    }

    public void insert(String last, String first, int age) {
        arr[nElems] = new Person(last, first, age);
        nElems++;
    }

    public Boolean delete(String searchName){
        int j;
        for ( j = 0; j < nElems; j++) {
            if (arr[j].getLast().equals(searchName)) {
                break;
            }
        }
        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems; k++) {
                arr[k] = arr[k + 1];
            }
            nElems--;
            return true;
        }
    }

    public void display(){
        for (int i = 0; i < nElems; i++) {
            arr[i].displayPerson();
        }
    }


}

public class DataArrayApp {
    public static void main(String[] args) {
        int maxSize = 100; // Размер массива
        DataArray arr; // Ссылка на массив
        arr = new DataArray(maxSize); // Создание массива
        // Вставка 10 элементов
        arr.insert("Evans", "Patty", 24);
        arr.insert("Smith", "Lorraine", 37);
        arr.insert("Yee", "Tom", 43);
        arr.insert("Adams", "Henry", 63);
        arr.insert("Hashimoto", "Sato", 21);
        arr.insert("Stimson", "Henry", 29);
        arr.insert("Velasquez", "Jose", 72);
        arr.insert("Lamarque", "Henry", 54);
        arr.insert("Vang", "Minh", 22);
        arr.insert("Creswell", "Lucinda", 18);
        arr.display(); // Вывод содержимого

        String searchKey = "Stimson"; // Поиск элемента
        Person found;
        found=arr.find(searchKey);
        if (found != null)
        {
            System.out.print("Found ");
            found.displayPerson();
        }
        else
            System.out.println("Can't find " + searchKey);
        System.out.println("Deleting Smith, Yee, and Creswell");
        arr.delete("Smith"); // Удаление трех элементов
        arr.delete("Yee");
        arr.delete("Creswell");
        arr.display(); // Повторный вывод содержимого
    }
}
