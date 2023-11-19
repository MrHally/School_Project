"""
    Viết chương trình nhận 2 giá trị nhập vào, in ra mảng 2 chiều có dạng [i,i*j]    
"""

inp = input("- Nhập a, b: ")
dim = [int(x) for x in inp.split(',')]
rum = dim[0]
cum = dim[1]
mst = [[0 for col in range(cum)] for row in range(rum)]
for row in range(rum):
    for col in range(cum):
        mst[row][col]= row * col
print("=> Mảng 2 chiều từ",rum,"và",cum,"là:",mst)