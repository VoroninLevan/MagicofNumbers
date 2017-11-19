package comvoroninlevan.httpsgithub.magicofnumbers.NormalActivities.Adapter;

/**
 * Created by Levan on 15.11.2017.
 */

public class Nums {

    private int mNum;
    private int mResult;
    private String mName;

    public Nums(int num){
        mNum = num;
    }

    public Nums(int num, int result){
        mNum = num;
        mResult = result;
    }

    public Nums(int num, String name){
        mNum = num;
        mName = name;
    }

    public int getNum() {
        return mNum;
    }

    public int getResult(){
        return mResult;
    }

    public String getName(){
        return mName;
    }
}
