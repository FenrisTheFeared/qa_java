import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionTestParameterized {

    private static Feline feline;
    private final String sex;
    private final boolean expectedHasMane;

    public LionTestParameterized(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] setSexLion() {
        return new Object[][]{
                {"Самка", false},
                {"Самец", true}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualHasMane = lion.doesHaveMane();
        Assert.assertEquals(actualHasMane, expectedHasMane);
    }
}