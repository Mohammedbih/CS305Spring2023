package ms.sort;

import java.util.Arrays;

public class Sort {


    static void sort(int[] a, int n) {
        int max = a[0];
        for (int i = 0; i < n; i++)
            if (a[i] > max) max = a[i];

        boolean[] temp = new boolean[max + 1];
        for (boolean i : temp)
            i = false;

        for (int i = 0; i < n; i++)
            temp[a[i]] = true;

        int kn = 0;
        for (int i = 0; i < max + 1; i++)
            if (temp[i])
                a[kn++] = i;

    }

    public static void main(String[] args) {
        int[] a = new int[]{9, 10, 40, 30, 4, 7,100,1};
        sort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
