public class MainClass {
    private static int checkArray(String[][] ar) throws MyArraySizeException, MyArrayDataException {
        int sumOfAr = 0;
        if (ar.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < ar.length; i++) {
            if (ar[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < ar[i].length; j++) {
                try {
                    sumOfAr += Integer.parseInt(ar[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sumOfAr;
    }

    private static void showAr(String[][] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.println();
            for (int j = 0; j < ar.length; j++) {
                System.out.print(ar[i][j] + " ");
            }
        }
    }

    public static void main(String[] args) {
        String[][] ar = new String[4][4];
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {
                ar[i][j] = String.valueOf(0 + (int) (Math.random() * 10));
            }
        }
        showAr(ar);
        System.out.println();
        try {
            try {
                System.out.println(checkArray(ar));
            } catch (MyArraySizeException e) {
                System.out.println("The array size is not equal to 4!");
            }
        } catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива!");
            System.out.println("Ошибка в ячейке: " + e.i + "x" + e.j);
        }
    }
}