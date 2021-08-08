package Test.Ana;
import java.lang.annotation.*;
@Target(value={ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SubAnnotation {
}
