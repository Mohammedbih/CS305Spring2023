package ms.QuickSort;

public class QuickSort {

    int[] a;

    public QuickSort(int[] a){
        this.a=a;
    }

    public void quicksort(int low, int high){

        int pivotpoint=low;

        if(high > low){
            partition(low,high,pivotpoint);
            quicksort(low,pivotpoint-1);
            quicksort(pivotpoint+1,high);
        }
    }

    public void partition(int low, int high, int pivotpoint){

        int i,j = low;
        int pivotitem =a[low];

        for (i = low+1 ; i <= high; i++){
           if(a[i]<pivotitem) {
               j++;
               int x = a[i];
               a[i] = a[j];
               a[j] = x;
           }
        }
        pivotpoint=j;
        int y = a[low];
        a[low] = a[pivotpoint];
        a[pivotpoint] = y;
    }
}
