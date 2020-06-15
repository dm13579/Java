package reflect;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:privateClass
 * @Description:TODO
 * @date 2019/12/10
 */
public class PrivateClass {

    private String MSG = "Original";

    private final String FINAL_VALUE = "FINAL";

    private void privateMethod(String head , int tail){
        System.out.print(head + tail);
    }

    public String getMsg(){
        return MSG;
    }

    public String getFinalValue(){
        return FINAL_VALUE;
    }

}
