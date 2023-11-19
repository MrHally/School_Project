"""
    Viết chương trình thực hiện Menu sau:
    - Nhập danh sách nhân viên
    - Hiển thị danh sách nhân viên
    - Đếm số nhân viên có trong danh sách
    - Hiển thị nhân viên có tuổi lớn nhất
    - Hiển thị nhân viên có lương cao nhất
    - Kết thúc chương trình
    (Nhân viên: Họ tên, giới tính, năm sinh, lương)
"""

class Staff:
    def nhap(self):
        self.HoTen = input("Nhập họ tên: ")
        self.GioiTinh = input("Nhập giới tính: ")
        self.NamSinh = int(input("Nhập năm sinh: "))
        self.Luong = float(input("Nhập lương: "))
        self.tinhtuoi()
        
    def tinhtuoi(self):
        self.Tuoi = (2022 - self.NamSinh)
        
    def xuat(self):
        print("Nhân viên: ",self.HoTen,", Giới tính: ",self.GioiTinh,", Tuổi: ",self.Tuoi,"\nLương: ",self.Luong)
        
ds = []
luachon = 1
while(luachon>0 and luachon<7):
    print("=============MENU=============")
    print("1. Nhập danh sách nhân viên")
    print("2. Hiển thị danh sách vừa nhập")
    print("3. Hiển thị tổng danh sách vừa nhập")
    print("4. Hiển thị nhân viên có tuổi lớn nhất")
    print("5. Hiển thị nhân viên có lương cao nhất")
    print("6.Thoát chương trình")
    print("=============MENU=============")
    n = int(input("Lựa chọn: "))
    if(n == 1):
        op ="Y"
        while(op == "Y"):
            print("=============INPUT=============")
            nv = Staff()
            nv.nhap()
            ds.append(nv)
            op = input("Bạn có muốn nhập tiếp không (Y/N)?: ")
    if(n == 2):
        """Hiển thị ds"""
        print("=============OUTPUT=============")
        for i in range(len(ds)):
            ds[i].xuat()
    if(n == 3):
        """Hiển thị đếm số ds"""
        print("=============OUTPUT=============")
        print("Số nhân viên trong danh sách: ",len(ds))
    if(n == 4):
        """Hiển thị ds có tuổi lớn nhất"""
        print("=============OUTPUT=============")
        max = ds[0].Tuoi
        for i in range(len(ds)):  
            if(ds[i].Tuoi > max):
                max = ds[i].Tuoi
        print("Nhân viên có tuối lớn nhất: ")
        for i in range(len(ds)):
            if(ds[i].Tuoi == max):
                print(ds[i].HoTen)
    if(n == 5):
        """Hiển thị ds có lương cao nhất"""
        print("=============OUTPUT=============")
        max = ds[0].Luong
        for i in range(len(ds)):  
            if(ds[i].Luong > max):
                max = ds[i].Luong
        print("Nhân viên có lương cao nhất: ")
        for i in range(len(ds)):
            if(ds[i].Luong == max):
                print(ds[i].HoTen)
    if(n == 6):
        print("=============GOODBYE=============")
        break
