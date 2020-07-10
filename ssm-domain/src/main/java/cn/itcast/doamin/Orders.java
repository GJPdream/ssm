package cn.itcast.doamin;

import cn.itcast.untils.ProductUnitls;

import java.util.Date;
import java.util.List;

/*订单*/
public class Orders  {
private String oid;
private Date otime;
private String otimestr;
private Integer ostratus;
private String ostratusstr;
private Product product;
private List<Traveller> travellers;
private  Member member;

    public String getOid() {
        return oid;
    }

    public void setOstratus(Integer ostratus) {
        this.ostratus = ostratus;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public String getOtimestr() {
        if (null!=otime){
            otimestr=ProductUnitls.dateString(otime,"yyyy-MM-dd hh:MM:ss");
            /*otimestr = ProductUnitls.dateString(otime, "yyyy-MM-dd hh:MM:ss");*/
        }
        return otimestr;
    }

    public void setOtimestr(String otimestr) {
        this.otimestr = otimestr;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public int getOstratus() {
        return ostratus;
    }

    public void setOstratus(int ostratus) {
        this.ostratus = ostratus;
    }

    public String getOstratusstr() {

        if (ostratus!=null)
        {
            if (ostratus==1)
            {
                ostratusstr="支付成功";
            }
            if (ostratus==0)
            {
                ostratusstr="请支付";
            }
        }
        return ostratusstr;
    }

    public void setOstratusstr(String ostratusstr) {
        this.ostratusstr = ostratusstr;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", otime=" + otime +
                ", otimestr='" + otimestr + '\'' +
                ", ostratus=" + ostratus +
                ", ostratusstr='" + ostratusstr + '\'' +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                '}';
    }
}
