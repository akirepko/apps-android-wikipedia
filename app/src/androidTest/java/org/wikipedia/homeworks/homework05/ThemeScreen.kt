package org.wikipedia.homeworks.homework05

import androidx.appcompat.widget.AppCompatImageView
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.progress.KSeekBar
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.wikipedia.R

val titleDialogTheme = KTextView { withId(R.id.textSettingsCategory) }

val sizeText = KTextView { withId(R.id.text_size_percent) }

val buttonDecreaseTextSize = KTextView { withId(R.id.buttonDecreaseTextSize) }

val buttonIncreaseTextSize = KTextView { withId(R.id.buttonIncreaseTextSize) }

val textSizeBar = KSeekBar { withId(R.id.text_size_seek_bar) }

val sansSerifButton = KButton { withId(R.id.button_font_family_sans_serif) }

val SerifButton = KButton { withId(R.id.button_font_family_serif) }

val glassImage = KImageView { withDrawable(R.drawable.ic_icon_reading_focus_mode) }

val glassImageFromLesson = KImageView { withParent {withId(R.id.reading_list_header)
 isInstanceOf(AppCompatImageView::class.java)
} }

val focusSwitcher = KSwitch { withId(R.id.theme_chooser_reading_focus_mode_switch) }

val themeChooseTitle = KTextView { withText(R.string.color_theme_select) }

val lightThemeButton = KButton { withId(R.id.button_theme_light) }

val sepiaThemeButton = KButton { withId(R.id.button_theme_sepia) }

val darkThemeButton = KButton { withId(R.id.button_theme_dark) }

val blackThemeButton = KButton { withId(R.id.button_theme_black) }

val darkThemeSwitcher = KSwitch { withId(R.id.theme_chooser_dark_mode_dim_images_switch) }

val systemThemeSwitcher = KSwitch { withId(R.id.theme_chooser_match_system_theme_switch) }