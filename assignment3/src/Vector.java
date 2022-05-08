public class Vector {
    private int x;
    private int y;
    private int z;
    public Vector(int x,int y,int z){
    this.x=x;
    this.y=y;
    this.z=z;
    }
    public int quadrant() {
        int t;
        if (x > 0 && y > 0 && z > 0) {
            t= 1;
        } else if (x < 0 && y > 0 && z > 0) {
            t= 2;
        } else if (x < 0 && y < 0 && z > 0) {
            t= 3;
        } else if (x > 0 && y < 0 && z > 0) {
            t= 4;
        } else if (x > 0 && y > 0 && z < 0) {
            t= 5;
        } else if (x < 0 && y > 0 && z < 0) {
            t= 6;
        } else if (x < 0 && y < 0 && z < 0) {
            t= 7;
        } else if (x > 0 && y < 0 && z < 0) {
            t= 8;
        }
        else t=-1;
        return t;
    }
    public double modulus(){
        double m=Math.sqrt((double)x*(double) x+(double) y*(double) y+(double) z*(double) z);
         return m;
    }

    public String toString(){
        String x; String y; String z; String vector;
        x = String.valueOf(this.x);
        y = String.valueOf(this.y);
        z = String.valueOf(this.z);
        vector = "(" + x + "," + y + "," + z + ")";
     return vector;
    }
    public Vector add(Vector vector){
        Vector vector1;
        x = x + vector.x;
        y = y + vector.y;
        z = z + vector.z;
        vector1 = new Vector(x,y,z);
     return vector1;
    }
    public double area(Vector vector){
        double a=Math.sqrt(Math.pow(vector.x,2)+Math.pow(vector.y,2)+Math.pow(vector.z,2));
        double b=Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2)+Math.pow(this.z,2));
        double c=Math.sqrt(Math.pow(vector.x-this.x,2)+Math.pow(vector.y-this.y,2)+Math.pow(vector.z-this.z,2));
     double p=(a+b+c)/2;
     double area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
     return area;
    }
    public static Vector add(Vector a,Vector b){
        Vector v3;
        int x,y,z;
        x=a.x+b.x;
        y=a.y+b.y;
        z=a.z+b.z;
        v3=new Vector(x,y,z);
      return v3;

    }
    public static double area(Vector a,Vector b){
        double l=Math.sqrt(Math.pow(a.x,2)+Math.pow(a.y,2)+Math.pow(a.z,2));
        double m=Math.sqrt(Math.pow(b.x,2)+Math.pow(b.y,2)+Math.pow(b.z,2));
        double n=Math.sqrt(Math.pow(a.x-b.x,2)+Math.pow(a.y-b.y,2)+Math.pow(a.z-b.z,2));
        double p=(l+m+n)/2;
        double area2=Math.sqrt(p*(p-l)*(p-m)*(p-n));
        return area2;
    }

}
