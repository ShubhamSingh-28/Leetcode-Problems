class Solution {
    public int countDays(int days, int[][] meetings) {
        // 561 / 578 testcases passed 
        // Set<Integer> set= new HashSet<>();
        // for(int m[]:meetings){
        //     int start=m[0];
        //     int end = m[1];
        //     for(int i=start;i<=end;i++){
        //         set.add(i);
        //     }
        // }
        // int c=0;
        // for(int j=1;j<=days;j++){
        //     if(!set.contains(j)) c++;
        // }
        // return c;

        int freeDays = 0, latestEnd = 0;
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        for(int meeting[]:meetings){
                        int start = meeting[0], end = meeting[1];

            // Add current range of days without a meeting
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }

            // Update latest meeting end
            latestEnd = Math.max(latestEnd, end);
        }

        // Add all days after the last day of meetings
        freeDays += days - latestEnd;

        return freeDays;
    }
}