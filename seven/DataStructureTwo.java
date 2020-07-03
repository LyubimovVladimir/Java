package homework.seven;

public class DataStructureTwo {
    public static void main(String[] args) {
        DirectionalListTwo directionalListTwo = new TwoDirectionalList();
        directionalListTwo.add("val1");
        directionalListTwo.add("val2");
        directionalListTwo.add("val3");
        directionalListTwo.add("val4");

        TwoDirectionalList.Node first = (TwoDirectionalList.Node) directionalListTwo.getFirst();
        System.out.println(first.getVal());
        System.out.println(first.getNext().getVal());
        System.out.println(first.getNext().getPrev().getVal());
        System.out.println(first.getNext().getNext().getPrev().getNext().getVal());

        System.out.println(directionalListTwo.size());

        System.out.println("Removed? - " + directionalListTwo.remove("val6"));
        System.out.println("Removed? - " + directionalListTwo.remove("val3"));
        System.out.println("Removed? - " + directionalListTwo.remove("val4"));
    }
}
