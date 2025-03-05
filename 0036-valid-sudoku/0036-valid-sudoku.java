class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.') continue;

                char ch = board[i][j];
                int boxIndex = (i/3)*3+(j/3);
                if(rows[i].contains(ch) || cols[j].contains(ch) || boxes[boxIndex].contains(ch)){
                    return false;
                }
                rows[i].add(ch);
                cols[j].add(ch);
                boxes[boxIndex].add(ch);
            }
        }

        return true;
    }
}