package Lesson1;

public class TestMyArrayList {
    public static void main(String[] args) {
    MyArrayList<String> list = new MyArrayList<>();

        list.add("Москва");
        list.add("Санкт-Петербург");
        list.add("Владивосток");
        System.out.println(list.get(1));
        System.out.println(list.size());
        System.out.println(list);
}
}
