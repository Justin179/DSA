package datastructures.lc240212;

public class Test {
    public static void main(String[] args) {

        String path = "/home/";
        String[] strArr = path.split("/");

        path = "/../";
        strArr = path.split("/");

        path = "/home//foo/";
        strArr = path.split("/");

        System.out.println(strArr);

    }
}
