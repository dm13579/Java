package reflect;
//
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:Test
 * @Description:TODO
 * @date 2019/12/10
 */
public class ReflectTest {

    public static void main(String[] args) {
        // 反射获取类的所有变量
//        printFields();
        // 反射获取类的所有方法
//        printMethods();
        try {
            // 反射获取私有方法和调用私有方法
//            getPrivateMethod();
            // 反射修改私有变量
//            modifyPrivateField();


            // 修改私有常量（以final修饰的常量）
            // 可不可以改=》通过反射一定可以改常量
            modifyFinalFiled();
            // 调用函数之后返回值
//            Before:FINAL_VALUE=FINAL
//            After:FINAL_VALUE=MODIFIED HAHAHA
//            Actually:FINAL_VALUE=FINAL
            // 从返回值可以看出常量已经改了，返回第二行表明
            // 但常量更改并无意义，有方法调用获取的常量值并没有修改，返回第三行标表示

            // 原因;表示这是由JVM虚拟机优化机制导致
            // JVM在编译生成.class字节码文件时会对代码先进行优化，会把常量放入常量池中，
            // 而且代码会优化引用常量的地方直接为常量的值，在privateClass.getFinalValue 会优化为 return "FINAL".
            // 所以即使通过反射修改常量值，却无效果。
            // 要想有效果，1，可以常量不设初始值，在构造函数中设初始值，这样在JVM编译前是无法优化代码，此时修改常量是有效果的。
            // 2，改成三目表达式也可以有效果private final String FINAL_VALUE = null == null ? "FINAL" : null;
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // 反射获取类的所有变量
    private static void printFields(){
        // 获取类名
        Class mySonClass = SonClass.class;
        System.out.println("类名"+mySonClass.getName());
        System.out.println("===========================================");
        //获取所有public访问权限变量
//        Field[] fields = mySonClass.getFields();

        // 获取所有本类声明的变量（包括父类）
        Field[] fields = mySonClass.getDeclaredFields();

        // 遍历变量并输出变量信息（不问访问权限）
        for (Field field:fields){
            int modifiers = field.getModifiers();
            // 输出访问权限
            System.out.println(Modifier.toString(modifiers) + " ");
            // 输出变量类型及变量名
            System.out.println(field.getType().getName() + " " + field.getName());
            System.out.println();
        }
    }

    // 反射获取类的所有方法
    public static void printMethods() {
        Class mySonClass = SonClass.class;
        System.out.println("类名" + mySonClass.getName());
        System.out.println("===========================================");

        // 获取所有public访问权限的方法（包括父类）
        Method[] methods = mySonClass.getMethods();

        // 获取所有本类声明的方法（不问访问权限）
//        Method[] methods = mySonClass.getDeclaredMethods();

        for (Method method : methods) {
            int modifiers = method.getModifiers();
            // 输出访问权限
            System.out.print(Modifier.toString(modifiers) + " ");
            // 输出方法的访问返回值类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " " + method.getName() + "(");
            // 输出方法的所有参数
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType() + " " + parameter.getName() + ",");
            }
            // 输出方法抛出的异常
            Class[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length == 0) {
                System.out.print(")");
            } else {
                for (Class cls : exceptionTypes) {
                    System.out.print(")throws " + cls.getName());
                }
            }
            System.out.println();
        }
    }

    // 反射获取私有方法和调用私有方法
    public static void getPrivateMethod() throws Exception{
        PrivateClass privateClass = new PrivateClass();
        Class myClass = privateClass.getClass();

        // 获取私有方法
        // 第一个参数为要获取的私有方法的名称
        // 第二个为要获取方法的参数的类型，参数为 Class...，没有参数就是null
        Method privateMethod = myClass.getDeclaredMethod("privateMethod", String.class, int.class);

        if(privateMethod!=null){
            // 获取私有方法的访问权
            // 只是获取访问权，并不是修改实际权限
            privateMethod.setAccessible(true);

            // 使用 invoke 反射调用私有方法
            // privateMethod 是获取到的私有方法
            // privateClass 要操作的对象
            // 后面两个参数传实参
            privateMethod.invoke(privateClass, "lalala", 666);
        }
    }

    // 修改私有变量
    public static void modifyPrivateField() throws Exception{
        PrivateClass privateClass = new PrivateClass();
        Class myClass = privateClass.getClass();

        Field privateField = myClass.getDeclaredField("MSG");

        if (privateField != null) {
            // 获取私有方法的访问权
            // 只是获取访问权，并不是修改实际权限
            privateField.setAccessible(true);

            System.out.println("Before:MSG="+privateClass.getMsg());

            // 调用 set(object , value) 修改变量的值
            // 修改私有变量
            // privateClass 要操作的对象
            // "MODIFIED HAHAHA" 为要修改成的值
            privateField.set(privateClass,"MODIFIED HAHAHA");

            System.out.println("After:MSG="+privateClass.getMsg());
        }
    }

    // 修改私有常量
    private static void modifyFinalFiled() throws Exception {
        PrivateClass privateClass = new PrivateClass();
        Class myClass = privateClass.getClass();

        Field finalField = myClass.getDeclaredField("FINAL_VALUE");

        if (finalField != null) {
            // 获取私有方法的访问权
            // 只是获取访问权，并不是修改实际权限
            finalField.setAccessible(true);

            System.out.println("Before:FINAL_VALUE="+finalField.get(privateClass));

            // 调用 set(object , value) 修改常量的值
            // 修改私有常量
            // privateClass 要操作的对象
            // "MODIFIED HAHAHA" 为要修改成的值
            finalField.set(privateClass,"MODIFIED HAHAHA");

            System.out.println("After:FINAL_VALUE="+finalField.get(privateClass));

            // 使用对象调用类的 getter 方法
            // 获取值并输出
            System.out.println("Actually:FINAL_VALUE="
                    + privateClass.getFinalValue());
        }

    }
}
