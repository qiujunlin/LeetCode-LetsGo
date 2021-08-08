package Test;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.TYPE})
@Documented
@Inherited  //可以继承
 @interface ParentAnnotation {

}

public class TestAna {
}
