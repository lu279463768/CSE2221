public class solution {
    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] grid = new int[m][n];
        for (int[] g : grid) {
            for (int i = 0; i < g.length; i++) {
                g[i] = -1;
            }
        }
        //is the value in this position is -1 that means it hasn't been vistied yet
        int bound = m > n ? n : m;
        for (int i = 0; i < bound && head != null; i++) {
            int col = i;
            int row = i;
            while (col >= 0 && col < grid[0].length && row >= 0
                    && row < grid.length && grid[row][col] == -1
                    && head != null) {
                grid[row][col++] = head.val;
                head = head.next;
            }
            if (col == grid[0].length) {
                col--;
            }

            while (grid[row][col] == -1 && row < grid.length && head != null) {
                grid[row++][col] = head.val;
                head = head.next;
            }
            if (row == grid.length) {
                row--;
            }

            while (grid[row][col] == -1 && col >= 0 && head != null) {
                grid[row][col--] = head.val;
                head = head.next;
            }
            if (col == -1) {
                col++;
            }
            while (grid[row][col] == -1 && row >= 0 && head != null) {
                grid[row--][col] = head.val;
                head = head.next;
            }
        }

        return grid;

    }

    /**
     * Definition for singly-linked list.
     *
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        int[] arr = { 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0 };
        int i = 0;
        ListNode head = new ListNode(3);
        while (i < arr.length) {
            head = new ListNode(arr[0], new ListNode());
            head = head.next;
            i++;
        }
        spiralMatrix(3, 5, head);
    }
}
