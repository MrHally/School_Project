namespace TetrisNew
{
    public class GameGrid
    {
        //Khung game
        private readonly int[,] grid;
        public int Rows { get; }
        public int Columns { get; }

        public int this[int r, int c]
        {
            get => grid[r, c];
            set => grid[r, c] = value;
        }
        //Khai báo khung game
        public GameGrid(int rows, int columns)
        {
            Rows = rows;
            Columns = columns;
            grid = new int[rows, columns];
        }

        //Kiểm tra vị trí ô
        public bool IsInside(int r, int c)
        {
            return r >= 0 && r < Rows && c >= 0 && c < Columns;
        }

        //Kiểm tra ô trống
        public bool IsEmpty(int r, int c)
        {
            return IsInside(r, c) && grid[r, c] == 0;
        }

        //Kiểm tra dòng đầy
        public bool IsRowsFull(int r)
        {
            for(int c = 0; c < Columns; c++)
            {
                if (grid[r, c] == 0)
                {
                    return false;
                }
            }

            return true;
        }

        //Kiểm tra dòng trống
        public bool IsRowsEmpty(int r)
        {
            for (int c = 0; c < Columns; c++)
            {
                if (grid[r, c] != 0)
                {
                    return false;
                }
            }

            return true;
        }
        //Dọn dòng
        private void ClearRows(int r)
        {
            for(int c = 0; c < Columns ; c++)
            {
                grid[r, c] = 0;
            }
        }
        //Di chuyển dòng xuống
        private void MoveRowDown(int r, int numRows)
        {
            for(int c = 0; c < Columns; c++)
            {
                grid[r +numRows, c] = grid[r, c];
                grid[r, c] = 0;
            }
        }
        //Tính điểm khi dọn dòng
        public int ClearFullRows()
        {
            int cleared = 0;

            for(int r = Rows -1; r>=0; r--)
            {
                if (IsRowsFull(r))
                {
                    ClearRows(r);
                    cleared++;
                }
                else if(cleared > 0)
                {
                    MoveRowDown(r, cleared);
                }
            }

            return cleared;
        }
    }
}
