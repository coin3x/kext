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

package jahirfiquitiva.libs.kauextensions.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import jahirfiquitiva.libs.kauextensions.extensions.getSharedPrefs

open class Konfigurations(val name:String, val context:Context) {
    protected val prefs:SharedPreferences = context.getSharedPrefs(name)
    @SuppressLint("CommitPrefEdits")
    protected val prefsEditor:SharedPreferences.Editor = prefs.edit()
    
    companion object {
        fun newInstance(name:String, context:Context) = Konfigurations(name, context)
    }
    
    var appRunCount:Int
        get() = prefs.getInt(APP_RUN_COUNT, 0)
        set(appRunCount) = prefsEditor.putInt(APP_RUN_COUNT, appRunCount).apply()
    
    var currentTheme:Int
        get() = prefs.getInt(THEME, 0)
        set(theme) = prefsEditor.putInt(THEME, theme).apply()
    
    var hasColoredNavbar:Boolean
        get() = prefs.getBoolean(COLORED_NAVBAR, true)
        set(colored) = prefsEditor.putBoolean(COLORED_NAVBAR, colored).apply()
    
    var lastVersion:Int
        get() = prefs.getInt(LAST_VERSION, 0)
        set(lastVersion) = prefsEditor.putInt(LAST_VERSION, lastVersion).apply()
}