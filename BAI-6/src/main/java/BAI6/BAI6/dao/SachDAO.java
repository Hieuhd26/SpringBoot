package BAI6.BAI6.dao;

import BAI6.BAI6.entity.Sach;

import java.util.List;

public interface SachDAO {
    public void saveSach(Sach sach);
    public Sach getSachById(int id);
    public List<Sach> getAll();
    public List<Sach> getSachByTitle(String title);
    public Sach updateSach(Sach sach);
    public void deleteById(int id);
    public void deleteByTitle(String sach);

}
