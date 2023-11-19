-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 05, 2023 lúc 09:13 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ban_hang`
--


-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner`
--

CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `hinh` varchar(256) COLLATE utf8_bin NOT NULL,
  `rong` varchar(256) COLLATE utf8_bin NOT NULL,
  `cao` varchar(256) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `banner`
--

INSERT INTO `banner` (`id`, `hinh`, `rong`, `cao`) VALUES
(1, 'ở đây có đồ xinh.png', '990px', '250px');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `footer`
--

CREATE TABLE `footer` (
  `id` int(11) NOT NULL,
  `html` mediumtext COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `footer`
--

INSERT INTO `footer` (`id`, `html`) VALUES
(1, '<table width=\"990px\">\n<tbody>\n<tr>\n<td align=\"right\" width=\"495px\">Cửa h&agrave;ng :</td>\n<td width=\"495px\">Shop xyz</td>\n</tr>\n<tr>\n<td align=\"right\">Điện thoại :</td>\n<td>so_dien_thoai</td>\n</tr>\n<tr>\n<td align=\"right\">Địa chỉ :</td>\n<td>dia_chi</td>\n</tr>\n</tbody>\n</table>');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoa_don`
--

CREATE TABLE `hoa_don` (
  `id` int(11) NOT NULL,
  `ten_nguoi_mua` varchar(256) COLLATE utf8_bin NOT NULL,
  `email` varchar(256) COLLATE utf8_bin NOT NULL,
  `dia_chi` mediumtext COLLATE utf8_bin NOT NULL,
  `dien_thoai` varchar(256) COLLATE utf8_bin NOT NULL,
  `noi_dung` mediumtext COLLATE utf8_bin NOT NULL,
  `hang_duoc_mua` mediumtext COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `hoa_don`
--

INSERT INTO `hoa_don` (`id`, `ten_nguoi_mua`, `email`, `dia_chi`, `dien_thoai`, `noi_dung`, `hang_duoc_mua`) VALUES
(2, 'Long', 'phuclong@gmail.com', 'Cần Thơ', '0773188004', 'abc', '15sl1||'),
(5, 'Ngô Nhật Anh', 'nhatanh.personal@gmail.com', 'Ninh Kiều, Cần Thơ', '0522811354', 'Mua cho vợ ảo', '34 SL 1||');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu_doc`
--

CREATE TABLE `menu_doc` (
  `id` int(11) NOT NULL,
  `ten` varchar(256) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `menu_doc`
--

INSERT INTO `menu_doc` (`id`, `ten`) VALUES
(1, 'Set'),
(2, 'Váy'),
(3, 'Áo'),
(4, 'Áo khoác'),
(5, 'Quần');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu_doc_pk`
--

CREATE TABLE `menu_doc_pk` (
  `id` int(11) NOT NULL,
  `ten` varchar(256) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `menu_doc_pk`
--

INSERT INTO `menu_doc_pk` (`id`, `ten`) VALUES
(1, 'Giày & Dép'),
(2, 'Balo & Túi'),
(3, 'Dây nịt & Bóp ví');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `menu_ngang`
--

CREATE TABLE `menu_ngang` (
  `id` int(11) NOT NULL,
  `ten` varchar(256) COLLATE utf8_bin NOT NULL,
  `noi_dung` mediumtext COLLATE utf8_bin NOT NULL,
  `loai_menu` varchar(256) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `menu_ngang`
--

INSERT INTO `menu_ngang` (`id`, `ten`, `noi_dung`, `loai_menu`) VALUES
(1, 'Thời trang', '', 'san_pham'),
(2, 'Phụ kiện', '', 'phu_kien'),
(3, 'Hướng dẫn cài đặt', 'Nội dung cách mua hàng <br><br>\r\nNội dung cách mua hàng <br><br>\r\nNội dung cách mua hàng <br><br>\r\nNội dung cách mua hàng <br><br>\r\nNội dung cách mua hàng <br><br>\r\nNội dung cách mua hàng <br><br>\r\nNội dung cách mua hàng <br><br>', ''),
(4, 'Liên hệ', 'Nội dung liên hệ<br><br>\nNội dung liên hệ<br><br>\nNội dung liên hệ<br><br>\nNội dung liên hệ<br><br>\nNội dung liên hệ<br><br>\nNội dung liên hệ<br><br>\nNội dung liên hệ<br><br>', ''),
(5, 'Chính sách đổi trả', 'Chính sách đổi trả<br>', '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `phu_kien`
--

CREATE TABLE `phu_kien` (
  `id` int(11) NOT NULL,
  `ten` varchar(256) COLLATE utf8_bin NOT NULL,
  `gia` int(255) NOT NULL,
  `hinh_anh` varchar(256) COLLATE utf8_bin NOT NULL,
  `noi_dung` mediumtext COLLATE utf8_bin NOT NULL,
  `thuoc_menu` int(255) NOT NULL,
  `noi_bat` varchar(256) COLLATE utf8_bin NOT NULL,
  `trang_chu` varchar(256) COLLATE utf8_bin NOT NULL,
  `sap_xep_trang_chu` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `phu_kien`
--

INSERT INTO `phu_kien` (`id`, `ten`, `gia`, `hinh_anh`, `noi_dung`, `thuoc_menu`, `noi_bat`, `trang_chu`, `sap_xep_trang_chu`) VALUES
(1, 'balo mini trắng', 100000, 'balo1.jpg', 'balo mini trắng', 2, 'co', 'co', 1),
(2, 'túi xách GUCCI', 200000, 'tui1.jpg', 'túi xách GUCCI dành cho phái nữ', 2, 'co', 'co', 3),
(3, 'ví màu hồng đậm', 500000, 'vi1.jpg', 'ví màu hồng đậm dành cho phái yếu', 3, '', 'co', 5),
(4, 'ví màu hồng', 200000, 'vi3.jpg', 'ví màu hồng dành cho nữ ', 3, '', 'co', 5),
(5, 'thắt lưng nữ', 400000, 'that_lung1_2.jpeg', 'thắt lưng nữ nhỏ', 3, '', 'co', 5),
(6, 'giày đế cao trắng', 500000, 'giay1.jpg', 'giày đế cao', 1, '', 'co', 4),
(7, 'giày sneaker', 500000, 'giay3.jpg', 'giày sneaker nam và nữ', 1, 'co', '', 2),
(8, 'túi xách mini hồng và đen', 900000, 'tui3.jpg', 'túi xách mini hồng và đen dành cho nữ', 2, 'co', 'co', 1),
(9, 'balo mini màu xanh', 500000, 'balo3.jpg', 'balo mini màu xanh dành cho nữ', 2, 'co', 'co', 1),
(10, 'thắt lưng dành cho nữ', 200000, 'that_lung2_2.jpeg', 'thắt lưng dành cho nữ', 3, 'co', 'co', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `san_pham`
--

CREATE TABLE `san_pham` (
  `id` int(11) NOT NULL,
  `ten` varchar(256) COLLATE utf8_bin NOT NULL,
  `gia` int(255) NOT NULL,
  `hinh_anh` varchar(256) COLLATE utf8_bin NOT NULL,
  `noi_dung` mediumtext COLLATE utf8_bin NOT NULL,
  `thuoc_menu` int(255) NOT NULL,
  `noi_bat` varchar(256) COLLATE utf8_bin NOT NULL,
  `trang_chu` varchar(256) COLLATE utf8_bin NOT NULL,
  `sap_xep_trang_chu` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `san_pham`
--

INSERT INTO `san_pham` (`id`, `ten`, `gia`, `hinh_anh`, `noi_dung`, `thuoc_menu`, `noi_bat`, `trang_chu`, `sap_xep_trang_chu`) VALUES
(34, 'Áo Thun Nữ Tay Ngắn In Chữ Nice To Meet You', 100000, 'Ao1.jpg', '<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Thun Nữ Tay Ngắn In Chữ Nice To Meet You</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải thun</p>\r\n<p>- Bảng m&agrave;u: Be/ Trắng/ Xanh/ V&agrave;ng</p>\r\n<p>- Họa tiết: Trơn in chữ</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 14),
(35, 'Áo Thun Gân Xốp Nữ', 81, 'Ao2.jpg', '<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Thun Nữ Tay Ngắn In Chữ Nice To Meet You</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải thun</p>\r\n<p>- Bảng m&agrave;u: Be/ Trắng/ Xanh/ V&agrave;ng</p>\r\n<p>- Họa tiết: Trơn in chữ</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 15),
(36, 'Áo Thun Nữ Tay Lỡ Caro In Chữ Know Everything', 135, 'Ao3.jpg', '<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Thun Nữ Tay Ngắn In Chữ Nice To Meet You</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải thun</p>\r\n<p>- Bảng m&agrave;u: Be/ Trắng/ Xanh/ V&agrave;ng</p>\r\n<p>- Họa tiết: Trơn in chữ</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 16),
(37, 'Áo Thun Nữ Croptop Trơn Cổ Tròn', 84, 'Ao4.jpg', '<p>- T&ecirc;n sản phẩm: &Aacute;o Thun Nữ Croptop Trơn Cổ Tr&ograve;n&nbsp;</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải thun</p>\r\n<p>- Bảng m&agrave;u: Be/ Trắng/ Xanh/ V&agrave;ng</p>\r\n<p>- Họa tiết: Trơn in chữ</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 17),
(38, 'Áo Thun Cadigan Cổ Bẻ 3 Nút Kẻ Ngang', 118, 'Ao5.jpg', '<p>- T&ecirc;n sản phẩm: &Aacute;o Thun Cadigan Cổ Bẻ 3 N&uacute;t Kẻ Ngang&nbsp;</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải thun</p>\r\n<p>- Bảng m&agrave;u: Be/ Trắng/ Xanh/ V&agrave;ng</p>\r\n<p>- Họa tiết: Trơn in chữ</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 18),
(39, 'Áo Thun Nữ Croptop Khoét Giữa Rockmore', 144, 'Ao6.jpg', '<p>- T&ecirc;n sản phẩm: &Aacute;o Thun Nữ Croptop Kho&eacute;t Giữa Rockmore&nbsp;</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải thun</p>\r\n<p>- Bảng m&agrave;u: Be/ Trắng/ Xanh/ V&agrave;ng</p>\r\n<p>- Họa tiết: Trơn in chữ</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 19),
(40, 'Sơ Mi Nữ Tay Ngắn Cổ Vest 118.150VND', 118, 'Ao7.jpg', '<p><strong>TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Sơ Mi Nữ Tay Ngắn Cổ Vest</p>\r\n<p>- Độ tuổi: &gt; 14&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi</p>\r\n<p>- Chất liệu: Lụa</p>\r\n<p>- M&agrave;u sắc: Nhiều m&agrave;u</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm &aacute;o sơ mi tay ngắn tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 20),
(41, 'Áo Sơ Mi Nữ Croptop Tay Phồng 157.250VND', 157, 'Ao8.jpg', '<p><strong>TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Sơ Mi Nữ Croptop Tay Phồng</p>\r\n<p>- Độ tuổi: &gt; 12&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi</p>\r\n<p>- Chất liệu: Th&ocirc;</p>\r\n<p>- M&agrave;u sắc: Xanh biển/ Trắng/ Hồng/ Be</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm &aacute;o sơ mi tay ngắn tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 21),
(42, 'Áo Sơ Mi Tay Dài Thắt Dây Bên Eo', 123, 'Ao9.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Sơ Mi Tay D&agrave;i Thắt D&acirc;y B&ecirc;n Eo</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải lụa</p>\r\n<p>- Bảng m&agrave;u: Xanh dương/ Be/ Trắng</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 22),
(43, 'Áo Sơ Mi Voan Tay Dài', 174, 'Ao10.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Sơ Mi Voan Tay D&agrave;i</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải voan</p>\r\n<p>- Bảng m&agrave;u: Kem/ Xanh non/ Xanh dương nhạt/ Trắng/ Đen</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 23),
(44, 'Áo Sơ Mi Cổ Bẻ Tay Ngắn Kèm Cavat Sọc', 132, 'Ao11.jpg', '<p><strong>TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Sơ Mi Cổ Bẻ Tay Ngắn K&egrave;m Cavat Sọc&nbsp;</p>\r\n<p>- Độ tuổi: &gt; 14&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi</p>\r\n<p>- Chất liệu: Lụa</p>\r\n<p>- M&agrave;u sắc: Nhiều m&agrave;u</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm &aacute;o sơ mi tay ngắn tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 24),
(45, 'Áo Sơ Mi Nữ Voan Cổ Nhọn', 186, 'Ao12.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Sơ Mi Nữ Voan Cổ Nhọn</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải voan</p>\r\n<p>- Bảng m&agrave;u: Trắng/ Kem/ Xanh/ N&acirc;u</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 3, 'co', '', 25),
(46, 'Áo Khoác Bomber Nữ Phối Màu Tay', 305, 'AK1.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Kho&aacute;c Bomber Nữ Phối M&agrave;u Tay</p>\r\n<p>- Ph&ugrave; hợp: Mặc kho&aacute;c quanh năm</p>\r\n<p>- Chất liệu: Vải kaki</p>\r\n<p>- Bảng m&agrave;u: Hồng/ Be</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 4, 'co', '', 26),
(47, 'Áo Khoác Chống Nắng Mũ Vành', 157, 'AK2.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm: &Aacute;o Kho&aacute;c Chống Nắng Mũ V&agrave;nh</p>\r\n<p>- Độ tuổi: &gt;12&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc kho&aacute;c ngo&agrave;i 4 m&ugrave;a quanh năm.</p>\r\n<p>- Chất liệu: Vải thun&nbsp;</p>\r\n<p>- M&agrave;u sắc: Nhiều m&agrave;u</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>-<em>&nbsp;Cam kết&nbsp;100%&nbsp;</em>chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 4, 'co', '', 27),
(48, 'Áo Khoác Vest Dáng Ôm 2 Nắp Túi', 336, 'AK3.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Kho&aacute;c Vest D&aacute;ng &Ocirc;m Nắp T&uacute;i</p>\r\n<p>- Độ tuổi: &gt; 14 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi, đi tiệc.</p>\r\n<p>- Chất liệu: Vải umi</p>\r\n<p>- M&agrave;u sắc: Đen/ Be/ N&acirc;u/ Trắng</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 4, 'co', '', 28),
(49, 'Áo Khoác Kaki Có Mũ Form Rộng Nữ', 220, 'AK4.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Kho&aacute;c Kaki C&oacute; Mũ Form Rộng Nữ</p>\r\n<p>&Aacute;o kho&aacute;c nỉ mặc được 4 m&ugrave;a&nbsp;quanh năm, ph&ugrave; hợp với&nbsp;mọi độ tuổi.&nbsp;L&agrave; item kh&ocirc;ng thể thiếu trong tủ đồ của mỗi người.</p>\r\n<p>- Độ tuổi: &gt; 12 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;kho&aacute;c quanh năm.</p>\r\n<p>- Chất liệu: Vải kaki mềm</p>\r\n<p>- M&agrave;u sắc: Nhiều m&agrave;u</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>-<em>&nbsp;Cam kết&nbsp;100%&nbsp;</em>chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 4, 'co', '', 29),
(50, 'Áo Khoác Cadigan Mỏng Cổ Tim 1 Nút', 106, 'AK5.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Kho&aacute;c Cadigan Mỏng Cổ Tim 1 N&uacute;t&nbsp;</p>\r\n<p>- Chất vải tăm đẹp&nbsp;</p>\r\n<p>- Độ tuổi: &gt; 16 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Nữ</p>\r\n<p>- M&agrave;u sắc: nhiều m&agrave;u</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 4, 'co', '', 30),
(51, 'Áo Khoác Kiểu Nữ Caro 4 Nắp Túi', 288, 'AK6.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;&Aacute;o Kho&aacute;c Kiểu Nữ Caro 4 Nắp T&uacute;i</p>\r\n<p>- Độ tuổi: &gt; 14 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi, đi tiệc.</p>\r\n<p>- Chất liệu: Vải caro</p>\r\n<p>- M&agrave;u sắc: Đen/ Đỏ/ N&acirc;u/ V&agrave;ng</p>\r\n<p>- Họa tiết: Caro</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>\r\n<p>Quần</p>', 4, 'co', '', 31),
(52, 'Quần Jeans Trơn Ống Loe Logo Lưng', 237, 'Quan1.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Quần Jeans Trơn Ống Loe Logo Lưng</p>\r\n<p>- Độ tuổi: &gt; 13&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải jeans</p>\r\n<p>- M&agrave;u sắc: Xanh jeans nhạt/ Xanh jeans đậm</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>', 5, 'co', '', 32),
(53, 'Quần Tổ Ong Dáng Suông Lưng Thun', 161, 'Quan2.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Quần Tổ Ong D&aacute;ng Su&ocirc;ng Lưng Thun</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi chơi, đi l&agrave;m, ở nh&agrave;.</p>\r\n<p>- Chất liệu: Vải thun tổ ong</p>\r\n<p>- Bảng m&agrave;u: Da/ Đen/ Kem</p>\r\n<p>- Họa tiết: Trơn&nbsp;</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 5, 'co', '', 33),
(54, 'Quần Short Lưng Thun Vải Mềm', 76, 'Quan3.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Quần Short Lưng Thun Vải Mềm</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi chơi, ở nh&agrave;, tập thể thao.</p>\r\n<p>- Độ tuổi: &gt; 10&nbsp;tuổi</p>\r\n<p>- Chất liệu: Vải lụa</p>\r\n<p>- Bảng m&agrave;u:&nbsp;Đen/ Trắng/ Hồng/ Be</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 5, 'co', '', 34),
(55, 'Quần Tây Baggy Nắp Túi Giả', 178, 'Quan4.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Quần T&acirc;y Baggy Nắp T&uacute;i Giả</p>\r\n<p>- Độ tuổi: &gt; 14&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải tuyết mưa</p>\r\n<p>- M&agrave;u sắc: Đen/ Be/ N&acirc;u/ N&acirc;u&nbsp;đậm</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>', 5, 'co', '', 35),
(56, 'Quần Tây Nữ Dài Dáng Suông 2 Túi Ngang 1 Nút', 200, 'Quan5.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Quần T&acirc;y Nữ D&aacute;ng Su&ocirc;ng T&uacute;i Ngang</p>\r\n<p>- Độ tuổi: &gt; 14&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải lụa</p>\r\n<p>- M&agrave;u sắc:&nbsp;Đen/ Be</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>', 5, 'co', '', 36),
(57, 'Quần Baggy Jeans Ống Suông Lưng Kiểu', 161, 'Quan6.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Quần Baggy Jeans Ống Su&ocirc;ng Lưng Kiểu</p>\r\n<p>- Độ tuổi: &gt; 13&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải jeans</p>\r\n<p>- M&agrave;u sắc: Xanh jeans nhạt</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>', 5, 'co', '', 37),
(58, 'Chân Váy Tennis Trơn Màu', 144, 'Vay1.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Ch&acirc;n V&aacute;y Tennis Trơn M&agrave;u</p>\r\n<p>- Độ tuổi: &gt; 13&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi l&agrave;m, đi chơi, đi học, đi tiệc.</p>\r\n<p>- Chất liệu: Vải tuyết mưa</p>\r\n<p>- M&agrave;u sắc: Đen/ Trắng/ N&acirc;u/ Be</p>\r\n<p>- Họa tiết: Xếp ly</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, 'co', '', 38),
(59, 'Chân Váy Dài Đuôi Cá Dáng Xòe', 191, 'Vay2.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm: Ch&acirc;n V&aacute;y D&agrave;i Đu&ocirc;i C&aacute; D&aacute;ng X&ograve;e</p>\r\n<p>- Độ tuổi: &gt; 12 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi l&agrave;m, đi học, đi tiệc, đi chơi.</p>\r\n<p>- Chất liệu: Vải tơ nến</p>\r\n<p>- M&agrave;u sắc: Đen/ Trắng/ N&acirc;u</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, 'co', '', 39),
(60, 'Chân Váy Xòe Kaki 2 Túi Bên', 169, 'Vay3.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Ch&acirc;n V&aacute;y X&ograve;e Kaki 2 T&uacute;i B&ecirc;n</p>\r\n<p>- Độ tuổi: &gt; 13&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi l&agrave;m, đi chơi, đi học, đi tiệc.</p>\r\n<p>- Chất liệu: Vải kaki</p>\r\n<p>- M&agrave;u sắc: N&acirc;u/ Trắng/ Kem</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, 'co', '', 40),
(61, 'Chân Váy Kiểu Phối Xếp Ly 2 Nút', 184, 'Vay4.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Ch&acirc;n V&aacute;y Kiểu Phối Xếp Ly 2 N&uacute;t</p>\r\n<p>- Độ tuổi: &gt; 13&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải umi</p>\r\n<p>- M&agrave;u sắc: N&acirc;u/ Be/ Đen/ R&ecirc;u</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, 'co', '', 41),
(62, 'Chân Váy Dài Xếp Ly Trước 1 Nút', 161, 'Vay5.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm: Ch&acirc;n V&aacute;y D&agrave;i Xếp Ly Nhỏ Lưng Thun</p>\r\n<p>- Độ tuổi: &gt; 14&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi l&agrave;m, đi học, đi tiệc, đi chơi.</p>\r\n<p>- M&agrave;u sắc: Đen/ Kem</p>\r\n<p>- Họa tiết: Xếp ly</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, 'co', '', 42),
(63, 'Chân Váy Dáng Dài Nhiều Tầng Lưng Thun', 237, 'Vay6.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Ch&acirc;n V&aacute;y D&aacute;ng D&agrave;i Nhiều Tầng Lưng Thun</p>\r\n<p>- Độ tuổi: &gt; 14 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi l&agrave;m, đi chơi, đi tiệc.</p>\r\n<p>- Chất liệu: Voan</p>\r\n<p>- M&agrave;u sắc: Trắng/ X&aacute;m l&ocirc;ng chuột/ N&acirc;u/ Kem/ Hồng/ Đen/ Be</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, 'co', '', 43),
(64, 'Đồ Bộ Lụa Quần Đùi Viền Bèo 1 Túi', 144, 'Set1.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Đồ Bộ Lụa Quần Đ&ugrave;i Viền B&egrave;o 1 T&uacute;i</p>\r\n<p>- Ph&ugrave; hợp: Mặc ở nh&agrave;&nbsp;</p>\r\n<p>- Chất liệu: Vải thun</p>\r\n<p>- Bảng m&agrave;u: Xanh/ Hồng/ V&agrave;ng</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, 'co', '', 44),
(65, 'Đồ Bộ Đùi Cổ Bèo Nữ', 135, 'Set2.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Đồ Bộ Đ&ugrave;i Cổ B&egrave;o Nữ</p>\r\n<p>- Ph&ugrave; hợp: Mặc ở nh&agrave;</p>\r\n<p>- Chất liệu: Vải xốp</p>\r\n<p>- Bảng m&agrave;u: Be/ Hồng/ Xanh l&aacute;/ Xanh mint</p>\r\n<p>- Họa tiết: Trơn g&acirc;n sọc</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, 'co', '', 45),
(66, 'Set Bộ Quần Ống Suông Kèm Áo Thun', 212, 'Set3.jpg', '<p>* TH&Ocirc;NG TIN SẢN PHẨM</p>\r\n<p>- T&ecirc;n sản phẩm: Set Bộ Quần Ống Su&ocirc;ng K&egrave;m &Aacute;o Thun</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi ở nh&agrave;, đi chơi.</p>\r\n<p>- Chất liệu: &Aacute;o vải thun, Quần chất lụa</p>\r\n<p>- Bảng m&agrave;u: Xanh/ Trắng/ Hồng/ T&iacute;m</p>\r\n<p>- Họa tiết: Trơn in họa tiết</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, 'co', '', 46),
(67, 'Đồ Bộ Nữ Xốp Đùi Cổ Vest', 135, 'Set4.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Đồ Bộ Nữ Xốp Đ&ugrave;i Cổ Vest</p>\r\n<p>- Ph&ugrave; hợp: Mặc ở nh&agrave;</p>\r\n<p>- Chất liệu: Vải xốp</p>\r\n<p>- Bảng m&agrave;u: N&acirc;u nhạt/ N&acirc;u đất/ Trắng/ T&iacute;m/ v&agrave;ng/ Be/ Hồng</p>\r\n<p>- Họa tiết: Chấm bi - họa tiết</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, 'co', 'co', 47),
(68, 'Đồ Bộ Đùi Xốp Gân Cổ Vest Viền Bèo', 144, 'Set5.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Đồ Bộ Đ&ugrave;i Xốp G&acirc;n Cổ Vest Viền B&egrave;o</p>\r\n<p>- Ph&ugrave; hợp: Mặc ở nh&agrave;</p>\r\n<p>- Chất liệu: Vải xốp</p>\r\n<p>- Bảng m&agrave;u: Hồng/ Xanh</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>\r\n<p>Set nữ</p>', 1, '', 'co', 48),
(69, 'Set Áo Kiểu Hở Ngực Cài Nút Kèm Chân Váy Chữ A', 251, 'Set6.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Set &Aacute;o Kiểu Hở Ngực K&egrave;m Ch&acirc;n V&aacute;y Chữ A</p>\r\n<p>- Độ tuổi: &gt; 13 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi, đi tiệc.</p>\r\n<p>- Chất liệu: Vải tuyết mưa</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, 'co', 'co', 49),
(70, 'Yếm Jean Nữ Dài Túi Trước Xẻ Tà Giữa', 161, 'Set7.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Yếm Jean Nữ D&agrave;i T&uacute;i Trước Xẻ T&agrave; Giữa</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải jeans</p>\r\n<p>- Bảng m&agrave;u: Đen/ Xanh jeans đậm</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, '', '', 50),
(71, 'Set Áo Kiểu Kèm Chân Váy Chữ A', 314, 'Set8.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Set &Aacute;o Kiểu K&egrave;m Ch&acirc;n V&aacute;y Chữ A</p>\r\n<p>- Độ tuổi: &gt; 14 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi, đi tiệc.</p>\r\n<p>- Chất liệu: Vải kate</p>\r\n<p>- M&agrave;u sắc: Đen/ Xanh dương/ V&agrave;ng</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, 'co', '', 51),
(72, 'Set Áo Caro Kèm Chân Váy Chữ A', 251, 'Set9.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;S&eacute;t &Aacute;o Caro K&egrave;m Ch&acirc;n V&aacute;y Chữ A</p>\r\n<p>- Độ tuổi: &gt; 14 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi chơi, đi tiệc, du lịch.</p>\r\n<p>- Chất liệu: Vải kate</p>\r\n<p>- M&agrave;u sắc: Đen/ Xanh dương/ V&agrave;ng/ Xanh l&aacute;/ Đỏ</p>\r\n<p>- Họa tiết: Caro</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, '', 'co', 52),
(73, 'Set Áo Kiểu Thắt Nơ Tay Phồng Kèm Chân Váy Chữ A', 302, 'Set10.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Set &Aacute;o Kiểu Thắt Nơ Tay Phồng K&egrave;m Ch&acirc;n V&aacute;y Chữ A</p>\r\n<p>- Độ tuổi: &gt; 14 tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi, đi tiệc.</p>\r\n<p>- Chất liệu: Vải xốp</p>\r\n<p>- M&agrave;u sắc: Trắng/ Hồng</p>\r\n<p>- Họa tiết: Hoa nổi</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, '', '', 53),
(74, 'Set Áo Croptop Sát Nách Kèm Chân Váy Dài', 293, 'Set11.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;Set &Aacute;o Croptop S&aacute;t N&aacute;ch K&egrave;m Ch&acirc;n V&aacute;y D&agrave;i</p>\r\n<p>- Độ tuổi: &gt; 14&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi l&agrave;m, đi học, đi tiệc, đi chơi.</p>\r\n<p>- Chất liệu: Vải th&ocirc;</p>\r\n<p>- M&agrave;u sắc: Be/ Xanh cốm/ Trắng/ Xanh biển</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 1, '', 'co', 54),
(76, 'Váy Sát Nách Dáng Dài Nút Bọc', 251, 'Vay7.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;V&aacute;y S&aacute;t N&aacute;ch D&aacute;ng D&agrave;i N&uacute;t Bọc</p>\r\n<p>- Độ tuổi: &gt; 15&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi chơi, đi du lịch, đi biển</p>\r\n<p>- Chất liệu: Vải đũi</p>\r\n<p>- M&agrave;u sắc: Trắng/ Đen/ Be/ Kem/ Hồng/ Xanh dương</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, '', '', 55),
(77, 'Váy Sơ Mi Suông Tay Gấp Lai', 149, 'Vay8.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;V&aacute;y Sơ Mi Su&ocirc;ng Tay Gấp Lai</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi chơi, đi l&agrave;m, đi học, ở nh&agrave;.</p>\r\n<p>- Chất liệu: Vải lụa</p>\r\n<p>- Bảng m&agrave;u: Đen/ Xanh dương/ Xanh ngọc/ N&acirc;u/ Hồng</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Sản phẩm tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, '', '', 56),
(78, 'Váy Hoa Dáng Dài Tay Phồng Hở Lưng', 200, 'Vay9.jpg', '<p>*<strong>&nbsp;TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;V&aacute;y Hoa Cổ Tr&ograve;n S&aacute;t N&aacute;ch D&aacute;ng D&agrave;i</p>\r\n<p>- Độ tuổi: &gt; 13&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi l&agrave;m, đi chơi, đi tiệc.</p>\r\n<p>- Chất liệu: Vải hoa th&ocirc;</p>\r\n<p>- M&agrave;u sắc: Xanh l&aacute;/ Xanh biển</p>\r\n<p>- Họa tiết: Hoa nh&iacute;</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, 'co', '', 57),
(79, 'Váy 2 Dây Túi Bên Dáng Dài', 242, 'Vay10.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;V&aacute;y 2 D&acirc;y T&uacute;i B&ecirc;n D&aacute;ng D&agrave;i</p>\r\n<p>- Độ tuổi: &gt; 15&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc&nbsp;đi chơi, đi tiệc, đi du lịch</p>\r\n<p>- Chất liệu: Vải th&ocirc;</p>\r\n<p>- M&agrave;u sắc: Cam/ Trắng/ Xanh l&aacute;/ Xanh dương/ V&agrave;ng/ Hồng</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, '', '', 58),
(80, 'Váy Tay Bồng Thắt Eo Dáng Babydoll', 339, 'Vay11.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;V&aacute;y Tay Bồng Thắt Eo D&aacute;ng Babydoll</p>\r\n<p>- Độ tuổi: &gt; 15&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi, đi tiệc.</p>\r\n<p>- Chất liệu: Vải xốp nhắn</p>\r\n<p>- M&agrave;u sắc:&nbsp;Trắng/ Đen</p>\r\n<p>- Họa tiết: Trơn</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, 'co', '', 59),
(81, 'Váy Polo Nữ Phối Màu Ngực', 195, 'Vay12.jpg', '<p><strong>* TH&Ocirc;NG TIN SẢN PHẨM:</strong></p>\r\n<p>- T&ecirc;n sản phẩm:&nbsp;V&aacute;y Polo Nữ Phối M&agrave;u Ngực</p>\r\n<p>- Độ tuổi: &gt; 13&nbsp;tuổi</p>\r\n<p>- Ph&ugrave; hợp: Mặc đi học, đi l&agrave;m, đi chơi.</p>\r\n<p>- Chất liệu: Vải thun</p>\r\n<p>- M&agrave;u sắc: N&acirc;u</p>\r\n<p>- Họa tiết: Phối m&agrave;u</p>\r\n<p>- Xuất xứ: Tự thiết kế v&agrave; sản xuất bởi FM Style tại Việt Nam&nbsp;</p>\r\n<p>- Cam kết 100% chất lượng từ chất vải đến đường chỉ, ph&aacute;t hiện lỗi được ho&agrave;n trả miễn ph&iacute;.</p>', 2, '', '', 60);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `slideshow`
--

CREATE TABLE `slideshow` (
  `id` int(11) NOT NULL,
  `hinh` varchar(256) COLLATE utf8_bin NOT NULL,
  `lien_ket` varchar(256) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `slideshow`
--

INSERT INTO `slideshow` (`id`, `hinh`, `lien_ket`) VALUES
(1, 'a_1.png', '#'),
(2, 'a_2.png', '#'),
(3, 'a_3.png', '#'),
(4, 'a_4.png', '#');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thong_tin_quan_tri`
--

CREATE TABLE `thong_tin_quan_tri` (
  `id` int(11) NOT NULL,
  `ky_danh` varchar(256) COLLATE utf8_bin NOT NULL,
  `mat_khau` varchar(256) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `thong_tin_quan_tri`
--

INSERT INTO `thong_tin_quan_tri` (`id`, `ky_danh`, `mat_khau`) VALUES
(1, 'admin', 'ec0405c5aef93e771cd80e0db180b88b');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `footer`
--
ALTER TABLE `footer`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `menu_doc`
--
ALTER TABLE `menu_doc`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `menu_doc_pk`
--
ALTER TABLE `menu_doc_pk`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `menu_ngang`
--
ALTER TABLE `menu_ngang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `phu_kien`
--
ALTER TABLE `phu_kien`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `san_pham`
--
ALTER TABLE `san_pham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `slideshow`
--
ALTER TABLE `slideshow`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `thong_tin_quan_tri`
--
ALTER TABLE `thong_tin_quan_tri`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `banner`
--
ALTER TABLE `banner`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `footer`
--
ALTER TABLE `footer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `hoa_don`
--
ALTER TABLE `hoa_don`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `menu_doc`
--
ALTER TABLE `menu_doc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT cho bảng `menu_doc_pk`
--
ALTER TABLE `menu_doc_pk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `menu_ngang`
--
ALTER TABLE `menu_ngang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `phu_kien`
--
ALTER TABLE `phu_kien`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `san_pham`
--
ALTER TABLE `san_pham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=82;

--
-- AUTO_INCREMENT cho bảng `slideshow`
--
ALTER TABLE `slideshow`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `thong_tin_quan_tri`
--
ALTER TABLE `thong_tin_quan_tri`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
