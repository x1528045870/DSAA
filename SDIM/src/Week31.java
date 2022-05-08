public class Week31 {
    public static void main(String[] args) {
        int fj[]=new int[]{1000,1000,1000};
        int mj[]=new int[]{500,500,500};
        int di[]=new int[]{80,270,250,160,180};
        int fee[][]=new int[3][];
        fee[0]=new int[]{4,5,6,8,10};
        fee[1]=new int[]{6,4,3,5,8};
        fee[2]=new int[]{9,7,4,3,4};
        int feeSet=0;int check=5;
        while(check>0){
        int i0=0;int j0=0;int min=11;
        for(int i=0;i<=2;i++){
            for(int j=0;j<5;j++){
                if(fee[i][j]<=min&& mj[i]!=0&&di[j]!=0){
                    min=fee[i][j];
                    i0=i;j0=j;
                }
            }
        }System.out.println(i0);
            System.out.println(j0);
        if(mj[i0]>=di[j0]){
            if(mj[i0]==500)feeSet+=1000;
            mj[i0]=mj[i0]-di[j0];
            feeSet=feeSet+fee[i0][j0]*di[j0];

            di[j0]=0;check--;min=11;
            fee[i0][j0]=100;
        }
        else if(mj[i0]<di[j0]){feeSet=feeSet+fee[i0][j0]*mj[i0];
            di[j0]=di[j0]-mj[i0];
            mj[i0]=0;
            }
        System.out.println(feeSet);
    }
    System.out.println(feeSet);}

}
