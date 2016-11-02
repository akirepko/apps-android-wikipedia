package android.support.design.widget;

import android.support.annotation.NonNull;

import org.junit.Before;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theory;
import org.wikipedia.test.view.FontScale;
import org.wikipedia.test.view.LayoutDirection;
import org.wikipedia.test.view.NullValue;
import org.wikipedia.test.view.ViewTest;
import org.wikipedia.test.view.Visibility;
import org.wikipedia.theme.Theme;

import static android.support.design.widget.PasswordTextInput.OnShowPasswordClickListener;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PasswordTextInputTest extends ViewTest {
    private PasswordTextInput subject;

    @DataPoints public static final Visibility[] VISIBILITIES = Visibility.values();

    @Before public void setUp() {
        setUp(WIDTH_DP_S, LayoutDirection.LOCALE, FontScale.DEFAULT, Theme.LIGHT);
        subject = new PasswordTextInput(ctx());
    }

    @Theory public void testIsPasswordVisible(@NonNull Visibility visibility) {
        if (visibility.visible()) {
            subject.passwordVisibilityToggleRequested();
        }
        assertThat(subject.isPasswordVisible(), is(visibility.visible()));
    }

    @Theory public void testSetOnShowPasswordListener(@NonNull NullValue nul,
                                                      @NonNull Visibility visibility) {
        OnShowPasswordClickListener listener = nul.isNull() ? null : mock(OnShowPasswordClickListener.class);
        if (visibility.visible()) {
            subject.passwordVisibilityToggleRequested();
        }
        subject.setOnShowPasswordListener(listener);
        subject.passwordVisibilityToggleRequested();
        if (listener != null) {
            verify(listener).onShowPasswordClick(eq(!visibility.visible()));
        }
    }
}