import java.util.*;
import java.io.File;
import java.io.FileWriter;
public class Goodies1 {
    public static void main(String [] args)throws Exception
    {
        Scanner sc = new Scanner(System.in);
            File myObj = new File("sample_input3.txt");
            Scanner myReader = new Scanner(myObj);
            String [] ss =new String[14];
            String data="";
            int index=0;
            while (myReader.hasNextLine()) {
                 ss[index]=  myReader.nextLine();
                //data = myReader.nextLine();
             // System.out.println(data);
             index++;
            }
            myReader.close();
        Map<Integer,String> hh = new HashMap<Integer,String>();
        ArrayList<Integer> aa = new ArrayList<Integer>();
           for(int i=4;i<14;i++){
               String [] str = ss[i].split(": ");
               String a = str[0];//string a is goodies
               int b = Integer.parseInt(str[1]);// integer b is price of that goodies
               hh.put(b,a);
               aa.add(b);
           }
        //System.out.print(hh);
          Collections.sort(aa);
        int m = Integer.parseInt(ss[0].substring(21));// m is the number of employee
        int result=999999;
       int flag = -1;
       int temp=0;
          for(int i=0;i<aa.size()-m;i++){
               temp = aa.get(i+m-1)- aa.get(i);// temp is the difference between price of goodies in window of employee size
               if(result>temp){
                   result = temp;// result is the minimum difference between high price good and low price good
                   flag=i;// flag is the index of low price goodies for the employee
               }
          }
         String  result1 ="The goodies selected for distribution are:\n\n";
         // running for loop from (low price goodies index) to (low price goodies index) + (number of employee)
          for(int i=flag;i<flag+m;i++){
                 result1+=hh.get(aa.get(i))+": "+aa.get(i)+"\n";// creating result according to format
          }
          result1+="\n \nAnd the difference between the chosen goodie with highest price and the lowest price is "+result;
          System.out.println(result1);

          FileWriter myWriter = new FileWriter("sample_output3.txt");// creating output for the sample input
          myWriter.write(result1);
          myWriter.close();
    }
}

