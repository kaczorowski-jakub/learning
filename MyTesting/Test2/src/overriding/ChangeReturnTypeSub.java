package overriding;

public class ChangeReturnTypeSub extends ChangeReturnType {
    
    /*
     * Multiple markers at this line
    - overrides overriding.CantChangeReturnType.test
    - The return type is incompatible with 
     CantChangeReturnType.test()
    @Override
    public Boolean test() {
        return false;
    }
    */
    
    // Integer is a subtype of Number
    @Override
    public Integer test() {
        return 12;
    }
    
}
