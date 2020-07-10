package cn.itcast.doamin;
/*旅客*/
public class Traveller {
    private String tid;
    private String tname;
    private String tsex;
    private String tphoneNum;
    private int travellerType;

    public int getTravellerType() {
        return travellerType;
    }

    public void setTravellerType(int travellerType) {
        this.travellerType = travellerType;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTphoneNum() {
        return tphoneNum;
    }

    public void setTphoneNum(String tphoneNum) {
        this.tphoneNum = tphoneNum;
    }

    @Override
    public String toString() {
        return "Traveller{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tphoneNum='" + tphoneNum + '\'' +
                ", travellerType=" + travellerType +
                '}';
    }
}
