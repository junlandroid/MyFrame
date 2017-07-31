package www.frame.com.myframe;

/**
 * =============================================
 * 作    者：Junl(袁军亮)
 * 描    述：
 * <p>
 * 创建日期：2017/7/28
 * 文艺青年：人生若只如初见，何事秋风悲画扇。
 * =============================================
 */

public class City extends Country{
    String name;
    void value() {
        name = "SH";
        super.value();
        System.out.println("City is "+name);
        System.out.println("Country is " + super.name);
    }
}
