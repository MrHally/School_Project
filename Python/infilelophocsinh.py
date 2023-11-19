"""
    Viết chương trình tạo một class Hocsinh()
    - nhập danh sách học sinh: mã học sinh, tên học sinh, giới tính, lớp, điểm toán, điểm văn)
    - hiển thị danh sách đã nhập 
    - in ra trong tập tin.txt
    Viết chương trình đọc tập tin và xuất ra thông tin theo dạng khai báo
"""

class HocSinh:
    def nhap(self):
        self.hoten = input("Nhập họ tên: ")
        self.gioitinh = input("Nam/Nữ: ")
        self.lop = input("Nhập lớp học: ")
        self.diemToan = float(input("Nhập điểm toán: "))
        self.diemVan = float(input("Nhập điểm văn: "))

op = "Y"
ds = []
while(op == "Y"):
    print("==========INPUT: ==========")
    lop = HocSinh()
    lop.nhap()
    ds.append(lop)
    op = input("bạn có muốn nhập tiếp không (Y/N)?: ")
    
print("==========ENDCODING==========")
f = open("Danhsachhocsinh.txt", "a", encoding="utf8")
for i in range(len(ds)):
    f.write(ds[i].hoten+":"+ ds[i].gioitinh+":"+ds[i].lop+":"+str(ds[i].diemToan)+":"+str(ds[i].diemVan)+"\n")
f.close()
print("==========DONE==========")
