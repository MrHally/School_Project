"""
    Thiết kế lớp món ăn có tên món, giá tiền
    Thiết kế lớp bàn, có số thứ tự, ds món ăn đc chọn của bàn
    Viết chương trình nhận vào 1 bàn ăn có n món ăn
    - In ra ds các món mà bạn order
    - Tính tổng giá tiền
    - Tìm món có giá mắc nhất, rẻ nhất
    -     
"""

class ThucAn:
    def nhap(self):
        self.monan = input("Nhập món ăn: ")
        self.giatien = int(input("Nhập giá: "))
        
    def in_monAn(self):
        print("[Món:",self.monan,"   Giá: ",self.giatien,"]")
        print("---")
        
class Ban:
    def nhap(self):
        self.soban = input("Nhập số bàn: ")
        self.Thucdon = []
        self.lc = "Y"
        while(self.lc == "Y"):
            print("=========MÓN ĂN=========")
            self.ta = ThucAn()
            self.ta.nhap()
            self.Thucdon.append(self.ta)
            self.lc = input("Bạn có muốn nhập món tiếp không (Y/N)?: ")
        
    def in_dd(self):
        print("=========THỰC ĐƠN=========")
        print("Số bàn: ",self.soban)
        for self.i in self.Thucdon:
            print("[Món:",self.i.monan,"   Giá: ",self.i.giatien,"]")
            print("---")
            
    def tinhtong(self):
        print("=========HÓA ĐƠN=========")
        print("Bàn ",self.soban)
        tong = 0
        for i in self.Thucdon:
            tong += i.giatien
        print("Tổng bill: ",tong)
            
    
    def in_minmax(self):
        print("=========CHECKING=========")
        print("Bàn ",self.soban)
        min = self.Thucdon[0].giatien
        max = self.Thucdon[0].giatien
        for i in self.Thucdon:
            if(i.giatien < min):
                min = i.giatien
            if(i.giatien > max):
                max = i.giatien
        print("Món có giá thấp nhất: ")
        for i in self.Thucdon:
            if(i.giatien == min):
                i.in_monAn()
        print("Món có giá cao nhất: ")
        for i in self.Thucdon:
            if(i.giatien == max):
                i.in_monAn()
       
op = "Y"
ds = []
while(op == "Y"):
    print("=========NHÀ HÀNG=========")
    Chonban = Ban()
    Chonban.nhap()
    ds.append(Chonban)
    print("=========NHÀ HÀNG=========")
    op = input("Bạn có muốn nhập bàn tiếp không (Y/N)?: ")
    
"""In ra danh sách đầy đủ"""
for i in range(len(ds)):
    ds[i].in_dd()
    
for i in range(len(ds)):
    ds[i].in_minmax()
    
for i in range(len(ds)):
    ds[i].tinhtong()
    
