package www.frame.com.myframe;

import org.junit.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import www.frame.com.myframe.sort.SortDemo;

import static org.junit.Assert.*;

/**
 * =============================================
 * 作    者：Junl(袁军亮)
 * 描    述：
 * <p>
 * 创建日期：2017/7/28
 * 文艺青年：人生若只如初见，何事秋风悲画扇。
 * =============================================
 */
public class TestTest {
    @Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void sub() throws Exception {
//        City city = new City();
//        city.value();
//        Chinese chinese = new Chinese();
//        chinese = new Chinese("Cassiel");
//        chinese = new Chinese("Cassiel", 27);

        /**------------------------分割线------------------------*/
        //所有的包装类（Integer、Long、Byte、Double、Float、Short）都是抽象类 Number 的子类。
//        Math
//        Number
//        ArrayList

//        List<Integer> data = SortDemo.getData();
//        System.out.println(data.toString());

        SortDemo.bubbleSort();//冒泡排序

    }

}