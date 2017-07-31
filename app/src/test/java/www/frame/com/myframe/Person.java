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

public class Person {
    public static void speak(String s) {
        System.out.println(s);
    }

    Person() {
        speak("父类的无参构造方法");
    }

    Person(String name) {
        speak("父类一个参数的构造方法,参数为String-->"+name);
    }
}
