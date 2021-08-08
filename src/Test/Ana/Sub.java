package Test.Ana;
import java.lang.annotation.*;

@SubAnnotation
public class Sub extends  Parent{

    public static void main(String[] args) {
            Annotation[] allAnnos = Sub.class.getAnnotations();
            Annotation[] deAnnos = Sub.class.getDeclaredAnnotations();
            Annotation subAnnotation = Sub.class.getAnnotation(SubAnnotation.class);
            Annotation parentAnnotation = Sub.class.getAnnotation(ParentAnnotation.class);
            printAnnotation("all",allAnnos);
            printAnnotation("declare",deAnnos);
            printAnnotation("sub",subAnnotation);
            printAnnotation("parent",parentAnnotation);
        }

        private static void printAnnotation(String msg,Annotation... annotations){
            System.out.println("=============="+msg+"======================");
            if(annotations == null){
                System.out.println("Annotation is null");
            }
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            System.out.println();
        }

}
