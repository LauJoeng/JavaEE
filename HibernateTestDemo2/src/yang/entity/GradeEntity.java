package yang.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "grade", schema = "hibernate2", catalog = "")
public class GradeEntity implements Serializable{
    private int gid;
    private String gname;
    private String gdesc;

    private Set<StudentEntity>students = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL )
    @JoinColumn(table = "student",name = "gid")
    public Set<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(Set<StudentEntity> students) {
        this.students = students;
    }

    @Id
    @Column(name = "gid")
    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    @Basic
    @Column(name = "gname")
    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    @Basic
    @Column(name = "gdesc")
    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GradeEntity that = (GradeEntity) o;
        return gid == that.gid &&
                Objects.equals(gname, that.gname) &&
                Objects.equals(gdesc, that.gdesc);
    }

    @Override
    public int hashCode() {

        return Objects.hash(gid, gname, gdesc);
    }
}
