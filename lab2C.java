import java.io.*;
import java.util.StringTokenizer;
public class lab2C {
    public static void main(String[] args) {
        QReader input = new QReader();
        QWriter out = new QWriter();
        //int amount=input.nextInt();
        //for(int x=0;x<amount;x++) {
            int n = input.nextInt();
            long[] arr = new long[n];
            long[] ar = new long[n];
            //Obj count=new Obj(0);
            for (int i = 0; i < n; i++) {
                arr[i] = input.nextInt();
            }
            sort(arr, ar, 0, n - 1);
            //long result = 0;
            //for (int i = 0, j = n - 1; j - i >= 1; i++, j--) {
            //    result += arr[i] * arr[j];
            //}
            //out.println(count.a);

        //}
        //out.close();
        out.println(arr[n/3]);
        int i=0;
        int j=n/3;
        for(int x=0;x<n/3;x++){
            out.print(arr[i]+" ");
            i++;
            out.print(arr[j]+" "+arr[j+1]+" ");
            j+=2;
        }
        if(n%3!=0){
            for(int y=n/3*3;y<arr.length;y++){
                out.print(arr[y]+" ");
            }
        }
        out.close();
    }

    public static void sort(long []arr,long[] ar,int l,int r){
        //long[] B=new long[n/2];
        //long[] C=new long[n-n/2];
        if(r-l>0){
            /*for(int i=0;i<n/2;i++){
                B[i]=arr[i];
            }
            for(int i=n/2;i<n;i++){
                C[i-n/2]=arr[i];
            }*/
            int mid=(r+l)/2;
            sort(arr,ar,l,mid);
            sort(arr,ar,mid+1,r);
            merge(arr,ar,l,mid,mid+1,r);
        }

    }

    public static void merge(long []arr,long[] ar,int l1,int r1,int l2,int r2){
        //int n=B.length+C.length;
        //long []A=new long[n];
        int i=l1;
        int j=l2;
        for(int k=l1;k<=r2;k++){
            if(i<=r1&&(j>r2||arr[i]<=arr[j])){
                ar[k]=arr[i];
                i++;
            }
            else{
                ar[k]=arr[j];
                //count.a+=r1-i+1;
                j++;
            }
        }
        for(int k=l1;k<r1+r2-l2+2;k++){
            arr[k]=ar[k];
        }
    }
}

class QReader {
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer = new StringTokenizer("");

    private String innerNextLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public boolean hasNext() {
        while (!tokenizer.hasMoreTokens()) {
            String nextLine = innerNextLine();
            if (nextLine == null) {
                return false;
            }
            tokenizer = new StringTokenizer(nextLine);
        }
        return true;
    }

    public String nextLine() {
        tokenizer = new StringTokenizer("");
        return innerNextLine();
    }

    public String next() {
        hasNext();
        return tokenizer.nextToken();
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public long nextLong() {
        return Long.parseLong(next());
    }
}

class QWriter implements Closeable {
    private BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public void print(Object object) {
        try {
            writer.write(object.toString());
        } catch (IOException e) {
            return;
        }
    }

    public void println(Object object) {
        try {
            writer.write(object.toString());
            writer.write("\n");
        } catch (IOException e) {
            return;
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            return;
        }
    }
}
