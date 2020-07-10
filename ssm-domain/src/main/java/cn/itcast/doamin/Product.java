package cn.itcast.doamin;
import cn.itcast.untils.ProductUnitls;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
public class Product {
    private int pid;
    private String pname;
    private  String psort;
    private String pdateStr;
    /*这里是一个类型转换的问题,不过这里的东西有问题，我们不能全局，如果有别的地方还要使用它，那么我们还是会出问题*/
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private  Date pdate;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPsort() {
        return psort;
    }

    public void setPsort(String psort) {
        this.psort = psort;
    }

    public String getPdateStr() {
        if (null!=pdate){
         pdateStr=ProductUnitls.dateString(pdate,"yyyy-MM-dd hh:MM:ss");
        }
        return pdateStr;
    }

    public void setPdateStr(String pdateStr) {
        this.pdateStr = pdateStr;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", psort='" + psort + '\'' +
                ", pdateStr='" + pdateStr + '\'' +
                ", pdate=" + pdate +
                '}';
    }
}
