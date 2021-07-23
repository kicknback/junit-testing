import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testIfStudentCanBeCreated(){
        Student fer = new Student(1L, "fer");
        Student nullStudent = null;
        assertNotNull(fer);
        assertNull(nullStudent);
    }

    @Test
    public void testIfFieldsAreSet(){
        Student fer = new Student(1L, "fer");
        assertEquals(1L, fer.getId());
        assertEquals("fer", fer.getName());

        Student rosie = new Student(40L, "Rosie");
        assertEquals(40L, rosie.getId());
        assertEquals("Rosie", rosie.getName());
    }

    @Test
    public void testIfAddGradeWorks(){
        Student fer = new Student(1L, "fer");
        assertEquals(0, fer.getGrades().size());
        fer.addGrade(90);
        assertEquals(1, fer.getGrades().size());
        fer.addGrade(70);
        assertEquals(2, fer.getGrades().size());
    }

    @Test
    public void testIfGetGradesWorks(){
        Student fer = new Student(1L, "fer");
        fer.addGrade(90);
        fer.addGrade(70);
        assertSame(90, fer.getGrades().get(0));
        assertSame(70, fer.getGrades().get(1));
    }

    @Test
    public void testIfGetAVGWorks(){
        Student fer = new Student(1L, "fer");
        fer.addGrade(90);
        fer.addGrade(70); // 160 / 2 = 80
        assertEquals(80, fer.getGradeAverage(), 0);
        fer.addGrade(50); // 210 / 3 = 70
        assertEquals(70, fer.getGradeAverage(), 0);
    }

    // TODO: test to make sure that updateGrade works -> use getGradeAverage() to do so.
    //  getGradeAverage() should be what you would expect from updating the lowest grade

    // TODO: do the same for deleteGrade() -> make sure it is deleted by testing the size
    //  of the grades list and checking the new average

    @Test
    public void updateGrade_replaceLowestGrade_updatesGradeAverage() {
        //Arrange
        Student bob = new Student(6, "bob jones");
        //Act
        bob.addGrade(90);
        bob.addGrade(75);
        bob.addGrade(87);
        bob.updateGrade(79);
        //Assert
        Assert.assertEquals(85.333333333, bob.getGradeAverage(),0.001);
    }

    @Test
    public void deleteGrade_deletesLowestGrade_updatesGradeAverage() {
        //Arrange
        Student bob = new Student(6, "bob jones");
        //Act
        bob.addGrade(90);
        bob.addGrade(75);
        bob.addGrade(87);
        bob.deleteGrade();
        //Assert
        Assert.assertEquals(88.5, bob.getGradeAverage(), 0);
    }

}
