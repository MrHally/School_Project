class HocSinh:
    def nhap(self):
        self.hoten = input("Nhập họ tên: ")
        self.gioitinh = input("Nam/Nữ: ")
        self.lop = input("Nhập lớp học: ")
        self.diemToan = float(input("Nhập điểm toán: "))
        self.diemVan = float(input("Nhập điểm văn: "))
        self.XepLoai()
        
    def XepLoai(self):
        self.diemTB = (self.diemToan + self.diemVan)/2
        if(self.diemTB >= 8):
            self.loai = "Giỏi"
        elif(self.diemTB >= 6.5):
            self.loai ="Khá"
        elif(self.diemTB >= 5):
            self.loai = "Trung Bình"
        else:
            self.loai = "Yếu"
        
    def xuat(self):
        print("Học sinh:", self.hoten, ", giới tính: ", self.gioitinh, ", lớp: ", self.lop, "\n[Điểm Toán: ", self.diemToan, ", Điểm Văn: ", self.diemVan, ", Điểm Trung Bình: ", self.diemTB, "]\nXếp loại: ", self.loai)
        print("-----")
        
ds = []        
lop = HocSinh()
ds.append(lop)
        
print("==========LOADING==========")
f = open("Danhsachhocsinh.txt","r")
test = f.readlines()
index = 0
test1=[]
for i in test:
    temp1=i.split(":")
    test1.append(temp1)
for i in range(len(test1)):
    hocsinh1 = HocSinh()
    hocsinh1.hoten = test1[i][0]
    hocsinh1.gioitinh = test1[i][1]
    hocsinh1.lop = test1[i][2]
    hocsinh1.diemToan = float(test1[i][3])
    hocsinh1.diemVan = float(test1[i][4])
    hocsinh1.XepLoai()
    ds.append(hocsinh1)
print("==========DONE==========")

print("==========OUTPUT==========")
for i in range(len(ds)):
    ds[i].xuat()


