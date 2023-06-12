/**
 * <a href="https://leetcode.com/problems/reaching-points/description/">...</a>
 */

public class ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
           while(tx >= sx && ty >= sy){

               if(tx == sx && ty == sy) return true;

               if(tx>ty){
                   if(ty == sy) return (tx-sx) % ty == 0;
                   tx %= ty;
               } else{
                   if(sx == tx) return (ty - sy) % tx == 0;
                   ty %= tx;
               }

           }

           return false;
        }

    public static void main(String[] args) {

    }
}
