public class lab5C {//堆栈
    public static void main(String[] args) {
        QReader in=new QReader();
        QWriter out=new QWriter();
        int T=in.nextInt();
        for (int i=0;i<T;i++) {
            int n=in.nextInt();
            int top=0;
            String kuohao = in.next();

            char[] stack=new char[n];
            boolean check=true;
            for(int j=0;j< kuohao.length();j++){
                if('{'==kuohao.charAt(j) || '['==kuohao.charAt(j) || '('==kuohao.charAt(j)){
                    stack[top++]=kuohao.charAt(j);
                }
                else if (top==0){
                    out.println("NO");check=false;break;
                }
                else if('}'==kuohao.charAt(j)){
                    if(stack[--top]!='{'){
                        out.println("NO");check=false;break;
                    }
                }
                else if(']'==kuohao.charAt(j)){
                    if(stack[--top]!='['){
                        out.println("NO");check=false;break;
                    }
                }
                else if(')'==kuohao.charAt(j) ){
                    if(stack[--top]!='('){
                        out.println("NO");check=false;break;
                    }
                }

            }
            if(check&&top==0){
            out.println("YES");}
            else if(check&&top!=0) {
                out.println("NO");
            }
            //进栈 stack[top++]=in.next
            //出栈 stack[--top】=“”
        }
        out.close();
    }
}
