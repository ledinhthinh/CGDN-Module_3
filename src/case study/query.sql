use furama;
-- task 2 --- 
select* from nhan_vien where nhan_vien.ho_ten like 'H%' or nhan_vien.ho_ten like 'T%' or nhan_vien.ho_ten like 'K%' 
and length(furama.nhan_vien.ho_ten) <=15;
-- task 3 --
select * from khach_hang where year(curdate())-year(ngay_sinh) <=50 and year(curdate())-year(ngay_sinh)>=18
and (khach_hang.dia_chi like "Da Nang" or  khach_hang.dia_chi like "Quang Tri");
-- task 4 --0
select hop_dong.id_khach_hang,khach_hang.ho_ten,loai_khach.ten_loai_khach,count(hop_dong.id_dich_vu) as count_hop_dong
from hop_dong join khach_hang on hop_dong.id_khach_hang = khach_hang.id_khach_hang
join loai_khach on khach_hang.id_loai_khach = khach_hang.id_khach_hang
where loai_khach.ten_loai_khach = "Diamond"
group by hop_dong.id_khach_hang
order by count_hop_dong;
-- task 5 --
select khach_hang.id_khach_hang, khach_hang.ho_ten, loai_khach.ten_loai_khach, hop_dong.id_hop_dong, 
	dich_vu.ten_dich_vu, hop_dong.ngay_lam_hop_dong, hop_dong.ngay_ket_thuc, 
    (dich_vu.chi_phi_thue + dich_vu_di_kem.gia * hop_dong_chi_tiet.so_luong) as tong_tien
    from khach_hang  left join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
		left join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
		left join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
		left join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
		left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem;
-- task 6 --
select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,hop_dong.ngay_lam_hop_dong,dich_vu.dien_tich,dich_vu.chi_phi_thue,
loai_dich_vu.ten_loai_dich_vu from dich_vu
join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
left join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where not(year(hop_dong.ngay_lam_hop_dong) = 2019 and month(hop_dong.ngay_lam_hop_dong) in(1,2,3));
-- task 7 --
select dich_vu.id_dich_vu,dich_vu.ten_dich_vu,dich_vu.dien_tich,dich_vu.so_nguoi_toi_da,
dich_vu.chi_phi_thue,loai_dich_vu.ten_loai_dich_vu,ngay_lam_hop_dong 
from dich_vu 
join loai_dich_vu on dich_vu.id_loai_dich_vu = loai_dich_vu.id_loai_dich_vu
join hop_dong on hop_dong.id_dich_vu = dich_vu.id_dich_vu
where year(ngay_lam_hop_dong) = 2018 and hop_dong.id_dich_vu not 
in (select hop_dong.id_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2019);
-- task 8 --
-- c1
select distinct khach_hang.ho_ten from khach_hang;
-- c2
select khach_hang.ho_ten from khach_hang group by khach_hang.ho_ten;
-- c3
select khach_hang.ho_ten from khach_hang 
union
select khach_hang.ho_ten from khach_hang;
-- task 9 --
select month(hop_dong.ngay_lam_hop_dong) as thang,count(month(ngay_lam_hop_dong)) as songuoidatphong
from hop_dong where year(ngay_lam_hop_dong)=2019
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);
-- task 10 --
select hop_dong.id_hop_dong,hop_dong.ngay_lam_hop_dong,hop_dong.ngay_ket_thuc,
hop_dong.tien_dat_coc,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as soluongdichvudikem
from hop_dong 
join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_hop_dong
order by hop_dong_chi_tiet.id_hop_dong;
-- task 11 --0
select khach_hang.ho_ten,khach_hang.dia_chi,loai_khach.ten_loai_khach, 
dich_vu_di_kem.ten_dich_vu_di_kem,dich_vu_di_kem.gia from khach_hang
join loai_khach on khach_hang.id_loai_khach = loai_khach.id_loai_khach
join hop_dong on hop_dong.id_khach_hang = khach_hang.id_khach_hang
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
where ten_loai_khach = 'Diamond' and dia_chi in ('Vinh','quang ngai');
-- task 12 --
select hop_dong.id_hop_dong,nhan_vien.ho_ten,khach_hang.ho_ten,khach_hang.so_dien_thoai,
dich_vu.ten_dich_vu,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as soluong,
hop_dong.tien_dat_coc from khach_hang 
join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang
join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
join dich_vu on hop_dong.id_dich_vu = dich_vu.id_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong = hop_dong.id_hop_dong
where ((year(ngay_lam_hop_dong) = 2019 and month(ngay_lam_hop_dong) in(10,11,12))
and hop_dong.id_dich_vu not 
in (select hop_dong.id_dich_vu from hop_dong where year(ngay_lam_hop_dong)=2019 and month(ngay_lam_hop_dong) in(1,2,3,4,5,6)))
group by hop_dong_chi_tiet.id_dich_vu_di_kem;
-- task 13 --
select * from
(select dich_vu_di_kem.ten_dich_vu_di_kem,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as solansudung 
from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_dich_vu_di_kem) as abc
where solansudung = (select count(hop_dong_chi_tiet.id_dich_vu_di_kem) from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
group by hop_dong_chi_tiet.id_dich_vu_di_kem 
order by count(hop_dong_chi_tiet.id_dich_vu_di_kem) desc
limit 1);
-- task 14 --
select hop_dong.id_hop_dong,loai_dich_vu.ten_loai_dich_vu,dich_vu_di_kem.ten_dich_vu_di_kem,
count(hop_dong_chi_tiet.id_dich_vu_di_kem) as solansudung from dich_vu_di_kem
join hop_dong_chi_tiet on hop_dong_chi_tiet.id_dich_vu_di_kem = dich_vu_di_kem.id_dich_vu_di_kem
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having solansudung = 1;
-- task 15 --
select nhan_vien.id_nhan_vien,nhan_vien.ho_ten,trinh_do.trinh_do,bo_phan.ten_bo_phan,nhan_vien.so_dien_thoai,
nhan_vien.dia_chi,count(hop_dong.id_nhan_vien) as solanlamhopdong, 
year(hop_dong.ngay_lam_hop_dong) as nam_hop_dong from bo_phan
join nhan_vien on nhan_vien.id_bo_phan = bo_phan.id_bo_phan
join trinh_do on nhan_vien.id_trinh_do = trinh_do.id_trinh_do
join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien
group by hop_dong.id_nhan_vien
having (nam_hop_dong between 2018 and 2019) and solanlamhopdong <= 3;
-- task 16 --0
delete from nhan_vien where nhan_vien.id_nhan_vien not
in(select hop_dong.id_nhan_vien from hop_dong 
where year(hop_dong.ngay_lam_hop_dong) between 2017 and 2020); 
-- task17 --0
update khach_hang set khach_hang.id_loai_khach = 1 
where khach_hang.id_loai_khach = 2 and khach_hang.id_khach_hang 
in (select hop_dong.id_khach_hang from hop_dong where year(ngay_lam_hop_dong)=2019
and hop_dong.tong_tien >=10000000);
-- task18 --0
delete from khach_hang where exists (select hop_dong.id_khach_hang from hop_dong
 where year(hop_dong.ngay_lam_hop_dong) < 2016 and hop_dong.id_khach_hang = khach_hang.id_khach_hang);

delete from khach_hang where khach_hang.id_khach_hang 
in (select xyz from (select hop_dong.id_khach_hang as xyz from khach_hang
join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang where year(hop_dong.ngay_lam_hop_dong) < 2016) as abc);
-- task19 --0
update dich_vu_di_kem set dich_vu_di_kem.gia = dich_vu_di_kem.gia*2 where dich_vu_di_kem.id_dich_vu_di_kem 
in (select abc from
(select hop_dong_chi_tiet.id_dich_vu_di_kem as abc,count(hop_dong_chi_tiet.id_hop_dong_chi_tiet) as solansudung from hop_dong_chi_tiet 
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong 
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having solansudung > 10) as xyz);
-- task20 --
select nhan_vien.id_nhan_vien,nhan_vien.ho_ten,nhan_vien.email,nhan_vien.so_dien_thoai,nhan_vien.ngay_sinh,
nhan_vien.dia_chi from nhan_vien
union all
select khach_hang.id_khach_hang,khach_hang.ho_ten,khach_hang.email,khach_hang.so_dien_thoai,khach_hang.ngay_sinh,
khach_hang.dia_chi from khach_hang;
