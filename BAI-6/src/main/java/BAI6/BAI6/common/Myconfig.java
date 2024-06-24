package BAI6.BAI6.common;

import BAI6.BAI6.dao.SachDAOImpl;
import BAI6.BAI6.entity.Sach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.plaf.synth.SynthUI;
import java.util.List;
import java.util.Scanner;

@Configuration
public class Myconfig {
    @Bean
    @Autowired
    public CommandLineRunner getRunner(SachDAOImpl sachDAOImpl){
        Scanner sc = new Scanner(System.in);
        return runner->{

            while (true){
                print();
                int choice = sc.nextInt();
                sc.nextLine();
                if(choice==1){
                    System.out.println("Nhập tên sách");
                    String title=sc.nextLine();
                    System.out.println("Nhập tên tác giả");
                    String author=sc.nextLine();
                    System.out.println("Nhập isbn");
                    String isbn=sc.nextLine();
                    Sach sach = new Sach(title,author,isbn);
                    sachDAOImpl.saveSach(sach);
                } else if (choice==2) {
                    findSachNyId(sachDAOImpl);
                } else if (choice==3) {
                    findSachByTitle(sachDAOImpl);
                }else if (choice==4) {
                    getAllSach(sachDAOImpl);
                }else if (choice==5) {
                    updateSachById(sachDAOImpl);
                }else if (choice==6) {
                    deleteSachById(sachDAOImpl);
                }else if (choice==7) {
                    deleteTitle(sachDAOImpl);
                }


            }

        };
    }

    private void deleteTitle(SachDAOImpl sachDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sách");
        String title = sc.nextLine();
        List<Sach> sach = sachDAOImpl.getSachByTitle(title);
        if (sach.isEmpty()) {
            System.out.println("Sách không tồn tại");
        } else {
            sachDAOImpl.deleteByTitle(title);
            System.out.println("Đã xoá sách có tiêu đề: " + title);
        }
    }


    private void deleteSachById(SachDAOImpl sachDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách");
        int id=sc.nextInt();
        sachDAOImpl.deleteById(id);

    }

    private void updateSachById(SachDAOImpl sachDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách");
        int id=sc.nextInt();
        Sach sach = sachDAOImpl.getSachById(id);
        sc.nextLine();
        if(sach ==null){
            System.out.println("không tìm thấy");
        }else{
            System.out.println("Nhập tên sách");
            String title=sc.nextLine();
            System.out.println("Nhập tên tác giả");
            String author=sc.nextLine();
            System.out.println("Nhập isbn");
            String isbn=sc.nextLine();
           sach.setTitle(title);
           sach.setAuthor(author);
           sach.setIsbn(isbn);
            sachDAOImpl.updateSach(sach);
        }
    }

    private void getAllSach(SachDAOImpl sachDAOImpl) {
        List<Sach> sach = sachDAOImpl.getAll();
        for (Sach allSach:sach) {
            System.out.println(allSach);
        }
    }

    private void findSachByTitle(SachDAOImpl sachDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sách");
        String title=sc.nextLine();
        List<Sach> sach = sachDAOImpl.getSachByTitle(title);
        if(sach.size()==0){
            System.out.println("không tìm thấy");
        }else{
            for (Sach allSach:sach) {
                System.out.println(allSach);
            }
        }
    }

    private void findSachNyId(SachDAOImpl sachDAOImpl) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sách");
        int id=sc.nextInt();
        Sach sach = sachDAOImpl.getSachById(id);
        if(sach ==null){
            System.out.println("không tìm thấy");
        }else{
            System.out.println(sach);
        }
    }

    public void print(){
        System.out.println("Vui lòng chọn một trong các phương án sau:");
        System.out.println("1. Thêm");
        System.out.println("2. Tìm sách bằng id");
        System.out.println("3. Tìm sách bằng title");
        System.out.println("4. In tất cả sách");
        System.out.println("5. Cập nhật sách theo id");
        System.out.println("6. Xoá sách theo id");
    }
}
