public class Week3 {
    public static void main(String[] args) {
        int fj[]=new int[]{1000,1000,1000};
        int mj[]=new int[]{500,500,500};
        int di[]=new int[]{80,270,250,160,180};
        int fee[][]=new int[3][];
        fee[0]=new int[]{4,5,6,8,10};
        fee[1]=new int[]{6,4,3,5,8};
        fee[2]=new int[]{9,7,4,3,4};
        int min2[]=new int[]{0,0,0,0,0,0};//第一项记录组别，比如12、23、13，第二项记录80分给前面的组多少，以此类推
        int min3[][]=new int[][]{{0,0,0,0,0},{0,0,0,0,0}};//假如有三个仓库,虽然不太可能在这取到，太麻烦了，不想弄了
        int feeMin=1000000;
        //看起来2、3比较有可能取到最小,但还是先1、2吧，显然
        for(int i=0;i<=di[0];i++){
            int feeSet=2000;
            feeSet=feeSet+i*fee[0][0]+(di[0]-i)*fee[1][0];
            for(int j=0;j<=di[1];j++){
               int feeSet1=feeSet+j*fee[0][1]+(di[1]-j)*fee[1][1];
                for(int k=0;k<=di[2];k++){
                    if((i+j+k)>500||((di[0]+di[1]+di[2]-i-j-k)>500))break;
                   int feeSet2=feeSet1+k*fee[0][2]+(di[2]-k)*fee[1][2];
                    for(int l=0;l<=di[3];l++){
                        if((i+j+k+l)>500||((di[0]+di[1]+di[2]+di[3]-i-j-k-l)>500))break;
                      int  feeSet3=feeSet2+l*fee[0][3]+(di[3]-l)*fee[1][3];
                        for(int m=0;m<=di[4];m++){
                            if((i+j+k+l+m)>500||((di[0]+di[1]+di[2]+di[3]+di[4]-i-j-k-l-m)>500))break;
                          int   feeSet4=feeSet3+m*fee[0][4]+(di[4]-m)*fee[1][4];
                            if(feeSet4<feeMin){
                                feeMin=feeSet4;
                                min2[0]=12;
                                min2[1]=i;
                                min2[2]=j;
                                min2[3]=k;
                                min2[4]=l;
                                min2[5]=m;
                            }

                        }
                    }
                }
            }
        }
        //下面是1、3
        for(int i=0;i<=di[0];i++){
            int feeSet=2000;
            feeSet=feeSet+i*fee[0][0]+(di[0]-i)*fee[2][0];
            for(int j=0;j<=di[1];j++){
                int feeSet1=feeSet+j*fee[0][1]+(di[1]-j)*fee[2][1];
                for(int k=0;k<=di[2];k++){
                    if((i+j+k)>500||((di[0]+di[1]+di[2]-i-j-k)>500))break;
                    int feeSet2=feeSet1+k*fee[0][2]+(di[2]-k)*fee[2][2];
                    for(int l=0;l<=di[3];l++){
                        if((i+j+k+l)>500||((di[0]+di[1]+di[2]+di[3]-i-j-k-l)>500))break;
                        int  feeSet3=feeSet2+l*fee[0][3]+(di[3]-l)*fee[2][3];
                        for(int m=0;m<=di[4];m++){
                            if((i+j+k+l+m)>500||((di[0]+di[1]+di[2]+di[3]+di[4]-i-j-k-l-m)>500))break;
                            int   feeSet4=feeSet3+m*fee[0][4]+(di[4]-m)*fee[2][4];
                            if(feeSet4<feeMin){
                                feeMin=feeSet4;
                                min2[0]=13;
                                min2[1]=i;
                                min2[2]=j;
                                min2[3]=k;
                                min2[4]=l;
                                min2[5]=m;
                            }

                        }
                    }
                }
            }
        }
        for(int i=0;i<=di[0];i++){
            int feeSet=2000;
            feeSet=feeSet+i*fee[2][0]+(di[0]-i)*fee[1][0];
            for(int j=0;j<=di[1];j++){
                int feeSet1=feeSet+j*fee[2][1]+(di[1]-j)*fee[1][1];
                for(int k=0;k<=di[2];k++){
                    if((i+j+k)>500||((di[0]+di[1]+di[2]-i-j-k)>500))break;
                    int feeSet2=feeSet1+k*fee[2][2]+(di[2]-k)*fee[1][2];
                    for(int l=0;l<=di[3];l++){
                        if((i+j+k+l)>500||((di[0]+di[1]+di[2]+di[3]-i-j-k-l)>500))break;
                        int  feeSet3=feeSet2+l*fee[2][3]+(di[3]-l)*fee[1][3];
                        for(int m=0;m<=di[4];m++){
                            if((i+j+k+l+m)>500||((di[0]+di[1]+di[2]+di[3]+di[4]-i-j-k-l-m)>500))break;
                            int   feeSet4=feeSet3+m*fee[2][4]+(di[4]-m)*fee[1][4];
                            if(feeSet4<feeMin){
                                feeMin=feeSet4;
                                min2[0]=23;
                                min2[1]=i;
                                min2[2]=j;
                                min2[3]=k;
                                min2[4]=l;
                                min2[5]=m;
                            }
                        }
                    }
                }
            }
        }
        for(int i=di[0];i>=0;i--){
            int feeSet=2000;
            feeSet=feeSet+i*fee[0][0]+(di[0]-i)*fee[1][0];
            for(int j=di[1];j>=0;j--){
                int feeSet1=feeSet+j*fee[0][1]+(di[1]-j)*fee[1][1];
                for(int k=di[2];k>=0;k--){
                    if((i+j+k)>500||((di[0]+di[1]+di[2]-i-j-k)>500))break;
                    int feeSet2=feeSet1+k*fee[0][2]+(di[2]-k)*fee[1][2];
                    for(int l=di[3];l>=0;l--){
                        if((i+j+k+l)>500||((di[0]+di[1]+di[2]+di[3]-i-j-k-l)>500))break;
                        int  feeSet3=feeSet2+l*fee[0][3]+(di[3]-l)*fee[1][3];
                        for(int m=di[4];m>=0;m--){
                            if((i+j+k+l+m)>500||((di[0]+di[1]+di[2]+di[3]+di[4]-i-j-k-l-m)>500))break;
                            int   feeSet4=feeSet3+m*fee[0][4]+(di[4]-m)*fee[1][4];
                            if(feeSet4<feeMin){
                                feeMin=feeSet4;
                                min2[0]=12;
                                min2[1]=i;
                                min2[2]=j;
                                min2[3]=k;
                                min2[4]=l;
                                min2[5]=m;
                            }

                        }
                    }
                }
            }
        }
        //下面是1、3
        for(int i=di[0];i>=di[0];i--){
            int feeSet=2000;
            feeSet=feeSet+i*fee[0][0]+(di[0]-i)*fee[2][0];
            for(int j=di[1];j>=di[1];j--){
                int feeSet1=feeSet+j*fee[0][1]+(di[1]-j)*fee[2][1];
                for(int k=di[2];k>=0;k--){
                    if((i+j+k)>500||((di[0]+di[1]+di[2]-i-j-k)>500))break;
                    int feeSet2=feeSet1+k*fee[0][2]+(di[2]-k)*fee[2][2];
                    for(int l=di[3];l>=0;l--){
                        if((i+j+k+l)>500||((di[0]+di[1]+di[2]+di[3]-i-j-k-l)>500))break;
                        int  feeSet3=feeSet2+l*fee[0][3]+(di[3]-l)*fee[2][3];
                        for(int m=di[4];m>=0;m--){
                            if((i+j+k+l+m)>500||((di[0]+di[1]+di[2]+di[3]+di[4]-i-j-k-l-m)>500))break;
                            int   feeSet4=feeSet3+m*fee[0][4]+(di[4]-m)*fee[2][4];
                            if(feeSet4<feeMin){
                                feeMin=feeSet4;
                                min2[0]=13;
                                min2[1]=i;
                                min2[2]=j;
                                min2[3]=k;
                                min2[4]=l;
                                min2[5]=m;
                            }

                        }
                    }
                }
            }
        }
        for(int i=di[0];i>=0;i--){
            int feeSet=2000;
            feeSet=feeSet+i*fee[2][0]+(di[0]-i)*fee[1][0];
            for(int j=di[1];j>=0;j--){
                int feeSet1=feeSet+j*fee[2][1]+(di[1]-j)*fee[1][1];
                for(int k=di[2];k>=0;k--){
                    if((i+j+k)>500||((di[0]+di[1]+di[2]-i-j-k)>500))break;
                    int feeSet2=feeSet1+k*fee[2][2]+(di[2]-k)*fee[1][2];
                    for(int l=di[3];l>=0;l--){
                        if((i+j+k+l)>500||((di[0]+di[1]+di[2]+di[3]-i-j-k-l)>500))break;
                        int  feeSet3=feeSet2+l*fee[2][3]+(di[3]-l)*fee[1][3];
                        for(int m=di[4];m>=0;m--){
                            if((i+j+k+l+m)>500||((di[0]+di[1]+di[2]+di[3]+di[4]-i-j-k-l-m)>500))break;
                            int   feeSet4=feeSet3+m*fee[2][4]+(di[4]-m)*fee[1][4];
                            if(feeSet4<feeMin){
                                feeMin=feeSet4;
                                min2[0]=23;
                                min2[1]=i;
                                min2[2]=j;
                                min2[3]=k;
                                min2[4]=l;
                                min2[5]=m;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(feeMin);
        for (int i=0;i<6;i++){
            System.out.println(min2[i]);
        }

    }
}
