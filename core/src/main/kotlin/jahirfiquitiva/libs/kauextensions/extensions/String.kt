/*
 * Copyright (c) 2017. Jahir Fiquitiva
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

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v4.content.res.ResourcesCompat

fun String.getBitmap(context: Context): Bitmap? =
        this.getBitmapDrawable(context)?.bitmap

fun String.getBitmapDrawable(context: Context): BitmapDrawable? {
    try {
        return ResourcesCompat.getDrawable(
                context.resources,
                this.getIconResource(context),
                null) as BitmapDrawable?
    } catch (e: Exception) {
        throw Resources.NotFoundException("Icon with name ${this} could not be found")
    }
}

fun String.getDrawable(context: Context): Drawable {
    try {
        return ContextCompat.getDrawable(context, this.getIconResource(context))
    } catch (e: Exception) {
        throw Resources.NotFoundException("Icon with name ${this} could not be found")
    }
}

fun String.getIconResource(context: Context): Int {
    val res = context.resources.getIdentifier(this, "drawable", context.packageName)
    return if (res != 0) res else 0
}

fun String.hasContent() = isNotBlank() && isNotEmpty()

fun String.formatCorrectly() =
        replace("[^\\w\\s]+".toRegex(), " ").trim().replace(" +".toRegex(), " ").replace(
                "\\p{Z}".toRegex(), "_")

fun String.toTitleCase(): String {
    val titleCase = StringBuilder()
    var nextTitleCase = true
    for (c in toLowerCase().toCharArray()) {
        var rc = c
        if (Character.isSpaceChar(rc)) {
            nextTitleCase = true
        } else if (nextTitleCase) {
            rc = Character.toTitleCase(c)
            nextTitleCase = false
        }
        titleCase.append(rc)
    }
    return titleCase.toString()
}