/*
 * Copyright (c) 2018. Jahir Fiquitiva
 *
 * Licensed under the CreativeCommons Attribution-ShareAlike
 * 4.0 International License. You may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *    http://creativecommons.org/licenses/by-sa/4.0/legalcode
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jahirfiquitiva.libs.kauextensions.extensions

import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.view.Menu
import android.view.MenuItem

fun Menu.changeOptionVisibility(id: Int, visible: Boolean) {
    findItem(id)?.isVisible = visible
}

fun Menu.setItemTitle(id: Int, title: String) {
    findItem(id)?.title = title
}

fun Menu.setOptionIcon(id: Int, @DrawableRes iconRes: Int) {
    findItem(id)?.setIcon(iconRes)
}

fun Menu.setOptionIcon(id: Int, iconRes: Drawable) {
    findItem(id)?.icon = iconRes
}

fun Menu.getItems(): ArrayList<MenuItem?> {
    val items = ArrayList<MenuItem?>()
    for (i in 0 until size()) {
        items += getItem(i)
    }
    return items
}

fun Menu.showAllItems() {
    getItems().forEach { it?.show() }
}

fun Menu.hideAllItems() {
    getItems().forEach { it?.hide() }
}

fun Menu.showAllExcept(toKeepHidden: ArrayList<Int>, hideIfShown: Boolean = true) {
    getItems().forEach {
        it?.let {
            if (!toKeepHidden.contains(it.itemId)) {
                it.show()
            } else {
                if (hideIfShown) else it.hide()
            }
        }
    }
}

fun Menu.hideAllExcept(toKeepShown: ArrayList<Int>, showIfHidden: Boolean = true) {
    getItems().forEach {
        it?.let {
            if (!toKeepShown.contains(it.itemId)) {
                it.hide()
            } else {
                if (showIfHidden) else it.show()
            }
        }
    }
}

fun MenuItem.show() {
    isVisible = true
}

fun MenuItem.hide() {
    isVisible = false
}