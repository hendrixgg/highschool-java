public class TestPrograms {

    public static void main(String[] args) {
        System.out.println(addRecur(1000, 5));
    }

    public static int addRecur(int num1, int num2) {
        if (num1 == 0)
            return num2;
        if (num2 == 0)
            return num1;
        else
            return addRecur(num1 - 1, num2 + 1);
    }

}
