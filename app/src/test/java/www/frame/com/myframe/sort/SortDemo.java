package www.frame.com.myframe.sort;


import java.util.ArrayList;
import java.util.List;

/**
 * =============================================
 * 作    者：Junl(袁军亮)
 * 描    述：
 * <p>
 * 创建日期：2017/7/31
 * 文艺青年：人生若只如初见，何事秋风悲画扇。
 * =============================================
 */

public class SortDemo {
    // 排序原始数据
//    private static int[] numbers =
//            {49, 38, 65, 97, 76, 13, 27, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};

    public static void bubbleSort() {
        List<Integer> data = getData();
//        Integer[] numbers = (Integer[]) data.toArray();
        int[] numbers = new int[data.size()];
        for (int i = 0; i < data.size(); i++) {
            numbers[i] = data.get(i);
        }
        String tempStr = "";
        for (Integer number : numbers) {
            tempStr += number + ",";
        }
        System.out.println("未排序的数据：" + tempStr);
        int temp = 0;
        int size = numbers.length;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (numbers[j] > numbers[j + 1])  //交换两数位置
                {
                    temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        tempStr = "";
        for (int num : numbers) {
            tempStr += num + ",";
        }
        System.out.println("排序完成结果：" + tempStr);


    }

    public static void insertSort() {

    }

    public static List<Integer> getData() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add((int) (Math.random() * 100 + 1));
        }
        return list;
    }
}
