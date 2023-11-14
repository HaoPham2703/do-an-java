import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DSCB danhSachCB = new DSCB();
        danhSachCB.nhapDanhSach();
        danhSachCB.hienThiDanhSach();
    }
}

class CanBo {
    private int maso;
    private String hovaten;
    private int tuoi;
    private String diachi;

    public CanBo() {
    }

    public CanBo(int maso, String hovaten, int tuoi, String diachi) {
        this.maso = maso;
        this.hovaten = hovaten;
        this.tuoi = tuoi;
        this.diachi = diachi;
    }

    public int getMaso() {
        return maso;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void hienThiThongTin() {
        System.out.println("Mã số: " + maso);
        System.out.println("Họ và tên: " + hovaten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Địa chỉ: " + diachi);
    }
}

class CongNhan extends CanBo {
    private int bac;

    public CongNhan(int maso, String hovaten, int tuoi, String diachi, int bac) {
        super(maso, hovaten, tuoi, diachi);
        this.bac = bac;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Bậc: " + bac);
    }
}

class KySu extends CanBo {
    private String nganhdaotao;

    public KySu(int maso, String hovaten, int tuoi, String diachi, String nganhdaotao) {
        super(maso, hovaten, tuoi, diachi);
        this.nganhdaotao = nganhdaotao;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Ngành đào tạo: " + nganhdaotao);
    }
}

class NhanVien extends CanBo {
    private String congviec;

    public NhanVien(int maso, String hovaten, int tuoi, String diachi, String congviec) {
        super(maso, hovaten, tuoi, diachi);
        this.congviec = congviec;
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Công việc: " + congviec);
    }
}

class DSCB {
    private ArrayList<CanBo> danhSachCanBo;

    public DSCB() {
        danhSachCanBo = new ArrayList<>();
    }

    public void themCanBo(CanBo cb) {
        danhSachCanBo.add(cb);
    }

    public void suaCanBo(int maso, CanBo cb) {
        for (int i = 0; i < danhSachCanBo.size(); i++) {
            if (danhSachCanBo.get(i).getMaso() == maso) {
                danhSachCanBo.set(i, cb);
                System.out.println("Đã sửa thông tin cán bộ có mã số " + maso);
                return;
            }
        }
        System.out.println("Không tìm thấy cán bộ có mã số " + maso);
    }
    public void xoaCanBo(int maso) {
        for (int i = 0; i < danhSachCanBo.size(); i++) {
            if (danhSachCanBo.get(i).getMaso() == maso) {
                danhSachCanBo.remove(i);
                System.out.println("Đã xóa cán bộ có mã số " + maso);
                return;
            }
        }
        System.out.println("Không tìm thấy cán bộ có mã số " + maso);
    }

    public void timKiemTheoHoTen(String hoTen) {
        for (CanBo cb : danhSachCanBo) {
            if (cb.getHovaten().equalsIgnoreCase(hoTen)) {
                cb.hienThiThongTin();
                return;
            }
        }
        System.out.println("Không tìm thấy cán bộ có họ tên " + hoTen);
    }

    public void nhapDanhSach() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng cán bộ: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin cán bộ thứ " + (i + 1));
            System.out.print("Chọn loại cán bộ (1: Công nhân, 2: Kỹ sư, 3: Nhân viên): ");
            int loaiCanBo = scanner.nextInt();
            System.out.print("Nhập mã số: ");
            int maso = scanner.nextInt();
            System.out.print("Nhập họ và tên: ");
            String hovaten = scanner.next();
            System.out.print("Nhập tuổi: ");
            int tuoi = scanner.nextInt();
            System.out.print("Nhập địa chỉ: ");
            String diachi = scanner.next();

            switch (loaiCanBo) {
                case 1:
                    System.out.print("Nhập bậc: ");
                    int bac = scanner.nextInt();
                    CongNhan congNhan = new CongNhan(maso, hovaten, tuoi, diachi, bac);
                    themCanBo(congNhan);
                    break;
                case 2:
                    System.out.print("Nhập ngành đào tạo: ");
                    String nganhDaoTao = scanner.next();
                    KySu kySu = new KySu(maso, hovaten, tuoi, diachi, nganhDaoTao);
                    themCanBo(kySu);
                    break;
                case 3:
                    System.out.print("Nhập công việc: ");
                    String congViec = scanner.next();
                    NhanVien nhanVien = new NhanVien(maso, hovaten, tuoi, diachi, congViec);
                    themCanBo(nhanVien);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
                    i--; // Nhập lại thông tin cho cán bộ này.
                    break;
            }
        }
    }

    public void hienThiDanhSach() {
        for (CanBo cb : danhSachCanBo) {
            cb.hienThiThongTin();
            System.out.println("-------------------------");
        }
    }
}
