/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s=0;
        int e=n-1;
        while(s<=e){
            int m= s+(e-s+1)/2;
            if(isBadVersion(m)){
                e=m-1;
            } else {
                s=m+1;
            }
        }
        return s;
    }
}