/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testshowstudent;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Testshowstudent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    String tenSinhVien, thongTin = null;
    String arrThongTin[];   // mảng lưu trữ thông tin sinh viên
    double diemSinhVien;
         
    // lưu trữ danh sách sinh viên
    LinkedList<String> danhSachSV = new LinkedList<>();
         
    // lưu trữ danh sách sinh viên thi lại
    LinkedList<String> svThiLai = new LinkedList<>();
         
    // lưu trữ danh sách sinh viên có điểm cao nhất
    LinkedList<String> svDiemCao = new LinkedList<>();
         
    // lưu trữ danh sách sinh viên cần tìm
    LinkedList<String> svCanTim = new LinkedList<>();
         
    Scanner scanner = new Scanner(System.in);
         
    // thêm danh sách sinh viên
    // nếu tên sinh viên khác rỗng thì còn nhập
    // ngược lại không nhập nữa
    do {
        System.out.println("Nhập vào tên sinh viên: ");
        tenSinhVien = scanner.nextLine();
        if (!tenSinhVien.isEmpty()) {
            System.out.println("Nhập vào điểm sinh viên: ");
            diemSinhVien = Double.parseDouble(scanner.nextLine());
            thongTin = tenSinhVien + "\t" + diemSinhVien;
            danhSachSV.add(thongTin);
        }
    } while (!tenSinhVien.isEmpty());   // khi tên còn khác rỗng thì còn nhập
         
    // hiển thị số sinh viên
    // và thông tin của các sinh viên có trong danh sách
    System.out.println("Số sinh viên có trong danh sách = " + (danhSachSV.size()));
    System.out.println("Thông tin của các sinh viên vừa nhập là: ");
    System.out.println("Tên sinh viên\t Điểm");
    Iterator<String> iterator = danhSachSV.iterator();
    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
         
    // đếm số sinh viên phải thi lại 
    // và lưu thông tin những sinh viên đó vào trong svThiLai
    for (int i = 0; i < danhSachSV.size(); i++) {
        // lấy sinh viên tại vị trí i trong danhSachSV
        String sv = danhSachSV.get(i);  
 
        // chuyển đổi chuỗi sv thành mảng
        // mảng arrThongTin sẽ chứa tên và điểm của sinh viên đó
        arrThongTin = sv.split("\t");
             
        // arrThongTin[1] sẽ tương ứng với điểm của sinh viên
        // vì nó có kiểu là String nên phải ép kiểu về Double
        // sau đó gán vào biến point
        double point = Double.parseDouble(arrThongTin[1]);
             
        // nếu point <= 5 thì sẽ thêm sinh viên đó
        // vào trong svThiLai
        if (point <= 5) {
            svThiLai.add(sv);
        }
    }
             
    if (svThiLai.isEmpty()) {
        System.out.println("Không có sinh viên phải thi lại!");
    } else {
        System.out.println("Số sinh viên phải thi lại = " + (svThiLai.size()));
        System.out.println("Thông tin của các sinh viên phải thi lại là: ");
        System.out.println("Tên sinh viên\t Điểm");
        iterator = svThiLai.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
         
    double maxTemp = 0; // số điểm lớn nhất
    int i = 0;  // chỉ số của phần tử
         
    // tìm điểm lớn nhất trong danh sách
    while (i < danhSachSV.size()) {
        arrThongTin = danhSachSV.get(i).split("\t");
        // nếu điểm của sinh viên có chỉ số i trong danhSachSV
        // lớn hơn hoặc bằng số điểm lớn nhất maxTemp
        // thì sẽ gán maxTemp bằng điểm của sinh viên đó
        // và tăng i lên 1 sau đó quay lại vòng lặp while
        if (Double.parseDouble(arrThongTin[1]) >= maxTemp) {
            maxTemp = Double.parseDouble(arrThongTin[1]);
        }
        i++;
    }
 
    // tìm sinh viên có điểm cao nhất
    i = 0;
    while (i < danhSachSV.size()) {
        arrThongTin = danhSachSV.get(i).split("\t");
        // duyệt trong danhSachSV
        // nếu có sinh viên nào có số điểm bằng với maxTemp 
        // thì sẽ thêm sinh viên đó vào trong svDiemCao
        if (Double.parseDouble(arrThongTin[1]) == maxTemp) {
            svDiemCao.add(danhSachSV.get(i));
        }
        i++;
    }
         
    System.out.println("Thông tin của các sinh viên có điểm cao nhất là: ");
    System.out.println("Tên sinh viên\t Điểm");
    iterator = svDiemCao.iterator();
    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
         
    // Tìm kiếm theo tên sinh viên
    System.out.println("Nhập tên sinh viên cần tìm: ");
    String search = scanner.nextLine();
         
    i = 0;
    while (i < danhSachSV.size()) {
        // tách thông tin của sinh viên thứ i trong danhSachSV
        // thành 2 mảng lưu trữ tên và điểm số sinh viên đó
        arrThongTin = danhSachSV.get(i).split("\t");
             
        // lấy tên sinh viên trong mảng arrThongTin
        // tên sẽ tương ứng với phần tử thứ 0 trong mảng
        tenSinhVien = arrThongTin[0];
             
        // so sánh tên sinh viên cần tìm với tenSinhVien
        // nếu trùng nhau thì sẽ thêm sinh viên đó vào trong svCanTim
        if (search.equalsIgnoreCase(tenSinhVien)) {
            svCanTim.add(danhSachSV.get(i));
        }
             
        i++;    // tăng i lên 1 và quay lại đầu vòng lặp
    }
         
    System.out.println("Thông tin của các sinh viên tên là " + search + ": ");
    System.out.println("Tên sinh viên\t Điểm");
    iterator = svCanTim.iterator();
    while (iterator.hasNext()) {
        System.out.println(iterator.next());
    }
    
}
}
