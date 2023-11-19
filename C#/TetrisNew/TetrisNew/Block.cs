using System.Collections;
using System.Collections.Generic;


namespace TetrisNew
{
    public abstract class Block
    {
        protected abstract Position[][] Tiles { get; }
        protected abstract Position StartOffset { get; }
        public abstract int Id { get; }

        private int rotationState;
        private Position offset;

        public Block()
        {
            offset = new Position(StartOffset.Row,StartOffset.Column);
        }
        // Khai báo lặp đi lặp lại trạng thái gạch
        public IEnumerable<Position> TilesPosition()
        {
            foreach (Position p in Tiles[rotationState])
            {
                yield return new Position(p.Row + offset.Row, p.Column + offset.Column);
            }
        }
        //Xoay chiều kim đồng hồ
        public void RotateCW()
        {
            rotationState = (rotationState + 1) % Tiles.Length;
        }
        //Xoay ngược chiều kim đồng hồ
        public void RotateCCW()
        {
            if(rotationState == 0)
            {
                rotationState = Tiles.Length - 1;
            }
            else
            {
                rotationState--;
            }
        }
        // Di chuyển gạch
        public void Move(int rows, int columns)
        {
            offset.Row += rows;
            offset.Column += columns;
        }
        // Đặt lại trạng thái
        public void Reset()
        {
            rotationState = 0;
            offset.Row = StartOffset.Row;
            offset.Column = StartOffset.Column;
        }
    }
}
