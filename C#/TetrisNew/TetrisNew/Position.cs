namespace TetrisNew
{
    public class Position
    {
        public int Row { get; set; }
        public int Column { get; set; }
        //Khai báo vị trí
        public Position(int row, int column)
        {
            Row = row;
            Column = column;
        }
    }
}
