public class Obj {

    private int id;

    private long index;

    private String xxxx;

    private String ssss;

    private String xx;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getXxxx() {
        return xxxx;
    }

    public void setXxxx(String xxxx) {
        this.xxxx = xxxx;
    }

    public String getSsss() {
        return ssss;
    }

    public void setSsss(String ssss) {
        this.ssss = ssss;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public Obj(int id, long index, String xxxx, String ssss, String xx) {
        this.id = id;
        this.index = index;
        this.xxxx = xxxx;
        this.ssss = ssss;
        this.xx = xx;
    }
}
