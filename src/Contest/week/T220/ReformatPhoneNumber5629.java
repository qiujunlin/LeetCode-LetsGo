package Contest.week.T220;

/**
 * @Classname ReformatPhoneNumber5629
 * @Description:
 * @Date 2020/12/20 21:12
 * @Created by qiujunlin
 */
public class ReformatPhoneNumber5629 {
    public String reformatNumber(String number) {
        number = number.replaceAll(" ","");
        number =number.replaceAll("-","");
        StringBuilder  builder = new StringBuilder();
        int len=number.length()-1;
        int index=0;
        while(index<len-3){
            builder.append(number.substring(index,index+3));
            builder.append("-");
            index+=3;
        }
        System.out.print(index);
        if(len-index==3) {
            builder.append(number.substring(index,index+2));
            builder.append("-");
            index+=2;
            builder.append(number.substring(index,index+2));
        }else if(len-index==2) {builder.append(number.substring(index,index+3));}
        else if(len-index==1){ builder.append(number.substring(index,index+2));}
        return builder.toString();
    }

}
