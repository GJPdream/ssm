package cn.itcast.doamin;
/*联系人*/
public class Member {
    private String mid;
    private String mname;
    private String mphoneNum;
    private String memail;
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphoneNum() {
        return mphoneNum;
    }

    public void setMphoneNum(String mphoneNum) {
        this.mphoneNum = mphoneNum;
    }

    public String getMemail() {
        return memail;
    }

    public void setMemail(String memail) {
        this.memail = memail;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid='" + mid + '\'' +
                ", mname='" + mname + '\'' +
                ", mphoneNum='" + mphoneNum + '\'' +
                ", memail='" + memail + '\'' +
                '}';
    }
}
