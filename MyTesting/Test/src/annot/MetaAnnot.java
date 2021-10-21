package annot;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface MetaAnnot {
	
	public final String A1 = "A1";
	public final String A2 = "A2";
	
	Type[] value();
	
}
