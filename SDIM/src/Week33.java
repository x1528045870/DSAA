public class Week33 { public static void main(String[] args) {
    int fj[]=new int[]{1000,1000,1000};
    int mj[]=new int[]{500,500,500};
    int di[]=new int[]{80,270,250,160,180};
    int fee[][]=new int[3][];
    fee[0]=new int[]{4,5,6,8,10};
    fee[1]=new int[]{6,4,3,5,8};
    fee[2]=new int[]{9,7,4,3,4};
    int feeSet=0;int check=5;//全部的分配点
    while(check>0){
        int i0=1;int j0=0;//用于记录该次分配的点
        int cut=0;//最大差值，慢慢变大
        for(int i=1;i<=2;i++){//找行中的最大差值
            int min=10;int minSec=10; int j1=0;//很大的min用来慢慢变小
            for(int j=0;j<5;j++){
                if (fee[i][j]<min&&di[j]!=0&&mj[i]!=0){//找该行最小值
                    min=fee[i][j]; j1=j;//记录该行最小值位置
                }
            }
            for (int j=0;j<5;j++) {
                if(j1!=j&&fee[i][j]<=minSec){//找该行第二小值
                    minSec=fee[i][j];
                }
            }
                if(cut<minSec-min){//如果差值比最大差值大，替代之
                    cut=minSec-min;
                    i0=i;j0=j1;//记录此时最大差值行的最小值位置
                }

        }
        for(int j=0;j<=4;j++){//下面是列的最大差值判断，同理
            int min=10;int minSec=10;int i1=0;
            for(int i=1;i<3;i++){
                if (fee[i][j]<min&&di[j]!=0&&mj[i]!=0){
                    min=fee[i][j]; i1=i;
                }
            }
            for (int i=1;i<3;i++){
                if(i1!=i&&fee[i][j]<minSec&&di[j]!=0&&mj[i]!=0){
                    minSec=fee[i][j];
                }
            }
            if(cut<minSec-min){//行出来的最大差值也算一并进入比较了
                cut=minSec-min;
                i0=i1;j0=j;//记录位置
            }
        }
        System.out.println(i0);
        System.out.println(j0);//一次次输出分配的位置，最后一次的具体分配个数可以计算得到
        if(mj[i0]>=di[j0]){
            if(mj[i0]==500)feeSet+=1000;
            mj[i0]=mj[i0]-di[j0];
            feeSet=feeSet+fee[i0][j0]*di[j0];
            di[j0]=0;check--;//把需求点分配一处就少一处
            fee[i0][j0]=100;//求出的最小的点变大就可以找比它难一点的点了
        }
        else if(mj[i0]<di[j0]){feeSet=feeSet+fee[i0][j0]*mj[i0];//把一个仓库分配完就行了
            di[j0]=di[j0]-mj[i0];
            mj[i0]=0;
        }
    }
    System.out.println(feeSet);}//分类讨论再比较feeSet就好了，分为123、13、12、23
}
