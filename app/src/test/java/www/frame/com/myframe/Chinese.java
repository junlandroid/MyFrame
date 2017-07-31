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

public class Chinese extends Person {
    Chinese() {
        super();
        speak("子类调用父类的无参构造方法");
    }

    Chinese(String s) {
        super(s);
        speak("子类调用父类一个参数的构造方法");
    }

    Chinese(String s, int age) {
        this(s);//调用具有相同形参的构造方法
        speak("子类调用具有相同形参的构造方法" + age);
    }

}
