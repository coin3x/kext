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

package jahirfiquitiva.libs.kauextensions.ui.views

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet
import jahirfiquitiva.libs.kauextensions.R

open class LandscapeImageView:AppCompatImageView {
    
    private var heightDivider:Float = 3F
    
    constructor(context:Context):super(context)
    constructor(context:Context, attributeSet:AttributeSet):super(context, attributeSet) {
        init(context, attributeSet)
    }
    
    constructor(context:Context, attributeSet:AttributeSet, defStyleAttr:Int)
            :super(context, attributeSet, defStyleAttr) {
        init(context, attributeSet)
    }
    
    private fun init(context:Context, attributeSet:AttributeSet) {
        val a = context.obtainStyledAttributes(attributeSet, R.styleable.LandscapeImageView, 0, 0)
        try {
            heightDivider = a.getFloat(R.styleable.LandscapeImageView_heightDivider, 3F)
        } finally {
            a.recycle()
        }
    }
    
    override fun onMeasure(widthMeasureSpec:Int, heightMeasureSpec:Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, (measuredWidth / heightDivider).toInt())
    }
}