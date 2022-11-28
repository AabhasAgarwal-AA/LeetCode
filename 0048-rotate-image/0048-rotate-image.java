class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverseRow(matrix);
    }
    private void transpose(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < i; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
    }
    private void reverseRow(int[][] mat){
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat.length / 2; j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat.length - j - 1];
                mat[i][mat.length - j - 1] = temp;
            }
        }
    }
}