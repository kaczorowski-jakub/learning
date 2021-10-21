package misc;

public class Comp {
    
    String val;
    
    public String getVal() {
        return val;
    }
    
    public void setVal(String val) {
        this.val = val;
    }
    
    @Override
    public int hashCode() {
        return val.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        } else if (!(obj instanceof Comp)) {
            return false;
        } else {
            Comp comp = (Comp) obj;
            return comp.getVal().equals(this.val);
        }
    }
    
}
