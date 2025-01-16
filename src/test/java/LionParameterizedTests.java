import com.example.Feline;
import com.example.Lion;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(Parameterized.class)
public class LionParameterizedTests {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    Feline feline;

    private final String sex;
    private final boolean hasMane;

    public LionParameterizedTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters(name = "Класс Lion. Пол: {0}")
    public static Object[][] setSexForLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void doesHaveManeIsCorrect() throws Exception {
        MatcherAssert.assertThat("Грива есть только у льва",
                new Lion(feline, this.sex).doesHaveMane(),
                equalTo(hasMane)
        );

    }

}
