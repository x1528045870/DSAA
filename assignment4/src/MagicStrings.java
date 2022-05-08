public class MagicStrings {
    private int[] priority=new int[26];
    private String[] ss;//要多少长度？
    public MagicStrings(String s){
          setSs(s);
        for (int i = 0; i < priority.length; i++) {
            priority[i]=i+1;
        }
    }
    public MagicStrings(int[] priority, String s){
          setPriority(priority);
          setSs(s);
    }
    public MagicStrings(String priority, String s){
     setPriority(priority);setSs(s);
    }
    public void setPriority(int[] priority){
        System.arraycopy(priority, 0, this.priority, 0, priority.length);
    }//后面看看这个咋整
    public void setPriority(String priority){
        String[]priority1=priority.split(" ");
        for (int i=0;i<26;i++){
            this.priority[i]=Integer.parseInt(priority1[i]);
        }
    }
    public void setPriority(char c, int priority){
        int i=c-65;
        if(i>25)i=i-32;
        this.priority[i]=priority;
    }
    public void setSs(String input) {
      input=input.replaceAll("[^a-zA-Z\\s]","");
      ss=input.split(" ");
    }
    public int stringNum(){
        int num=0;
        for (String s : ss) {
            if (s != null) num = num + 1;
        }
        return num;
    }//不太确定输入的参数类型
    public int compareString(String a,String b){
        int check=0;
        for(int i=0;i<a.length()&&i<b.length();i++){
            int a1=a.charAt(i)-65;int b1=b.charAt(i)-65;
            if(a1>25){a1=a1-32;}if(b1>25){b1=b1-32;}
            if(priority[a1]>priority[b1]){//具体的比较到后面再看着改吧
                check=1;break;
            }
            if (priority[a1]<priority[b1]){
                check=-1;break;
            }
        }
        if(check==0&&a.length()>b.length()){
            check=1;
        }
        if(check==0&&a.length()<b.length()){
            check=-1;
        }
        return check;
    }
    public void sortSs(){//选择排序
        for(int i=0;i<ss.length-1;i++){
            int y=i;
            for(int j=i+1;j<ss.length;j++){
                if(compareString(ss[j],ss[y])==1){
                    y=j;
                }
            }
            if(y!=i){
                String t=ss[y];ss[y]=ss[i];ss[i]=t;
            }
        }
    }
    public String getStrings(){
        StringBuilder result= new StringBuilder();
        for (String s : ss) {
            result.append(s).append(" ");
        }
        result = new StringBuilder(result.toString().trim());
        return result.toString();
    }
}

