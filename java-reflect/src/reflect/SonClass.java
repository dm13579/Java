package reflect;

import java.io.IOException;

/**
 * @author Administrator
 * @version V1.0
 * @ClassName:SonClass
 * @Description:TODO
 * @date 2019/12/10
 */
public class SonClass extends FatherClass{

    private String mSonName;
    protected int mSonAge;
    public String mSonBirthday;

    public void printSonMsg(){
        System.out.println("Son Msg - name : "
                + mSonName + "; age : " + mSonAge);
    }

    private void setSonName(String name){
        mSonName = name;
    }

    private void setSonAge(int age){
        mSonAge = age;
    }

    private int getSonAge() throws IOException,NullPointerException{
        return mSonAge;
    }

    private String getSonName(){
        return mSonName;
    }
}