package sort;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:BubbleSort
 * @Description:TODO
 * @date 2019/12/3
 */
public class Sort {

    public static void main(String[] args) {
//        Integer []array = {3,3,1,5,4};
//        Integer []array = {84,83,88,87,61,50,70,60,80,99};
        Integer []array = {50,10,90,30,70,40,80,60,20};
        // 冒泡排序
//        bubbleSort(array);

        // 选择排序
//        selectionSort(array);

        // 插入排序
//        insertionSort(array);

        //希尔排序
//        shellSort(array);

        // 归并排序
        mergeSort(array,0,array.length-1);

//        // 快速排序
//        quickSort(array);
//
//        // 堆排序
//        heapSort(array);

        for(Integer value : array){
            System.out.println(value);
        }
    }

    // 堆排序
    public static void heapSort(Integer []array){

    }

    // 快速排序
    public static void quickSort(Integer []array){

    }

    // 排序过程
    public static void merge(Integer []array,int low,int mid,int high){
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while(i<=mid&&j<=high){
            if(array[i]<=array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = array[i++];
        }
        while (j <= high) {
            temp[k++] = array[j++];
        }

        for (int k2 = 0; k2 < temp.length; k2++) {
            array[k2 + low] = temp[k2];
        }
    }

    // 归并排序
    public static void mergeSort(Integer []array,int low,int high){
        int mid = low+(high - low)/2; // 防止数过大会超过Intgeer
        if(low < high){
            mergeSort(array,low,mid);
            mergeSort(array,mid+1,high);
            merge(array,low,mid,high);
        }
    }

    // 希尔排序
    public static void shellSort(Integer []array){
        int length = array.length;
        // 增量gap,且逐步缩减增量gap
        // gap为数组所分组数例如：33154就是分为2组{314},{35}分组后会插入排序变为{134}，{35}数组为{13345}分为1组为{13345}排序结束
        // 空间复杂度O(1)时间复杂度最优情况O(n^3/2),最差情况为O(n^2)平均O(n)稳定性：不稳定
        for(int gap = length/2;gap>0;gap/=2){

            // 从第gap个元素进行插入排序
            for(int i=gap;i<length;i++){
                int j = i;
                while(j-gap >= 0 && array[j-gap] > array[j]) {
                    // 交换元素
                    swap(array,j-gap,j);
                    // 向前遍历
                    j -= gap;
                }
            }
        }
    }

    // 插入排序
    public static void insertionSort(Integer []array){
        int length = array.length;
        int pre,cur;
        // 33154 => 33154 => 13354 => 13354 => 13345
        // 空间复杂度O(1)时间复杂度最优情况{13354}不会走while循环为O(n),最差情况为O(n^2)平均O(n^2)稳定性：稳定
        for(int i=1;i<length;i++){
            // 当前节点前一位数组下标
            pre = i-1;
            // 当前节点值
            cur = array[i];
            while(pre >= 0 && array[pre] > cur){
                // 后移元素
                array[pre+1] = array[pre];
                // 向前遍历
                pre--;
            }
            array[pre+1] = cur;
        }

    }

    // 选择排序
    public static void selectionSort(Integer []array){
        int length = array.length;
        int minIndex;
        // 外层i表示要跑的趟数
        // 内层j表示比较大小次数
        // 33154 => 13354 => 13354 =>13354 => 13354 => 13345
        // 空间复杂度O(1)时间复杂度最优情况为O(n^2)最差情况为O(n^2)平均O(n^2)稳定性：不稳定，在此例中33154到13354中，2个3的位置颠倒了
        for(int i=0;i<length-1;i++){
            minIndex = i;
            for(int j=i+1;j<length;j++){
                if(array[j] < array[minIndex]){
                    minIndex = j;
                }
            }
            swap(array,i,minIndex);
        }
    }

    // 冒泡排序
    public static void bubbleSort(Integer []array){
        int length = array.length;
        // 外层i表示要跑的趟数
        // 内层j表示移动次数
        // 33154 => 33145 => 33145 => 31345 => 13345
        // 空间复杂度O(1)时间复杂度最优情况{12345}为O(n)最差情况为O(n^2)平均O(n^2)稳定性：稳定
        for(int i=0;i<length;i++){
            // -i是后面i个是排好的，-1是最后一编不用排
            for(int j=0;j<length-i-1;j++){
                swap(array,j,j+1);
            }
        }
    }

    private static void swap(Integer []array,int i,int j){
        // 二数交换  可优化
        // 1,普通方法
//                if(array[i] > array[j]){
//                    int temp = array[i];
//                    array[i] = array[j];
//                    array[j] = temp;
//                }
        // 2,加减方法,没有临时变量,假设a=2,b=3,接下来b = a + b = 5;a = b - a = 5 - 2 = 3; b = b - a = 5 - 3 = 2;
//                if(array[i] > array[j]){
//                    array[j] =  array[i]+array[j];    // b = a + b = 5;     此时a = 2,b = 5;
//                    array[i] = array[j] - array[i];     // a = b - a = 5 - 2 = 3; 此时a = 3,b = 5;
//                    array[j] = array[j] - array[i];   // b = b - a = 5 - 3 = 2 此时a = 3,b = 2;
        // 3,异或方法，没有临时变量,假设a=2,b=3,二进制也就是a=10,b=11异或后a=a^b=11^10=01,b=a^b=01^11=10,a=a^b=01^10=11
        if(array[i] > array[j]) {
            array[i] = array[i]^array[j];      // a=a^b=11^10=01;   a=01,b=11
            array[j] = array[i]^array[j];    // b=a^b=01^11=10    a=01,b=10
            array[i] = array[i]^array[j];      // a=a^b=01^10=11    a=11,b=10
        }
    }
}
