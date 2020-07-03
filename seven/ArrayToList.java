package homework.seven;

public class ArrayToList {
    public static void main(String[] args) {
        DirectionalListTwo directionalListTwo = new TwoDirectionalList();
        String[] arr = {"Cat", "Dog", "Horse", "Bird"};
        for (int i = 0; i < arr.length; i++) {
            directionalListTwo.add(arr[i]);
        }

        TwoDirectionalList.Node first = (TwoDirectionalList.Node) directionalListTwo.getFirst();

        System.out.println(first.getVal());
        System.out.println(first.getNext().getVal());
        System.out.println(first.getNext().getNext().getVal());
        System.out.println(first.getNext().getNext().getNext().getVal());
        System.out.println(first.getNext().getPrev().getVal());
        System.out.println(first.getNext().getNext().getPrev().getNext().getVal());

        System.out.println(directionalListTwo.size());
    }
}
