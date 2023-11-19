namespace TetrisNew
{
    public class GameState
    {
        private Block currentBlock;
        //Khai báo gạch hiện tại
        public Block CurrentBlock
        {
            get => currentBlock;
            private set
            {
                currentBlock = value;
                currentBlock.Reset();

                for(int i = 0; i < 2; i++)
                {
                    currentBlock.Move(1, 0);

                    if (!BlockFits())
                    {
                        currentBlock.Move(-1, 0);
                    }
                }
            }
        }

        public GameGrid GameGrid { get; }
        public BlockQueue BlockQueue { get; }
        public bool GameOver { get; private set; }
        public int Score { get; private set; }
        //Khai báo tình trạng gạch
        public GameState()
        {
            GameGrid = new GameGrid(22, 10);
            BlockQueue = new BlockQueue();
            CurrentBlock = BlockQueue.GetAndUpdate();
        }
        //Kiểm tra vị trí gạch
        private bool BlockFits()
        {
            foreach (Position p in CurrentBlock.TilesPosition())
            {
                if (!GameGrid.IsEmpty(p.Row, p.Column))
                {
                    return false;
                }
            }

            return true;
        }
        //Xoay gạch theo chiều kim đồng hồ
        public void RotateBlockCW()
        {
            CurrentBlock.RotateCW();

            if (!BlockFits())
            {
                CurrentBlock.RotateCCW();
            }
        }
        //Xoay gạch ngược chiều kim đồng hồ
        public void RotateBlockCCW()
        {
            CurrentBlock.RotateCCW();

            if (!BlockFits())
            {
                CurrentBlock.RotateCW();
            }
        }
        //Di chuyển gạch sang trái
        public void MoveBlockLeft()
        {
            CurrentBlock.Move(0, -1);

            if (!BlockFits())
            {
                CurrentBlock.Move(0,1);
            }
        }
        //Di chuyển gạch sang phải
        public void MoveBlockRight()
        {
            CurrentBlock.Move(0, 1);

            if (!BlockFits())
            {
                CurrentBlock.Move(0, -1);
            }
        }
        //Kiểm tra tình trạng game kết thúc
        private bool IsGameOver()
        {
            return !(GameGrid.IsRowsEmpty(0) && GameGrid.IsRowsEmpty(1));
        }
        // Đặt gạch + tính điểm
        private void PlaceBlock()
        {
            foreach (Position p in CurrentBlock.TilesPosition())
            {
                GameGrid[p.Row, p.Column] = CurrentBlock.Id;
            }

            Score += GameGrid.ClearFullRows();

            if (IsGameOver())
            {
                GameOver = true;
            }
            else
            {
                CurrentBlock = BlockQueue.GetAndUpdate();
            }
        }
        //Di chuyển gạch xuống
        public void MoveblockDown()
        {
            CurrentBlock.Move(1, 0);

            if (!BlockFits())
            {
                CurrentBlock.Move(-1, 0);
                PlaceBlock();
            }
        }
        //Biến khoảng cách
        private int TileDropDistance(Position p)
        {
            int drop = 0;

            while(GameGrid.IsEmpty(p.Row + drop + 1, p.Column))
            {
                drop++;
            };

            return drop;
        }
        //Tính khoảng cách từ gạch đang rơi và dòng cuối cùng
        public int BlockDropDistance()
        {
            int drop = GameGrid.Rows;

            foreach (Position p in currentBlock.TilesPosition())
            {
                drop = System.Math.Min(drop, TileDropDistance(p));
            }

            return drop;
        }
        //Thả gạch lập tức
        public void DropBlock()
        {
            CurrentBlock.Move(BlockDropDistance(), 0);
            PlaceBlock();
        }
    }
}
