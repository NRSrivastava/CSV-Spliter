import java.io.*;
class CSV_Splitter
{
    public static void main(String [] args) throws Exception
    {
        String ad=args[0];
        BufferedReader in =  new BufferedReader(new FileReader(ad));
        String st;
        String x="";
        int count=0;
        String ou;
        ou=ad.substring(0,ad.lastIndexOf("\\")+1)+"\\Contacts";
        new File(ou).mkdirs();
        while((st = in.readLine()) != null){
            if(st.equals("END:VCARD"))
            {
                x+="\r\n"+st;
                count++;
                PrintStream ff=new PrintStream(new File((ou+"\\"+String.valueOf(count)+".vcf")));
                System.setOut(ff);
                System.out.print(x);
                x="";
                st="";
                ff.close();
                System.setOut(System.out);
            }
            x+=(x.equals("")?"":"\r\n")+st;
        }
        in.close();
	System.out.println("Process Completed");
    }
}