"""
Thiết kế lớp class Laptop có nhãn hiệu, giá tiền, màu sắc, xuất xứ
Thiết kế lớp nhân viên có mã, tên, giới tính
Thiết kế lớp cửa hàng có danh sánv nhân viên, danh sánv laptop 1 cửa hàng, địa nvỉ
YC:
Nhập xuất n cửa hàng
In ra tên cửa hàng có số lượng laptop nhiều nhất
Tính tổng giá trị các laptop cửa từng cửa hàng
"""

class Laptop:
    def nhap_laptop(self):
        self.nhanhieu = input("Nhãn hiệu: ")
        self.giatien = int(input("Giá tiền: "))
        self.mausac = input("Màu: ")
        self.xuatxu = input("Xuất xứ: ")
        
    def xuat_laptop(self):
        print("Laptop ",self.nhanhieu,", Giá: ",self.giatien,", Màu: ",self.mausac,", Xuất Xứ: ",self.xuatxu)
        
class Staff:
    def nhap_nv(self):
        self.MaNV = input("Mã nhân viên: ")
        self.HoTen = input("Họ tên: ")
        self.GioiTinh = input("Giới Tính: ")
        
    def xuat_nv(self):
        print("Mã Nhân viên: ",self.MaNV,", Tên: ",self.HoTen,", Giới tính : ",self.GioiTinh)
        
class Store:
    def nhap_cuahang(self):
        self.ten = input("Nhập tên cửa hàng: ")
        self.dc = input("Nhập địa chỉ : ")
        self.dsnv = []
        self.dssp = []
        op = "Y"
        while(op == "Y"):
            print("=========NHÂN VIÊN=========")
            nv = Staff()
            nv.nhap_nv()
            self.dsnv.append(nv)
            op = input("Bạn có muốn nhập nhân viên tiếp không (Y/N)?: ")
        op = "Y"
        while(op == "Y"):
            print("=========SẢN PHẨM=========")
            sp = Laptop()
            sp.nhap_laptop()
            self.dssp.append(sp)
            op = input("Bạn có muốn nhập sản phẩm tiếp không (Y/N)?: ")

    def xuat_daydu(self):
        print("=========CỬA HÀNG",self.ten,"=========")
        print("Địa chỉ: ",self.dc)
        for i in range(len(self.dsnv)):
            print("=========NHÂN VIÊN=========")
            i.xuat_nv()
        for i in range(len(self.dssp)):
            print("=========SẢN PHẨM=========")
            i.xuat_laptop()

    def Tongtien(self):
        Tong = 0
        for i in self.dssp:
            Tong += i.giatien
            return Tong

dsstore = []
store = Store()
store.nhap_cuahang()
dsstore.append(store)
for i in dsstore:
    i.xuat_daydu()

max = dsstore[0].dssp
temp = 0
for i in dsstore:
    if(len(i.dssp) > max ):
        max = i.dssp
        temp = dsstore[i]
print("==================")
print("Cửa hàng ",dsstore[temp].ten," Có số lượng laptop nhiều nhất: ",len(dsstore[temp].dssp))
print("==================")
for i in dsstore:
    print("Tổng giá trị laptop của cửa hàng ",i.ten," là: ", i.Tongtien())
