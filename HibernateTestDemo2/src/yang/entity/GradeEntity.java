package yang.entity;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "grade", schema = "hibernate", catalog = "")
public class GradeEntity implements Serializable{
    private int gid;
    private String gname;
    private String gdesc;
    private Set<StudentEntity> student = new HashSet<>();

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


    @OneToMany
    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "gid")
    public Set<StudentEntity> getStudent() {
        return student;
    }

    public void setStudent(Set<StudentEntity> student) {
        this.student = student;
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
