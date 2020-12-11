use furama;
insert into kieu_thue values
	(1, 'Nam', 100000000),
	(2, 'Thang', 10000000),
	(3, 'Ngay', 1000000),
	(4, 'Gio', 100000);
    
insert into loai_dich_vu values
	(1, 'Vip'),
	(2, 'Tot'),
	(3, 'Thuong');
    
insert into dich_vu values
    (1, 'Villa', 500, 2, '4', '20000000', 'Con', 2, 1),
    (2, 'House', 300, 3, '8', '8000000', 'Con', 1, 2),
    (3, 'Room', 100, 1, '4', '1000000', 'Con', 3, 3);
      
insert into loai_khach values
	(1, 'Diamond'),
	(2, 'Platinium'),
	(3, 'Gold'),
	(4, 'Silver'),
	(5, 'Member');
	
insert into khach_hang values
	(1, 'Trang', '1997-11-20', '812364873', '0123456789', 'trang@gmail.com', 'Da Nang', 2),
	(2, 'Anh', '2005-04-09', '812364873', '0123456789', 'trang@gmail.com', 'Quang Tri', 1),
	(3, 'Nhan', '1993-12-13', '812364873', '0123456789', 'trang@gmail.com', 'Dien bien phu', 3);
    
insert into vi_tri values
	(1, 'Le tan'),
	(2, 'Phuc vu'),
	(3, 'Chuyen vien'),
	(4, 'Giam sat'),
	(5, 'Quan ly'),
	(6, 'Giam doc');
    
insert into trinh_do values
	(1, 'Trung cap'),
	(2, 'Cao dang'),
	(3, 'Dai hoc'),
	(4, 'Co kinh nghiem');
    
insert into bo_phan values 
	(1, 'Sale-Maketing'),
    (2, 'Hanh chinh'),
	(3, 'Phuc vu'),
    (4, 'Quan ly');
    
insert into nhan_vien values
	(1, 'Khang', '1998-10-28', '68761234', '8000000', '0432874655', 'khang@gmail.com', 'Hoa khanh', 3, 3, 2),
	(2, 'Bao', '1997-09-24', '68761234', '8000000', '0432874655', 'bao@gmail.com', 'Hoa khanh', 5, 3, 4),
	(3, 'Thinh', '2003-10-28', '68761234', '8000000', '0432874655', 'thinh@gmail.com', 'Hoa khanh', 4, 3, 1);
    
insert into hop_dong values
	(1, '2018-12-04', '2020-12-25', 30000000, 60000000, 1, 2, 2),
	(2, '2019-12-14', '2021-01-05', 20000000, 40000000, 2, 1, 3),
	(3, '2020-12-24', '2021-01-01', 3000000, 6000000, 3, 2, 1);
    
insert into dich_vu_di_kem values
	(1, 'Massage', 500000, 2, 'Con'),
	(2, 'Karaoke', 300000, 5, 'Con'),
	(3, 'Food', 200000, 10, 'Con'),
	(4, 'Drink', 100000, 20, 'Con'),
	(5, 'Car', 150000, 10, 'Con');
    
insert into hop_dong_chi_tiet values
	(1, 2, 3, 2),
	(2, 3, 4, 3),
	(3, 1, 1, 2);
    