"""
    viết chương trình tạo tập tin cho phép người dùng nhập chuỗi số 2 chiều
    viết chương trình đọc tập tin và tính tổng chuỗi mảng 2 chiều đó
"""

nhap = int(input("Nhập N: "))
a = []
for i in range(0,nhap):
    b = []
    for j in range(0,nhap):
        print("Nhap a[",i,"][",j,"]= " , end='')
        b = b + [int(input())]
        a = a + b
        
print(a)

tong = 0
for i in range(0,nhap):
    tong = tong + a[i][j]
    
print(tong)

