
class Pair {
    int f;
    int s;

    public Pair(int f, int s) {
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public void bfs(int r, int c, int[][] vis, char[][] grid) {
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(r, c));
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            Pair current = q.poll();
            int pr = current.f;
            int pc = current.s;

            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == '1' && vis[nr][nc] == 0) {
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (vis[r][c] == 0 && grid[r][c] == '1') {
                    cnt++;
                    bfs(r, c, vis, grid);
                }
            }
        }

        return cnt;
    }
}


