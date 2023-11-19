using System;

namespace TetrisNew
{
    public class BlockQueue
    {
        //Tạo id gạch
        private readonly Block[] blocks = new Block[]
        {
            new IBlock(),
            new JBlock(),
            new LBlock(),
            new OBlock(),
            new SBlock(),
            new TBlock(),
            new ZBlock()
        };

        private readonly Random random = new Random();

        public Block NextBlock { get; private set; }

        public BlockQueue()
        {
            NextBlock = RandomBlock();
        }
        // Tạo sự ngẫu nhiên
        private Block RandomBlock()
        {
            return blocks[random.Next(blocks.Length)];
        }
        // Lấy id và cập nhật id gạch hiện tại
        public Block GetAndUpdate()
        {
            Block block = NextBlock;

            do
            {
                NextBlock = RandomBlock();
            } while (block.Id == NextBlock.Id);

            return block;
        }

    }
}
