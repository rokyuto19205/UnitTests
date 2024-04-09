package MockupTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(MockitoJUnitRunner.class)
public class UserTest {
    @Mock
    User mockUser;
    @Test(expected = Exception.class)
    public void testExceptionThrown() {
        when(mockUser.authenticate("19223")).thenThrow(new Exception());
        mockUser.authenticate("19223");
    }
    @Test
    public void testFalseReturned() {
        when(mockUser.authenticate(anyString())).thenReturn(false);
        boolean result = mockUser.authenticate("some_password");
        assertFalse(result);
    }
}
