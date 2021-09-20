package Test.Dubbo;

/**
 * @description: weq
 * @author: qiujunlin
 * @create: 2021-09-20 21:05
 */
public class Main {
    public static void main(String[] args) {
        Parent parent = new Parent() {
            @Override
            public void say() {
                System.out.println("dsad");
            }
        };
        parent.say();

    }
}
