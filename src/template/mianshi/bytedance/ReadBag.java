package template.mianshi.bytedance;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public  class  ReadBag {
    /**
     * 随机线段算法
     * @param amount
     * @param min
     * @param num
     */
    private static void testPocket3(BigDecimal amount, BigDecimal min, BigDecimal num) {
        final Random random = new Random();
        final int[] rand = new int[num.intValue()];
        BigDecimal sum1 = BigDecimal.ZERO;
        BigDecimal redpeck;
        int sum = 0;
        for (int i = 0; i < num.intValue(); i++) {
            rand[i] = random.nextInt(100);
            sum += rand[i];
        }
        final BigDecimal bigDecimal = new BigDecimal(sum);
        BigDecimal remain = amount.subtract(min.multiply(num));  // 总数减去最小值乘 人数
        for (int i = 0; i < rand.length; i++) {
            if (i == num.intValue() - 1) {
                redpeck = remain;
            } else {
                //  剩余的钱 乘 概率 ,  得到本次的钱
                redpeck = remain.multiply(new BigDecimal(rand[i]))
                        .divide(bigDecimal, 2, RoundingMode.FLOOR);
            }
            // 剩余的钱 大于  本次抢红包的钱
            if (remain.compareTo(redpeck) > 0) {
                remain = remain.subtract(redpeck).setScale(2, BigDecimal.ROUND_HALF_UP);
            } else {
                remain = BigDecimal.ZERO;
            }
            sum1 = sum1.add(min.add(redpeck).setScale(2, BigDecimal.ROUND_HALF_UP));
            System.out.println("第" + (i + 1) + "个人抢到红包金额为：" + min.add(redpeck));
        }

        System.out.println("红包总额：" + sum1);
    }

    /**
     * 红包金额为M，剩余人数为N
     * 每次抢到的金额 = 随机区间 （0， M / N X 2）
     */

    private static void testPocket2(BigDecimal amount, BigDecimal min, BigDecimal num) {
        BigDecimal remain = amount.subtract(min.multiply(num));
        final Random random = new Random();
        final BigDecimal hundred = new BigDecimal("100");
        final BigDecimal two = new BigDecimal("2");
        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal redpeck;
        for (int i = 0; i < num.intValue(); i++) {
            final int nextInt = random.nextInt(100);

            // 最后一位就分配剩下的
            if(i == num.intValue() -1){
                redpeck = remain;
            }else{
                // 1x/100 * m/n *2 当前抢到的
                redpeck = new BigDecimal(nextInt)
                        .multiply(remain.multiply(two).divide(num.subtract(new BigDecimal(i)),  // 剩余金额 *2  /  剩余人数
                                2,RoundingMode.CEILING))
                        .divide(hundred,2, RoundingMode.FLOOR);
            }


            if(remain.compareTo(redpeck) > 0){
                remain = remain.subtract(redpeck).setScale(2, BigDecimal.ROUND_HALF_UP);
            }else{
                remain = BigDecimal.ZERO;
            }
            // 抢红包的总加上当前的 就是一共抢了多少
            sum = sum.add(min.add(redpeck)).setScale(2, BigDecimal.ROUND_HALF_UP);

            // 最小值 加上当轮算出的值 等于 当前人抢红包的值
            System.out.println("第"+(i+1)+"个人抢到红包金额为："+min.add(redpeck));
        }
        System.out.println("红包总额：" + sum);
    }
    // 测试代码
    public static void main(String[] args) {
        BigDecimal amount = new BigDecimal(100).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal min = new BigDecimal(0.01).setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal num = new BigDecimal(10).setScale(2, BigDecimal.ROUND_HALF_UP);
        testPocket2(amount,min,num);
    }


}
